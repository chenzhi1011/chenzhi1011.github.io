package com.example.mapper;

import com.example.dto.commentDTO;
import com.example.entity.Comment;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface commentMapper {
    @Select("select * from comments order by create_time desc")
    List<Comment> getAllCm();

    @Insert("insert into comments (comment, create_time) VALUES (#{comment},#{createTime})")
    void sendCm(Comment comment);
}
