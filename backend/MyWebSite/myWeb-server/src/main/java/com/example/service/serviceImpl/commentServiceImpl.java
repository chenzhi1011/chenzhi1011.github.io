package com.example.service.serviceImpl;
import com.example.entity.Comments;
import com.example.mapper.commentMapper;
import com.example.service.commentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class commentServiceImpl implements commentService {

    @Autowired
    commentMapper  comMapper;
    @Override
    public List<Comments> getAllCm() {
        return comMapper.getAllCm();
    }
}
