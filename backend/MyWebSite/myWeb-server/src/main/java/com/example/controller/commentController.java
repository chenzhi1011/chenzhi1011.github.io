package com.example.controller;

import com.example.dto.commentDTO;
import com.example.entity.Comment;
import com.example.result.Result;
import com.example.service.commentService;
import com.example.utils.ipStoreUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class commentController {

    @Autowired
    private final ipStoreUtils ipStoreUtils;

    @Autowired
    commentService commentService;

    public commentController(com.example.utils.ipStoreUtils ipStoreUtils) {
        this.ipStoreUtils = ipStoreUtils;
    }

    @GetMapping("/comments")

    public Result<List<Comment>> getAllCm(@RequestParam int pageKey){
        List<Comment> list = commentService.getAllCm(pageKey);
        return Result.success(list);
    }

    @PostMapping("/comments")
    public Result sendCm(@RequestBody commentDTO commentDto, HttpServletRequest request){
        log.info("receive a comment:{}",commentDto);
        //get ip
        String clientIp = getClientIp(request);
        log.info("Received a comment from IP: {}, content: {}", clientIp, commentDto);

        //check ip
        if (!ipStoreUtils.addIp(clientIp)) {
            return Result.error("Multiple submission within a short period of time are not allowed, please try again 5 mins later.");
        }

        commentService.sendCm(commentDto);
        return Result.success();
    }

    // get client ip
    private String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}

