package com.example.zzk_finaly_pro_1.controller;

import com.example.zzk_finaly_pro_1.service.GoodsService;
import com.example.zzk_finaly_pro_1.util.Bootstrap;
import com.example.zzk_finaly_pro_1.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/givememoney")
    public Result getAllMoney(){
       return goodsService.getAll_money();
    }

    @GetMapping
    public Bootstrap getAllGoods(String offset,String limit){
        return goodsService.getAll_goods(offset, limit);
    }

    @PutMapping
    public Result delete_food(@RequestBody String[] data){
        for (String datum : data) {
            System.out.println(datum);
        }
        return goodsService.delete_food(data);

    }

    @PutMapping("/1")
    public Result finsh_food(@RequestBody String[] data){
        for (String datum : data) {
            System.out.println(datum);
        }
        return goodsService.finsh_food(data);

    }
}
