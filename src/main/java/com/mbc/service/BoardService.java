package com.mbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbc.mapper.BoardMapper;
import com.mbc.model.BoardDTO;

@Service
public class BoardService {
	
	@Autowired // BoardMapper 주입
	private BoardMapper mapper;

	// 게시글 등록
	public void register(BoardDTO dto) {
		mapper.insert(dto);
	}	
	
	// 게시글 리스트
	public List<BoardDTO> getList(){
		List<BoardDTO> list= mapper.getList();
		return list;
	}
	
	// 게시글 상세보기(조회수 증가)
	public BoardDTO view(int bid, String mode) {
		if(mode.equals("v"))
			mapper.hitAdd(bid);
		BoardDTO dto= mapper.view(bid);
		return dto;
	}
	
	// 게시글 수정
	public void modify(BoardDTO dto) {
		mapper.update(dto);
	}

	// 게시글 삭제
	public void remove(int bid) {
		mapper.delete(bid);
	}
	
	// 좋아요
	public void addLike(int bid) {
		mapper.likeAdd(bid);
	}
	
	
}
