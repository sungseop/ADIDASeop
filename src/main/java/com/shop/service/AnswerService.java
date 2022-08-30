package com.shop.service;

import com.shop.entity.Answer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AnswerService {

    void insertAnswer(Answer answer);

    void deleteAnswer(Answer answer);
}
