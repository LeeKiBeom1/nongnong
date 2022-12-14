package com.project.nongnong.dto;

import com.project.nongnong.domain.BoardEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BoardViewDTO {

    private Long boardkey;
    private String boardtitle;
    private String boardcontent;
    private int boardviews;
    private Long userkey;
    private String usernickname;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    // 맵지움

    public static BoardViewDTO toDto(final BoardEntity boardEntity) {

        return BoardViewDTO.builder()
                .boardkey(boardEntity.getBoardkey())
                .boardtitle(boardEntity.getBoardtitle())
                .boardcontent(boardEntity.getBoardcontent())
                .boardviews(boardEntity.getBoardviews())
                .userkey(boardEntity.getUserEntity().getUserkey())
                .usernickname(boardEntity.getUserEntity().getUsernickname())
                .createdDate(boardEntity.getCreatedDate())
                .modifiedDate(boardEntity.getModifiedDate())
                .build();

    }

}
