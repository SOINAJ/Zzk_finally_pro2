package com.example.zzk_finaly_pro_1.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods_zzk {
    private int id;
    private int number_cai;
    private int number_zhuo;
    private String way;
    private int state;
private int state1;
    private String food;


    public Goods_zzk(int id, int number_cai, int number_zhuo, String way, int state) {
        this.id = id;
        this.number_cai = number_cai;
        this.number_zhuo = number_zhuo;
        this.way = way;
        this.state = state;
    }
}
