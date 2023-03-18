package com.example.zzk_finaly_pro_1.service;

import com.example.zzk_finaly_pro_1.POJO.Open_zhuo_zzk;
import com.example.zzk_finaly_pro_1.POJO.Table_zzk;
import com.example.zzk_finaly_pro_1.dao.Open_zhuo_zzxDao;
import com.example.zzk_finaly_pro_1.dao.Table_zzkDao;
import com.example.zzk_finaly_pro_1.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Table_zzkServiec {

    @Autowired
    private Table_zzkDao table_zzkDao;

    @Autowired
    private Open_zhuo_zzxDao open_zhuo_zzk;

    public Result loginsys(String username,String work_num){
        Table_zzk loginsys = table_zzkDao.loginsys(username);
        if (loginsys != null){
            open_zhuo_zzk.insert_Open(new Open_zhuo_zzk(username,work_num));
        }

        table_zzkDao.loginsys_state(username);
        return Result.Get_ativition(loginsys);
    }

    public Result logonsys(String username){
        Integer logonsys = table_zzkDao.logonsys(username.substring(username.indexOf("=")+1));
        return Result.Update_ativition(logonsys);
    }
}
