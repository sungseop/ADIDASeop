package com.shop.service;

import com.shop.entity.Board;
import com.shop.entity.Search;
import org.springframework.data.domain.Page;

public interface BoardService {
    void insertBoard(Board board);

    void updateBoard(Board board);

    void deleteBoard(Board board);

    Board getBoard(Board board);

    Page<Board> getBoardList(Search search);
}
