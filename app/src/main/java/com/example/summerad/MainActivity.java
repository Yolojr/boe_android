package com.example.summerad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.example.summerad.Client.JWebSocketClient;

import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.Date;
import java.util.logging.ErrorManager;

public class MainActivity extends AppCompatActivity {

    private TextView showMessage;
//    private EditText editText;
    private JWebSocketClient client;
    private StringBuilder sb = new StringBuilder();
    private ErrorManager XToastUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void createWebSocketClient(String userId){
//        websocket要修改
        URI uri = URI.create("ws://172.25.204.62:8082/websocket/"+userId);
        client = new JWebSocketClient(uri){
            @Override
            public void onOpen(ServerHandshake handshakedata) {
                super.onOpen(handshakedata);
                sb.append("onOpen at time：");
                sb.append(new Date());
                sb.append("服务器状态：");
                sb.append(handshakedata.getHttpStatusMessage());
                sb.append("\n");
                showMessage.setText(sb.toString());
            }

            @Override
            public void onMessage(String message) {
                super.onMessage(message);
                Message handlerMessage = Message.obtain();
                handlerMessage.obj = message;
                handler.sendMessage(handlerMessage);
            }

            @Override
            public void onClose(int code, String reason, boolean remote) {
                super.onClose(code, reason, remote);
                sb.append("onClose at time：");
                sb.append(new Date());
                sb.append("\n");
                sb.append("onClose info:");
                sb.append(code);
                sb.append(reason);
                sb.append(remote);
                sb.append("\n");
                showMessage.setText(sb.toString());
            }

            @Override
            public void onError(Exception ex) {
                super.onError(ex);
                sb.append("onError at time：");
                sb.append(new Date());
                sb.append("\n");
                sb.append(ex);
                sb.append("\n");
                showMessage.setText(sb.toString());
            }
        };
        try {
            client.connectBlocking();
        } catch (InterruptedException e) {
            e.printStackTrace();
            XToastUtils.error( "error",e,0);
        }

    }


    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            sb.append("服务器返回数据：");
            sb.append(msg.obj.toString());
            sb.append("\n");
            showMessage.setText(sb.toString());
            return true;
        }
    });

}