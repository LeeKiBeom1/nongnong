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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public List<BoardPageResponseDTO> list(Pageable pageable) {

        ModelMapper modelMapper = new ModelMapper();



        Page<BoardEntity> boardEntities = boardRepository.findAll(pageable);

        List<BoardPageResponseDTO> boardPageResponseDTO = boardEntities.stream().map(nongnongboard -> modelMapper.map(nongnongboard,
                BoardPageResponseDTO.class)).collect(Collectors.toList());


        return boardPageResponseDTO;

    }


}
