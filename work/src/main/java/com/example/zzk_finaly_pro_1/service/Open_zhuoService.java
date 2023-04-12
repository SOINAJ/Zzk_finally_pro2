package com.example.zzk_finaly_pro_1.service;

import com.example.zzk_finaly_pro_1.POJO.Open_zhuo_zzk;
import com.example.zzk_finaly_pro_1.dao.Open_zhuo_zzxDao;
import com.example.zzk_finaly_pro_1.dao.Table_zzkDao;
import com.example.zzk_finaly_pro_1.util.Bootstrap;
import com.example.zzk_finaly_pro_1.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Open_zhuoService {

    @Autowired
    private Open_zhuo_zzxDao open_zhuo_zzx;

    @Autowired
    private Table_zzkDao table_zzkDao;

    public Bootstrap getAll_open(String offset,String limit){
        List<Open_zhuo_zzk> open_all = open_zhuo_zzx.get_open_all(offset, limit);
        return new Bootstrap(open_all,open_all.size());
    }

    public Result update_1(String[] datas,String acc){
        String data1 = "";
        for (String data : datas) {
            data1 +="'"+ data + "',";
            open_zhuo_zzx.insert_Open(new Open_zhuo_zzk(data,acc));
        }
        Integer integer = table_zzkDao.update_Open_1(data1.substring(0,data1.length()-1));
        return Result.Update_ativition(integer);
    }
}
