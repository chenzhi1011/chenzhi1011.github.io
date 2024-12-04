package com.example.mapper;

import com.example.entity.Msg;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface msgMapper {
    @Insert("insert into msg (name, email, theme, msg_content, send_time) values" +
            "(#{name},#{email},#{theme},#{msgContent},#{sendTime})")
    void leaveMsg(Msg msg);
}
