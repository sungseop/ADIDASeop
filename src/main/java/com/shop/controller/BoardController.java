package com.shop.controller;

import com.shop.entity.Answer;
import com.shop.entity.Board;
import com.shop.entity.Search;
import com.shop.repository.AnswerRepository;
import com.shop.service.AnswerService;
import com.shop.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board/")
public class BoardController {

    @Autowired
    private BoardService boardService;
    @Autowired
    private AnswerService answerService;

    @Autowired
    private AnswerRepository answerRepository;

    @RequestMapping(value = "/getBoardList")
    public String boardList(Model model, Search search) {

        if (search.getSearchCondition() == null)
            search.setSearchCondition("TITLE");
        if (search.getSearchKeyword() == null)
            search.setSearchKeyword("");

        Page<Board> boardList = boardService.getBoardList(search);
        model.addAttribute("boardList", boardList);

        return "board/boardList";
    }

    @RequestMapping("/getBoard/{seq}")
    public String getBoard(@PathVariable("seq") Long aBoardSeq, Board board, Answer answer, Model model, Search search) {

        List<Answer> answerList = answerRepository.getAnswerList(aBoardSeq);

        model.addAttribute("board", boardService.getBoard(board));
        model.addAttribute("answerList", answerList);

        return "board/getBoard";
    }

    @GetMapping("/insertBoard")
    public String insertBoardView() {

        return "board/insertBoard";
    }

    @PostMapping("/insertBoard")
    public String insertBoard(Board board) {
        boardService.insertBoard(board);

        return "redirect:getBoardList";
    }

    @PostMapping("/updateBoard")
    public String updateBoard(Board board) {
        boardService.updateBoard(board);

        return "forward:getBoardList";
    }

    @GetMapping("/deleteBoard")
    public String deleteBoard(Board board) {
        boardService.deleteBoard(board);

        return "forward:getBoardList";
    }

    @RequestMapping("/insertAnswer")
    public String insertAnswer(@RequestParam("aBoardSeq") Long aBoardSeq, Answer answer) {

        answer.setABoardSeq(aBoardSeq);

        answerService.insertAnswer(answer);

        return "redirect:getBoardList";
    }
}
