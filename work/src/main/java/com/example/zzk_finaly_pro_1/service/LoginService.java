package com.example.zzk_finaly_pro_1.service;

import com.example.zzk_finaly_pro_1.POJO.Login_zzk;
import com.example.zzk_finaly_pro_1.dao.LoginDao;
import com.example.zzk_finaly_pro_1.util.Bootstrap;
import com.example.zzk_finaly_pro_1.util.Result;
import com.example.zzk_finaly_pro_1.util.Works_Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LoginService {

    @Autowired
    private LoginDao login;

    public Login_zzk login_sys(String username,String passwd){
        return login.login_sys(username, passwd);
    }

    public Result delete_login(String[] data){
        try {
            String mydata = "";
            Integer okn = 0;
            for (String datum : data) {
                mydata += datum;
                mydata += ",";
            }
            if (!mydata.equals("")){
                okn = login.delete_login(mydata.substring(0,mydata.length()-1));
            }
            return Result.Delete_ativition(okn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Result.Delete_ativition("");
    }

    public Bootstrap get_All_login(String offset, String limit){
        List<Login_zzk> list = null;
        if (offset != null && limit != null){
            list = login.getLogin(offset,limit);
        }
        return new Bootstrap(list,list.size());
    }

    public Result new_Login(String account,String passwd,String name){
        Integer integer = login.newLogin(new Login_zzk(account, passwd, name));
//        String[] need_data = Works_Util.deal_newfood_data(data);
//        Integer oh = foodmesDao.post_newFood(new Foodmes_zzk(need_data[0],Integer.valueOf(need_data[1])));
        return Result.Save_ativition(integer);
    }

    public Result new_Login(String data){

        String[] need_data = Works_Util.deal_newlogin_data(data);
        Integer integer = login.newLogin(new Login_zzk(need_data[0],need_data[1],need_data[2]));
//        Integer oh = foodmesDao.post_newFood(new Foodmes_zzk(need_data[0],Integer.valueOf(need_data[1])));
        return Result.Save_ativition(integer);
    }
}
