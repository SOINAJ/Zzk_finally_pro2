package com.example.zzk_finaly_pro_1.dao;

import com.example.zzk_finaly_pro_1.POJO.Complain_zzk;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ComplainDao {

    @Select("select * from complain_zzk limit ${param1},${param2}")
    public List<Complain_zzk> get_All_complain(String offset,String limit);
}
