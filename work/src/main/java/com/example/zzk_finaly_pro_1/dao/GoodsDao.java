package com.example.zzk_finaly_pro_1.dao;

import com.example.zzk_finaly_pro_1.POJO.Goods_zzk;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsDao {

    @Select("select * from goods_zzk limit ${param1},${param2}")
    public List<Goods_zzk> getAll_mes(String offset, String limit);

    @Select("select goods_zzk.id,goods_zzk.number_cai,foodmes_zzk.food,goods_zzk.number_zhuo,goods_zzk.way " +
            "from goods_zzk inner join foodmes_zzk on goods_zzk.number_cai = foodmes_zzk.id " +
            "where goods_zzk.state = 0 limit ${param1},${param2}")
    public List<Goods_zzk> getAll_mes1(String offset, String limit);

    @Delete("delete from goods_zzk where id in (${param1}) ")
    public Integer delete_goods(String data);


    @Insert("insert into goods_zzk (number_cai,number_zhuo,way) values (#{number_cai},#{number_zhuo},#{way})")
    public Integer post_newGoods(Goods_zzk goods_zzk);

    @Update("update goods_zzk set state = 1 where id in ( ${param1})")
    public Integer finsh_goods(String data);

    @Select("select sum(foodmes_zzk.money) from goods_zzk inner join foodmes_zzk")
    public Integer get_All_money();
}
