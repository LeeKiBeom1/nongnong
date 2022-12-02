package com.project.nongnong.dto;


import com.project.nongnong.domain.BoardEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
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

    @Builder
    public BoardPageResponseDTO(BoardEntity boardEntity) {

        this.boardkey = boardEntity.getBoardkey();
        this.boardtitle = boardEntity.getBoardtitle();
        this.boardcontent = boardEntity.getBoardcontent();
        this.boardmap = boardEntity.getBoardmap();
        this.boardviews = boardEntity.getBoardviews();
        this.userkey = boardEntity.getUserEntity().getUserkey();
        this.usernickname = boardEntity.getUserEntity().getUsernickname();
        this.createdDate = boardEntity.getCreatedDate();
        this.modifiedDate = boardEntity.getModifiedDate();

    }

    public BoardPageResponseDTO toEntity() {
        // return BoardPageResponseDTO.builder()
        return null;
    }





}
