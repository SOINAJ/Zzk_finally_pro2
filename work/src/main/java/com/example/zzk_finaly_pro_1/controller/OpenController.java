package com.example.zzk_finaly_pro_1.controller;

import com.example.zzk_finaly_pro_1.service.Open_zhuoService;
import com.example.zzk_finaly_pro_1.util.Bootstrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/opens")
public class OpenController {

    @Autowired
    private Open_zhuoService open_zhuoService;

    @GetMapping
    public Bootstrap getAll_open(String offset,String limit){
        return open_zhuoService.getAll_open(offset,limit);
    }
}
