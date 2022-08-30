package com.shop.service;

import com.querydsl.core.BooleanBuilder;
import com.shop.entity.*;
import com.shop.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl  implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public void insertAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    @Override
    public void deleteAnswer(Answer answer) {
        answerRepository.deleteById(answer.getASeq());
    }
}
