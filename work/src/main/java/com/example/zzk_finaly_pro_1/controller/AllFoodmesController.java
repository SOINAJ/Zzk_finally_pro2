package com.example.zzk_finaly_pro_1.controller;

import com.example.zzk_finaly_pro_1.service.FoodmesService;
import com.example.zzk_finaly_pro_1.util.Bootstrap;
import com.example.zzk_finaly_pro_1.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/allFmes")
public class AllFoodmesController {

    @Autowired
    private FoodmesService foodmesService;

    @GetMapping
    public Bootstrap getAll_foodmes(String offset,String limit){
//        System.out.println(offset+limit);
        return foodmesService.getAll_foodmes(offset, limit);
    }

    @PostMapping
    public Result update_foodmes(@RequestBody String id){
//        System.out.println(id);
        return foodmesService.updata_newfood(id);
    }

    @PutMapping
    public Result delete_food(@RequestBody String[] data){
        for (String datum : data) {
            System.out.println(datum);
        }
        foodmesService.delete_food(data);
        return null;
    }
}
