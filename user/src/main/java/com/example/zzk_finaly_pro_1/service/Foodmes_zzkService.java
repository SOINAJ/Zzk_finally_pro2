package com.example.zzk_finaly_pro_1.service;

import com.example.zzk_finaly_pro_1.POJO.Foodmes_zzk;
import com.example.zzk_finaly_pro_1.dao.Foodmes_zzkDao;
import com.example.zzk_finaly_pro_1.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Foodmes_zzkService {

    @Autowired
    private Foodmes_zzkDao foodmes_zzkDao;

    public Result get_number(){
        Integer number = foodmes_zzkDao.get_number();
        return Result.Get_ativition(number);
    }

    public Result get_mes(String number){
        Integer num = Integer.valueOf(number);
        List<Foodmes_zzk> food_mes = foodmes_zzkDao.get_food_mes((num - 1) * 6);
        return Result.Get_ativition(food_mes);
    }
}
