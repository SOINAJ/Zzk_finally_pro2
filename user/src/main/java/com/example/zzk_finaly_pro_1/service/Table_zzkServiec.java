package com.example.zzk_finaly_pro_1.service;

import com.example.zzk_finaly_pro_1.POJO.Table_zzk;
import com.example.zzk_finaly_pro_1.dao.Table_zzkDao;
import com.example.zzk_finaly_pro_1.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Table_zzkServiec {

    @Autowired
    private Table_zzkDao table_zzkDao;

    public Result loginsys(String username){
        Table_zzk loginsys = table_zzkDao.loginsys(username);
        table_zzkDao.loginsys_state(username);
        return Result.Get_ativition(loginsys);
    }

    public Result logonsys(String username){
        Integer logonsys = table_zzkDao.logonsys(username.substring(username.indexOf("=")+1));
        return Result.Update_ativition(logonsys);
    }
}
