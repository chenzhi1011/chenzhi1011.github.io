package com.example.controller;

import com.example.dto.msgDTO;
import com.example.result.Result;
import com.example.service.msgService;
import com.example.service.serviceImpl.EmailService;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api")
public class msgController {
    @Autowired
    msgService msgSI;
    @Autowired
    EmailService emailService;

    @Transactional
    @PostMapping("/contact")
    public Result leaveMsg(@RequestBody msgDTO msgDto) throws MessagingException {
        log.info("msgDTO:{}",msgDto);
        msgSI.leaveMsg(msgDto);
        emailService.sendHtmlEmail(msgDto);
        return Result.success();
    }
}
