package com.example.controller;

import com.example.dto.commentDTO;
import com.example.entity.Comment;
import com.example.result.Result;
import com.example.service.commentService;
import com.example.service.serviceImpl.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class commentController {
    @Autowired
    commentService commentService;

    @GetMapping("/comments")
    public Result<List<Comment>> getAllCm(@RequestParam int pageKey){
        List<Comment> list = commentService.getAllCm(pageKey);
        return Result.success(list);
    }

    @PostMapping("/comments")
    public Result sendCm(@RequestBody commentDTO commentDto){
        log.info("receive a comment:{}",commentDto);
        commentService.sendCm(commentDto);
        return Result.success();
    }
}
