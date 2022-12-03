package com.project.nongnong.service;


import com.project.nongnong.domain.BoardEntity;
import com.project.nongnong.domain.UserEntity;
import com.project.nongnong.dto.BoardDTO;
import com.project.nongnong.dto.BoardPageResponseDTO;
import com.project.nongnong.repository.BoardRepository;
import com.project.nongnong.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Log4j2
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long save(BoardDTO boardDTO) {

        BoardEntity boardEntity = boardDTO.toEntity();

        UserEntity userEntity = userRepository.findByUserkey(boardDTO.getUserkey());
        log.info(userEntity.getUseremail());

        boardEntity.setUserEntity(userEntity);

        boardRepository.save(boardEntity);

        return boardEntity.getBoardkey();

    }

    @Transactional
    public Page<BoardPageResponseDTO> list(Pageable pageable) {

        Page<BoardEntity> boardEntityList = boardRepository.findAll(pageable);

        return null;

    }

    @Transactional
    public Page<BoardPageResponseDTO> list2(Pageable pageable) {

        Page<BoardEntity> boardEntityPage = boardRepository.findAll(pageable);

        Page<BoardPageResponseDTO> boardPageResponseDTOPage = boardRepository.findAll(pageable).map(BoardPageResponseDTO::toDto);

        return boardPageResponseDTOPage;

    }


}
