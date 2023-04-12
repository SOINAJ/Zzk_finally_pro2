package com.example.zzk_finaly_pro_1.service;

import com.example.zzk_finaly_pro_1.POJO.Complain_zzk;
import com.example.zzk_finaly_pro_1.POJO.Foodmes_zzk;
import com.example.zzk_finaly_pro_1.dao.FoodmesDao;
import com.example.zzk_finaly_pro_1.util.Bootstrap;
import com.example.zzk_finaly_pro_1.util.Result;
import com.example.zzk_finaly_pro_1.util.Works_Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodmesService {

    @Autowired
    private FoodmesDao foodmesDao;

    public Result post_new_food(String data){
        String[] need_data = Works_Util.deal_newfood_data(data);
        Integer oh = foodmesDao.post_newFood(new Foodmes_zzk(need_data[0],Integer.valueOf(need_data[1]),Integer.valueOf(need_data[2])));
        return Result.Save_ativition(oh);
    }

    public Bootstrap getAll_foodmes(String offset,String limit){
        List<Foodmes_zzk> list = null;
        if (offset != null && limit != null){
            list = foodmesDao.getAll_mes(offset, limit);
        }
//        List<Foodmes_zzk> list = foodmesDao.getAll_mes(offset, limit);
        List<Foodmes_zzk> number = foodmesDao.getAll_mes_num();
        return new Bootstrap(list,number.size());
    }

    public Result updata_newfood(String data){
        String[] deal_newfood = Works_Util.updata_newfood(data);
        Integer integer = foodmesDao.update_mes(new Foodmes_zzk(Integer.valueOf(deal_newfood[0]), Integer.valueOf(deal_newfood[1])));
        return Result.Update_ativition(integer);
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
                okn = foodmesDao.delete_mes(mydata.substring(0,mydata.length()-1));
            }
            return Result.Delete_ativition(okn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Result.Delete_ativition("");
    }
}
