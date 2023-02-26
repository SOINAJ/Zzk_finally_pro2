package com.example.zzk_finaly_pro_1.controller;

import com.example.zzk_finaly_pro_1.service.Goods_zzkService;
import com.example.zzk_finaly_pro_1.util.Bootstrap;
import com.example.zzk_finaly_pro_1.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private Goods_zzkService goods_zzkService;


    @PutMapping
    public Result putNew_good(@RequestBody String data){
        System.out.println(data);
        return goods_zzkService.insert_newGoods(data);
    }

    @GetMapping("/1/{number}")
    public Bootstrap getAll_goodsmes(@PathVariable String number){
        return goods_zzkService.getAll_goodsmes(number);
    }

    @GetMapping("/2/{number}")
    public Bootstrap getAll_goodsmes_f(@PathVariable String number){
        return goods_zzkService.getAll_goodsmes_finsh(number);
    }
}
