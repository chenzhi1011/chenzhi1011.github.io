package com.example.mapper;

import com.example.entity.Comments;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface commentMapper {
    @Select("select * from comments order by create_time desc")
    List<Comments> getAllCm();
}
