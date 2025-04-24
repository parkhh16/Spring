package com.ssafy.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.mvc.dto.BoardDto;
import com.ssafy.mvc.dto.SearchCondition;
import com.ssafy.mvc.model.service.BoardService;

@Controller
public class BoardController {
	private final BoardService boardService;
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService=boardService;
	}
	@GetMapping("/writeform")
	public String writeform() {
		return "board/writeform";
	}
	@PostMapping("/write")
	public String write(@ModelAttribute BoardDto board) {
		boardService.writeBoard(board);
		
		return "redirect:list";
	}
	@GetMapping("/list")
	public String list(Model model) {
		List<BoardDto> list=boardService.getBoardList();
		model.addAttribute("boardList",list);
		return "/board/list";
	}
	@GetMapping("/detail")
	public String detail(@RequestParam("id") int id, Model model) {
		BoardDto board =boardService.readBoard(id);
		model.addAttribute("board",board);
		return "/board/detail";
		
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		boardService.removeBoard(id);
		return "redirect:list";
	}
	@GetMapping("/updateform")
	public String updateform(@RequestParam("id") int id, Model model) {
		model.addAttribute("board",boardService.getBoard(id));
		return "/board/updateform";
	}
	@PostMapping("/update")
	public String update(@ModelAttribute BoardDto board) {
		boardService.modifyBoard(board);
		return "redirect:detail?id="+board.getId();
	}
	@GetMapping("/search")
	public String search(@ModelAttribute SearchCondition condition, Model model) {
		System.out.println(condition);
		List<BoardDto> list= boardService.search(condition);
		model.addAttribute("boardList",list);
		return "/board/list";
	}
}
