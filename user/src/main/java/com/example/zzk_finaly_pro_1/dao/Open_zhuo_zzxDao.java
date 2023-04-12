package com.example.zzk_finaly_pro_1.dao;

import com.example.zzk_finaly_pro_1.POJO.Goods_zzk;
import com.example.zzk_finaly_pro_1.POJO.Open_zhuo_zzk;
import com.example.zzk_finaly_pro_1.POJO.Table_zzk;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Open_zhuo_zzxDao {

    @Insert("insert into open_zhuo_zzk (zhuo_number,work_number) values (#{zhuo_number},#{work_number})")
    public Integer insert_Open(Open_zhuo_zzk open_zhuo_zzk);

    @Select("select * from open_zhuo_zzk limit ${param1},${param2}")
    public List<Open_zhuo_zzk> get_open_all(String offset, String limit);
}
