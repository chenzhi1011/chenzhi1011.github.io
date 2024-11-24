package com.example.service;

import com.example.entity.Comments;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface commentService {
    List<Comments> getAllCm();
}
