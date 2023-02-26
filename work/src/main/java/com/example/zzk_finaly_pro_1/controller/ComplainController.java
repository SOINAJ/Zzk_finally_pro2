package com.example.zzk_finaly_pro_1.controller;

import com.example.zzk_finaly_pro_1.service.ComplainService;
import com.example.zzk_finaly_pro_1.util.Bootstrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/complain")
public class ComplainController {

    @Autowired
    private ComplainService complainService;

    @GetMapping
    public Bootstrap get_complain(String offset,String limit){
        return complainService.get_All_complain(offset, limit);
    }

}
