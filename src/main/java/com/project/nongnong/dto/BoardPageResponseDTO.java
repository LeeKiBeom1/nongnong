package com.project.nongnong.dto;


import com.project.nongnong.domain.BoardEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class BoardPageResponseDTO {

    private Long boardkey;
    private String boardtitle;
    private String boardcontent;
    private String boardmap;
    private int boardviews;
    private Long userkey;
    private String usernickname;

    @Builder
    public BoardPageResponseDTO(BoardEntity boardEntity) {

        //this.boardkey

    }


}
