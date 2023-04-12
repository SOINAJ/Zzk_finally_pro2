package com.example.zzk_finaly_pro_1.controller;

import com.example.zzk_finaly_pro_1.dao.Open_zhuo_zzxDao;
import com.example.zzk_finaly_pro_1.service.Open_zhuoService;
import com.example.zzk_finaly_pro_1.service.TableService;
import com.example.zzk_finaly_pro_1.util.Bootstrap;
import com.example.zzk_finaly_pro_1.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tables")
public class TableController {

    @Autowired
    private TableService tableService;

    @Autowired
    private Open_zhuoService open_zhuo_zzo;

    @GetMapping
    public Bootstrap getAll_table(String offset,String limit){
        return tableService.getAll_table(offset, limit);
    }

    @PutMapping("/{acc}")
    public Result update_table(@RequestBody String[] data,@PathVariable String acc){
//        for (String datum : data) {
//            System.out.println(datum);
//        }
        return open_zhuo_zzo.update_1(data,acc);
    }

    @PutMapping("/1")
    public Result update_table1(@RequestBody String data){
        return tableService.update_0(data);

    }
}
