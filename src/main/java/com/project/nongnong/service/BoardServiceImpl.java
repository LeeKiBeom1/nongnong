package com.project.nongnong.service;

import com.project.nongnong.domain.BoardEntity;
import com.project.nongnong.dto.BoardDTO;
import com.project.nongnong.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService {

    private final ModelMapper modelMapper;
    private final BoardRepository boardRepository;


    @Override
    public Long register(BoardDTO boardDTO) {

        BoardEntity boardEntity = modelMapper.map(boardDTO, BoardEntity.class);
        Long boardkey = boardRepository.save(boardEntity).getBoardKey();

        return boardkey;
    }

    @Override
    public BoardDTO readOnly(Long boardkey) {
        Optional<BoardEntity> result = boardRepository.findById(boardkey);

        BoardEntity boardEntity = result.orElseThrow();

        BoardDTO boardDTO = modelMapper.map(boardEntity, BoardDTO.class);

        return boardDTO;
    }

    @Override
    public void modify(BoardDTO boardDTO) {

    }

    @Override
    public void remove(Long boardkey) {

    }
}
