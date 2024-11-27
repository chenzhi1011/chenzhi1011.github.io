package com.example.service.serviceImpl;
import com.example.dto.commentDTO;
import com.example.entity.Comment;
import com.example.mapper.commentMapper;
import com.example.service.commentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class commentServiceImpl implements commentService {

    @Autowired
    commentMapper  comMapper;
    @Override

    public List<Comment> getAllCm(int pageKey) {
        return comMapper.getAllCm(pageKey);

    }

    @Transactional
    @Override
    public void sendCm(commentDTO commentDto) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDto,comment);
        comment.setCreateTime(LocalDateTime.now());
        comMapper.sendCm(comment);
    }
}
