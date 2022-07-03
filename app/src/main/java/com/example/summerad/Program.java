package com.example.summerad;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Program {
    private String programImg;

    private String programName;

    public String getProgramImg() {
        return programImg;
    }

    public void setProgramImg(String programImg) {
        this.programImg = programImg;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }
}
