package com.example.zzk_finaly_pro_1.dao;

import com.example.zzk_finaly_pro_1.POJO.Open_zhuo_zzk;
import com.example.zzk_finaly_pro_1.POJO.Table_zzk;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface Table_zzkDao {
    @Select("select * from table_zzk limit ${param1},${param2}")
    public List<Table_zzk> get_table_all(String offset, String limit);

    @Update("update table_zzk set state = 0 where passwd in (${param1}) ")
    public Integer update_Open(String data);

    @Update("update table_zzk set state = 1 where passwd in (${param1}) ")
    public Integer update_Open_1(String data);
}
