package com.example.service;

import com.example.dto.msgDTO;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.stereotype.Service;


public interface msgService {
    void leaveMsg(msgDTO msgDto);
}
