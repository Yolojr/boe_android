package com.example.summerad;
import java.time.LocalDateTime;

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
    private Integer programId;

    private String programImg;

    private String programName;

    private String resolvingPower;

    private String programTime;

    private String programSize;

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    public void setProgramImg(String programImg) {
        this.programImg = programImg;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public void setResolvingPower(String resolvingPower) {
        this.resolvingPower = resolvingPower;
    }

    public void setProgramTime(String programTime) {
        this.programTime = programTime;
    }

    public void setProgramSize(String programSize) {
        this.programSize = programSize;
    }

    public void setProgramState(Integer programState) {
        this.programState = programState;
    }

    public void setProgramAuthor(String programAuthor) {
        this.programAuthor = programAuthor;
    }

    public void setProgramUpdate(LocalDateTime programUpdate) {
        this.programUpdate = programUpdate;
    }

    private Integer programState;

    private String programAuthor;

    private LocalDateTime programUpdate;

    public Integer getProgramId() {
        return programId;
    }

    public String getProgramImg() {
        return programImg;
    }

    public String getProgramName() {
        return programName;
    }

    public String getResolvingPower() {
        return resolvingPower;
    }

    public String getProgramTime() {
        return programTime;
    }

    public String getProgramSize() {
        return programSize;
    }

    public Integer getProgramState() {
        return programState;
    }

    public String getProgramAuthor() {
        return programAuthor;
    }

    public LocalDateTime getProgramUpdate() {
        return programUpdate;
    }
}
