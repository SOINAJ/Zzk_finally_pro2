package com.example.zzk_finaly_pro_1.dao;

import com.example.zzk_finaly_pro_1.POJO.Foodmes_zzk;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface Foodmes_zzkDao {

    @Select("select count(*) from foodmes_zzk")
    public Integer get_number();

    @Select("select * from foodmes_zzk limit ${param1},7")
    public List<Foodmes_zzk> get_food_mes(Integer number);

    @Update("update foodmes_zzk set stack = stack - 1 where id = ${number}")
    public Integer updata_mes(String number);
}
