package com.example.zzk_finaly_pro_1.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login_zzk {
    private int id;
    private String account;
    private String passwd;
    private int role;
    private String name;

    public Login_zzk(String account, String passwd,  String name) {
        this.account = account;
        this.passwd = passwd;
        this.name = name;
    }
}
