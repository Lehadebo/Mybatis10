
package com.example.clase10Mybatis.repository;

import com.example.clase10Mybatis.entity.Carrera;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface CarreraMybatisRepository {
    @Select("select * from carrera")
    public List<Carrera> findAll();
}