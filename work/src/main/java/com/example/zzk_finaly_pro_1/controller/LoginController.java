package com.example.zzk_finaly_pro_1.controller;


import com.example.zzk_finaly_pro_1.POJO.Login_zzk;
import com.example.zzk_finaly_pro_1.service.LoginService;
import com.example.zzk_finaly_pro_1.util.Bootstrap;
import com.example.zzk_finaly_pro_1.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Controller
public class LoginController {


    @Autowired
    private LoginService login;

    @Autowired
    private HttpServletResponse response;

    public void setCookieData(String acc,String name,String pwd,String role){

        Cookie mycookie1 = new Cookie("mysysAcc",acc);
        Cookie mycookie2 = new Cookie("mysysName",name);
        Cookie mycookie3 = new Cookie("mysysPwd",pwd);
        Cookie mycookie4 = new Cookie("mysysRole",role);

        mycookie1.setMaxAge(24 * 60 * 60);
        mycookie2.setMaxAge(24 * 60 * 60);
        mycookie3.setMaxAge(24 * 60 * 60);
        mycookie4.setMaxAge(24 * 60 * 60);

        response.addCookie(mycookie1);
        response.addCookie(mycookie2);
        response.addCookie(mycookie3);
        response.addCookie(mycookie4);
    }


    @PostMapping("/loginSystem")
    public String loginSystem(String username,String passwd){
//        System.out.println(username+passwd);

        try {
            Login_zzk login_zzk = login.login_sys(username, passwd);
            switch (login_zzk.getRole()){
                case 1:
                    setCookieData(login_zzk.getAccount(),login_zzk.getName(),login_zzk.getPasswd(),String.valueOf(login_zzk.getRole()));
                    return "file/index";
                case 0:
                    setCookieData(login_zzk.getAccount(),login_zzk.getName(),login_zzk.getPasswd(),String.valueOf(login_zzk.getRole()));
                    return "file/index_work";
                default:
                    return "login";
            }
        } catch (Exception e) {
            return "login";
        }

    }

    @PostMapping("/logonSystem")
    @ResponseBody
    public Result logonNewLogin(@RequestBody String data){
        return login.new_Login(data);
    }

    @PutMapping("/login/d")
    @ResponseBody
    public Result delete_login(@RequestBody String[] data){
        return login.delete_login(data);
    }

    @GetMapping("/login/g")
    @ResponseBody
    public Bootstrap get_All_login(String offset, String limit){
        return login.get_All_login(offset,limit);
    }

    @RequestMapping("/")
    public String hello(){
        return "login";
    }
}
