package com.project.nongnong.service;


import com.project.nongnong.domain.BoardEntity;
import com.project.nongnong.domain.UserEntity;
import com.project.nongnong.dto.BoardDTO;
import com.project.nongnong.dto.BoardPageResponseDTO;
import com.project.nongnong.repository.BoardRepository;
import com.project.nongnong.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
    public List<BoardPageResponseDTO> list() {

        List<BoardPageResponseDTO> list = null;



        return list;
    }


}
