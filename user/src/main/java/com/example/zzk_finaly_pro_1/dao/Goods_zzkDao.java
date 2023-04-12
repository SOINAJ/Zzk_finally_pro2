package com.example.zzk_finaly_pro_1.dao;

import com.example.zzk_finaly_pro_1.POJO.Goods_zzk;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface Goods_zzkDao {

//    @Select("select goods_zzk.id,goods_zzk.number_cai,foodmes_zzk.food,goods_zzk.number_zhuo,goods_zzk.way " +
//            "from goods_zzk inner join foodmes_zzk on goods_zzk.number_cai = foodmes_zzk.id " +
//            "where goods_zzk.state = 0 limit ${param1},${param2}")
//    public List<Goods_zzk> getAll_mes1(String offset, String limit);
    @Select("select goods_zzk.id,goods_zzk.number_cai,foodmes_zzk.food,goods_zzk.number_zhuo,goods_zzk.way from goods_zzk inner join foodmes_zzk on goods_zzk.number_cai = foodmes_zzk.id where number_zhuo = #{param1} and state = 0")
    public List<Goods_zzk> get_mes(String number);

    @Select("select goods_zzk.id,goods_zzk.number_cai,foodmes_zzk.food,goods_zzk.number_zhuo,goods_zzk.way from goods_zzk inner join foodmes_zzk on goods_zzk.number_cai = foodmes_zzk.id where number_zhuo = #{param1} and state = 1 and state1 = 0")
    public List<Goods_zzk> get_mes_finsh(String number);

    @Insert("insert into goods_zzk (number_cai,number_zhuo,way) values (#{number_cai},#{number_zhuo},#{way})")
    public Integer insert_newGoods(Goods_zzk goods_zzk);

    @Select("select sum(foodmes_zzk.money) from goods_zzk inner join foodmes_zzk on goods_zzk.number_cai = foodmes_zzk.id and goods_zzk.state = 1 and goods_zzk.state1 = 0 where goods_zzk.number_zhuo = #{param1}")
    public Integer get_money(String number);

    @Update("update goods_zzk set state1 = 1 where number_zhuo = #{number} and state = 1")
    public Integer updata_mes(String number);
}
