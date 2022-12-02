package com.project.nongnong.dto;


import com.project.nongnong.domain.BoardEntity;
import com.project.nongnong.domain.UserEntity;
import com.project.nongnong.repository.UserRepository;
import lombok.*;


@Getter
@NoArgsConstructor
public class BoardDTO {

    private String boardtitle;
    private String boardcontent;
    private String boardmap;
    private Long userkey;


    @Builder
    public BoardDTO(String boardtitle, String boardcontent, String boardmap, Long userkey) {
        this.boardtitle = boardtitle;
        this.boardcontent = boardcontent;
        this.boardmap = boardmap;
        this.userkey = userkey;
    }

    public BoardEntity toEntity() {

        return BoardEntity.builder()
                .boardtitle(boardtitle)
                .boardcontent(boardcontent)
                .boardmap(boardmap)
                .build();
    }



}
