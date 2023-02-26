package com.example.zzk_finaly_pro_1.util;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bootstrap {
    private Object rows;
    private Integer total;

    public Bootstrap(Object rows) {
        this.rows = rows;
    }
}
