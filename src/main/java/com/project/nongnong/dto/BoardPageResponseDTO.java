package com.project.nongnong.dto;


import com.project.nongnong.domain.BoardEntity;
import com.project.nongnong.domain.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@Builder
public class BoardPageResponseDTO {

    private Long boardkey;
    private String boardtitle;
    private String boardcontent;
    private String boardmap;
    private int boardviews;
    private Long userkey;
    private String usernickname;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    // private List<UserEntity> userEntityList;



//    public BoardPageResponseDTO(BoardEntity boardEntity) {
//
//        this.boardkey = boardEntity.getBoardkey();
//        this.boardtitle = boardEntity.getBoardtitle();
//        this.boardcontent = boardEntity.getBoardcontent();
//        this.boardmap = boardEntity.getBoardmap();
//        this.boardviews = boardEntity.getBoardviews();
//        this.userkey = boardEntity.getUserEntity().getUserkey();
//        this.usernickname = boardEntity.getUserEntity().getUsernickname();
//        this.createdDate = boardEntity.getCreatedDate();
//        this.modifiedDate = boardEntity.getModifiedDate();
//    }


    public static BoardPageResponseDTO toDto(final BoardEntity boardEntity) {

        return BoardPageResponseDTO.builder()
                .boardkey(boardEntity.getBoardkey())
                .boardtitle(boardEntity.getBoardtitle())
                .boardcontent(boardEntity.getBoardcontent())
                .boardmap(boardEntity.getBoardmap())
                .boardviews(boardEntity.getBoardviews())
                .userkey(boardEntity.getUserEntity().getUserkey())
                .usernickname(boardEntity.getUserEntity().getUsernickname())
                .createdDate(boardEntity.getCreatedDate())
                .modifiedDate(boardEntity.getModifiedDate())
                .build();

    }



}
