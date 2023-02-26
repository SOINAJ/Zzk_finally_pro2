package com.example.zzk_finaly_pro_1.POJO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Complain_zzk {
    private int id;
    private int number_zhuo;
    private String worker;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date date;
    private String message;


}
