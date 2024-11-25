package com.example.service.serviceImpl;

import com.example.dto.msgDTO;
import com.example.entity.Msg;
import com.example.mapper.msgMapper;
import com.example.service.msgService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class msgServiceImpl implements msgService {

    @Autowired
    msgMapper  msgMapper;
    @Override
    public void leaveMsg(msgDTO msgDto) {
        Msg msg = new Msg();
        msg.setSendTime(LocalDateTime.now());
        BeanUtils.copyProperties(msgDto,msg);
        msgMapper.leaveMsg(msg);
    }
}
