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
    private Integer pubProgramId;

    private String pubProgramImg;


    public Integer getPubProgramId() {
        return pubProgramId;
    }

    public String getPubProgramImg() {
        return pubProgramImg;
    }
}
