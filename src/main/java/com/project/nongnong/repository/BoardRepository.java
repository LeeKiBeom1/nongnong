package com.project.nongnong.repository;

import com.project.nongnong.domain.BoardEntity;
import com.project.nongnong.domain.UserEntity;
import com.project.nongnong.dto.BoardViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

//    @Override
//    @EntityGraph(attributePaths = "userEntity", type = EntityGraph.EntityGraphType.LOAD)
//    List<BoardEntity> findAll();


    @Override
    @EntityGraph(attributePaths = {"userEntity"})
    Page<BoardEntity> findAll(Pageable pageable);


//    @Override
//    @EntityGraph(attributePaths = {"userEntity"})
//    BoardEntity findById(Long id);


}
