package com.example.service;

import com.example.dto.commentDTO;
import com.example.entity.Comment;

import java.util.List;


public interface commentService {

    List<Comment> getAllCm(int pageKey);

    void sendCm(commentDTO commentDto);
}
