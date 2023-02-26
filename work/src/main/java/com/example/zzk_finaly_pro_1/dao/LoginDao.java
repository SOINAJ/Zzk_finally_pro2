package com.example.zzk_finaly_pro_1.dao;

import com.example.zzk_finaly_pro_1.POJO.Login_zzk;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LoginDao {

    @Select("select * from login_zzk where account = #{param1} and passwd = ${param2}")
    public Login_zzk login_sys(String username,String passwd);

    @Delete("delete from login_zzk where id in (${param1})")
    public Integer delete_login(String data);

    @Select("select * from login_zzk where role = 0 limit ${param1},${param2}")
    public List<Login_zzk> getLogin(String offset,String limit);

    @Insert("insert into login_zzk (account,passwd,name) values (#{account},#{passwd},#{name})")
    public Integer newLogin(Login_zzk login_zzk);
}
