package com.example.zzk_finaly_pro_1.service;

import com.example.zzk_finaly_pro_1.POJO.Goods_zzk;
import com.example.zzk_finaly_pro_1.dao.Foodmes_zzkDao;
import com.example.zzk_finaly_pro_1.dao.Goods_zzkDao;
import com.example.zzk_finaly_pro_1.util.Bootstrap;
import com.example.zzk_finaly_pro_1.util.Result;
import com.example.zzk_finaly_pro_1.util.Works_Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Goods_zzkService {

    @Autowired
    private Goods_zzkDao goods_zzkDaol;

    @Autowired
    private Foodmes_zzkDao foodmes_zzkDao;

    public Result insert_newGoods(String data){
        Goods_zzk goods_zzk = Works_Util.GoodsUtil(data);
        Integer integer = goods_zzkDaol.insert_newGoods(goods_zzk);
        foodmes_zzkDao.updata_mes(String.valueOf(goods_zzk.getNumber_cai()));
        return Result.Save_ativition(integer);
    }

    public Bootstrap getAll_goodsmes(String number){
        List<Goods_zzk> mes = goods_zzkDaol.get_mes(number);
        return new Bootstrap(mes);
    }

    public Bootstrap getAll_goodsmes_finsh(String number){
        List<Goods_zzk> mes_finsh = goods_zzkDaol.get_mes_finsh(number);
        return new Bootstrap(mes_finsh);
    }
}
