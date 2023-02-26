package com.example.zzk_finaly_pro_1.service;

import com.example.zzk_finaly_pro_1.POJO.Complain_zzk;
import com.example.zzk_finaly_pro_1.dao.ComplainDao;
import com.example.zzk_finaly_pro_1.util.Bootstrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplainService {

    @Autowired
    private ComplainDao complainDao;

    public Bootstrap get_All_complain(String offset,String limit){
        List<Complain_zzk> all_complain = complainDao.get_All_complain(offset, limit);
        return new Bootstrap(all_complain,all_complain.size());
    }
}
