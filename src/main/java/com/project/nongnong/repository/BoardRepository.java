package com.project.nongnong.repository;

import com.project.nongnong.domain.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {



}
