package com.example.zzk_finaly_pro_1.controller;

import com.example.zzk_finaly_pro_1.POJO.Table_zzk;
import com.example.zzk_finaly_pro_1.service.Table_zzkServiec;
import com.example.zzk_finaly_pro_1.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@Controller
public class LoginController {
    @Autowired
    private HttpServletResponse response;

    @Autowired
    private Table_zzkServiec table_zzkServiec;

    public void setCookieData(Integer mysyszhuo){

        Cookie mycookie1 = new Cookie("mysyszhuo",String.valueOf(mysyszhuo));

        mycookie1.setMaxAge(24 * 60 * 60);

        response.addCookie(mycookie1);

    }

    @PostMapping("/loginSystem")
    public String login(String username){

        try {
            Result loginsys = table_zzkServiec.loginsys(username);
            switch (loginsys.getCode()){
                case 20011:
                    Table_zzk table_zzk = (Table_zzk) loginsys.getData();
                    setCookieData(table_zzk.getId());
                    return "file/index";
                case 20010:
                default:
                    return "login";
            }
        } catch (Exception e) {
            return "login";
        }
    }

    @PostMapping("/logoutSystem")
    @ResponseBody
    public Result logout(@RequestBody String username){
        return table_zzkServiec.logonsys(username);
    }
}
