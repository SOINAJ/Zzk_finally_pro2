package com.example.zzk_finaly_pro_1.dao;

import com.example.zzk_finaly_pro_1.POJO.Complain_zzk;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Complain_zzkDao {

    @Insert("insert into complain_zzk (number_zhuo,worker,date,message) values (#{number_zhuo},#{worker},#{date},#{message})")
    public Integer insert_newComplain(Complain_zzk complain_zzk);
}
