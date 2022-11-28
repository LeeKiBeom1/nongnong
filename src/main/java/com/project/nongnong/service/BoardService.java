package com.project.nongnong.service;

import com.project.nongnong.dto.BoardDTO;

public interface BoardService {
    Long register(BoardDTO boardDTO);

    BoardDTO readOnly(Long board_key);

    void modify(BoardDTO boardDTO);

    void remove(Long board_key);



}
