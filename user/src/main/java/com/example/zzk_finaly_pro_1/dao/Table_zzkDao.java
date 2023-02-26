package com.example.zzk_finaly_pro_1.dao;

import com.example.zzk_finaly_pro_1.POJO.Table_zzk;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface Table_zzkDao {

    @Select("select * from table_zzk where passwd = #{param1} and state = 0")
    public Table_zzk loginsys(String username);

    @Update("update table_zzk set state = 0 where id = #{param1}")
    public Integer logonsys(String username);

    @Update("update table_zzk set state = 1 where passwd = #{param1}")
    public Integer loginsys_state(String username);
}
