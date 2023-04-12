package com.example.zzk_finaly_pro_1.controller;

import com.example.zzk_finaly_pro_1.service.FoodmesService;
import com.example.zzk_finaly_pro_1.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foods")
public class FoodController {

    @Autowired
    private FoodmesService foodmesService;

    @PostMapping
    public Result post_NewGoods(@RequestBody String data) {
        System.out.println(data);

        return foodmesService.post_new_food(data);
    }

}
