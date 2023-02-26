package com.example.zzk_finaly_pro_1.dao;

import com.example.zzk_finaly_pro_1.POJO.Foodmes_zzk;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FoodmesDao {


    public Integer delete_good_stack(String state,String data);

    @Insert("insert into foodmes_zzk (food,stack) values (#{food},#{stack})")
    public Integer post_newFood(Foodmes_zzk foodmes);

    @Select("select * from foodmes_zzk limit ${param1},${param2}")
    public List<Foodmes_zzk> getAll_mes(String offset,String limit);

//    @Select("select food from foodmes_zzk where id in (${param1})")
//    public List<String> get_goods_caiName(String data);


    @Update("update foodmes_zzk set stack = #{stack} where id = #{id}")
    public Integer update_mes(Foodmes_zzk foodmes_zzk);

    @Delete("delete from foodmes_zzk where id in (${param1}) ")
    public Integer delete_mes(String data);
}
