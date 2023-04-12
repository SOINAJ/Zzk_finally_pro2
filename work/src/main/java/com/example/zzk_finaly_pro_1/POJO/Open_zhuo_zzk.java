package com.example.zzk_finaly_pro_1.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Open_zhuo_zzk {
    private int id;
    private String zhuo_number;
    private String work_number;

    public Open_zhuo_zzk(String zhuo_number, String work_number) {
        this.zhuo_number = zhuo_number;
        this.work_number = work_number;
    }
}
