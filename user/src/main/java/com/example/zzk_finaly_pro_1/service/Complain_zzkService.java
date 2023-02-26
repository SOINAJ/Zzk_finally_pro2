package com.example.zzk_finaly_pro_1.service;

import com.example.zzk_finaly_pro_1.POJO.Complain_zzk;
import com.example.zzk_finaly_pro_1.dao.Complain_zzkDao;
import com.example.zzk_finaly_pro_1.util.Result;
import com.example.zzk_finaly_pro_1.util.Works_Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Complain_zzkService {

    @Autowired
    private Complain_zzkDao complain_zzkDao;

    public Result insert_newComplain(String data){
        Integer integer = complain_zzkDao.insert_newComplain(Works_Util.ComplainUtil(data));
        return Result.Save_ativition(integer);
    }
}
