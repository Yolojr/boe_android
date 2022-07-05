package com.example.summerad.Client;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


import com.alibaba.fastjson.JSON;
import com.example.summerad.Program;
import com.example.summerad.PubNotice;
import com.example.summerad.R;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class WebClient extends WebSocketClient{
    public static final String ACTION_RECEIVE_MESSAGE = "com.jinuo.mhwang.servermanager";
    public static final String KEY_RECEIVED_DATA = "data";
    private static WebClient mWebClient;
    private ImageView imageview;
    private TextView textView;
    private Context mContext;
    /**
     *  路径为ws+服务器地址+服务器端设置的子路径+参数（这里对应服务器端机器编号为参数）
     *  如果服务器端为https的，则前缀的ws则变为wss
     */
    private static final String mAddress = "ws://10.0.2.2:8081/websocket/";
    private void showLog(String msg){
        Log.d("WebClient---->", msg);
    }
    private WebClient(URI serverUri, Context context){
        super(serverUri, new Draft_6455());
        mContext = context;
        showLog("WebClient");
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        showLog("open->"+handshakedata.toString());
    }

    @Override
    public void onMessage(String message) {
        showLog("onMessage->"+message);
        networkRequest();
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        showLog("onClose->"+reason);
    }

    @Override
    public void onError(Exception ex) {
        showLog("onError->"+ex.toString());
    }

    /** 初始化
     * @param vmc_no
     */
    public static void initWebSocket(final Context context, final long vmc_no){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mWebClient = new WebClient(new URI(mAddress+vmc_no), context);
                    try {
                        mWebClient.connectBlocking();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    private void networkRequest(){

        String  url1 = "http://10.0.2.2:8081/pub-notice";
        HttpURLConnection connection=null;

        try {
            URL url = new URL(url1);
            connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(3000);
            connection.setReadTimeout(3000);

            //设置请求方式 GET / POST 一定要大小
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoOutput(false);
            connection.connect();

            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new IOException("HTTP error code" + responseCode);
            }

            String result = getStringByStream(connection.getInputStream());

            System.out.println(result);

//            JSONObject res = new JSONObject(result);

//            Program program = new Program();
//            program.setProgramImg(res.get("programImg").toString());

            notice(result);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //公告
    private void notice(String result){

        List<PubNotice> pubNoticeList = JSON.parseArray(result, PubNotice.class);
        PubNotice pubNotice = pubNoticeList.get(3);

        textView = (TextView) ((Activity)this.mContext).findViewById(R.id.textView);

        ((Activity)this.mContext).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.setTextSize(pubNotice.getPubNoticeTextsize());
//                textView.setTextColor(pubNotice.getPubNoticeTextcolor());
                textView.setText(pubNotice.getPubNoticeContent());
            }
        });

    }

    //节目
    private void program(String result) throws IOException {

        imageview = (ImageView) ((Activity)this.mContext).findViewById(R.id.imageView);
        Bitmap bitmap = getBitmap("http://10.0.2.2:8081/img/2022-06-181/148dceed-6c1b-49d1-9d3b-f4e68832cf4e.jpg");

        //图片
        ((Activity)this.mContext).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                imageview.setImageBitmap(bitmap);

            }
        });

    }

    private String getStringByStream(InputStream inputStream){
        Reader reader;
        try {
            reader=new InputStreamReader(inputStream,"UTF-8");
            char[] rawBuffer=new char[512];
            StringBuffer buffer=new StringBuffer();
            int length;
            while ((length=reader.read(rawBuffer))!=-1){
                buffer.append(rawBuffer,0,length);
            }
            return buffer.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

//
//    /** 发送消息广播
//     * @param message
//     */
////    private void sendMessageBroadcast(String message){
////        if (!message.isEmpty()){
////            Intent intent = new Intent();
////            intent.setAction(ACTION_RECEIVE_MESSAGE);
////            intent.putExtra(KEY_RECEIVED_DATA,message);
//////            showLog("发送收到的消息");
//////            mContext.sendBroadcast(intent);
////        }
////    }

//    public void getMsg(){
//        Code code = new Code();
////        return code;
//        System.out.println(code.getCodeID());
//        System.out.println(code.getMsg());
//    }

    public Bitmap getBitmap(String path) throws IOException {
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == 200) {
                InputStream inputStream = conn.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                return bitmap;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }



}