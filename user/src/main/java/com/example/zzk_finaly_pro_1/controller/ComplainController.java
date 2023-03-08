package com.example.zzk_finaly_pro_1.controller;

import com.example.zzk_finaly_pro_1.service.Complain_zzkService;
import com.example.zzk_finaly_pro_1.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/complains")
public class ComplainController {

    @Autowired
    private Complain_zzkService complain_zzkService;

    @PostMapping
    public Result post_new_complain(@RequestBody String data){
        System.out.println(data);
        return complain_zzkService.insert_newComplain(data);

    }
}
