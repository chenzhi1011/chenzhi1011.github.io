package com.example.mapper;

import com.example.dto.commentDTO;
import com.example.entity.Comment;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface commentMapper {
    @Select("select * from comments where page_key=#{pageKey} order by create_time desc")
    List<Comment> getAllCm(int pageKey);

    @Insert("insert into comments (comment, create_time,page_key) VALUES (#{comment},#{createTime},#{pageKey})")
    void sendCm(Comment comment);
}
