package com.example.zzk_finaly_pro_1.controller;

import com.example.zzk_finaly_pro_1.service.Foodmes_zzkService;
import com.example.zzk_finaly_pro_1.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food_market")
public class FoodmesController {

    @Autowired
    private Foodmes_zzkService foodmes_zzkService;



    @GetMapping
    public Result get_food_number(){
        return foodmes_zzkService.get_number();
//        return null;
    }

    @GetMapping("/{number}")
    public Result get_food_mes(@PathVariable String number){
        return foodmes_zzkService.get_mes(number);
//        return null;
    }
}
