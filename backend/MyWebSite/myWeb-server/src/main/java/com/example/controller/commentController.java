package com.example.controller;

import com.example.entity.Comments;
import com.example.result.Result;
import com.example.service.commentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class commentController {
    @Autowired
    commentService commentService;

    @GetMapping("/comment")
    public Result<List<Comments>> getAllCm(){
        List<Comments> list = commentService.getAllCm();
        return Result.success(list);
    }
}
