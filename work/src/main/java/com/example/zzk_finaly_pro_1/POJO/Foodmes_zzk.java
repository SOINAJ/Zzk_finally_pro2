package com.example.zzk_finaly_pro_1.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Foodmes_zzk {
    private int id;
    private String food;
//    private int number_cai;
    private int stack;


    public Foodmes_zzk(String food, int stack) {
        this.food = food;
        this.stack = stack;
    }

    public Foodmes_zzk(int id, int stack) {
        this.id = id;
        this.stack = stack;
    }
}
