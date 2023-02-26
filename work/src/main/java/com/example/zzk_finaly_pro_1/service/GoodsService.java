package com.example.zzk_finaly_pro_1.service;

import com.example.zzk_finaly_pro_1.POJO.Goods_zzk;
import com.example.zzk_finaly_pro_1.dao.FoodmesDao;
import com.example.zzk_finaly_pro_1.dao.GoodsDao;
import com.example.zzk_finaly_pro_1.util.Bootstrap;
import com.example.zzk_finaly_pro_1.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private FoodmesDao foodmesDao;

    public Bootstrap getAll_goods(String offset,String limit){
        List<Goods_zzk> list = null;
        if (offset != null && limit != null){
            list = goodsDao.getAll_mes1(offset, limit);
        }
        Integer number = list.size();
        return new Bootstrap(list,number);
    }

    public Result delete_food(String[] data){
        try {
            String mydata = "";
            Integer okn = 0;
            for (String datum : data) {
                mydata += datum;
                mydata += ",";
            }
            if (!mydata.equals("")){
                okn = goodsDao.delete_goods(mydata.substring(0,mydata.length()-1));
                foodmesDao.delete_good_stack("add",mydata.substring(0,mydata.length()-1));
            }
            return Result.Delete_ativition(okn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Result.Delete_ativition("");
    }

    public Result finsh_food(String[] data){
        try {
            String mydata = "";
            Integer okn = 0;
            for (String datum : data) {
                mydata += datum;
                mydata += ",";
            }
            if (!mydata.equals("")){
                okn = goodsDao.finsh_goods(mydata.substring(0,mydata.length()-1));
                foodmesDao.delete_good_stack("del",mydata.substring(0,mydata.length()-1));
            }
            return Result.Delete_ativition(okn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Result.Delete_ativition("");
    }
}
