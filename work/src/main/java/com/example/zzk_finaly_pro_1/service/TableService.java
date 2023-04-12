package com.example.zzk_finaly_pro_1.service;

import com.example.zzk_finaly_pro_1.POJO.Table_zzk;
import com.example.zzk_finaly_pro_1.dao.Table_zzkDao;
import com.example.zzk_finaly_pro_1.util.Bootstrap;
import com.example.zzk_finaly_pro_1.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {

    @Autowired
    private Table_zzkDao table_zzkDao;

    public Bootstrap getAll_table(String offset, String limit){
        List<Table_zzk> table_all = table_zzkDao.get_table_all(offset, limit);
        return new Bootstrap(table_all,table_all.size());
    }

    public Result update_0(String datas){
        String data = datas.substring(1,datas.length()-1);
        Integer integer = table_zzkDao.update_Open(data);
        return Result.Update_ativition(integer);
    }
}
