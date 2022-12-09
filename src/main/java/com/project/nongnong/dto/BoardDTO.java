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
    private Long userkey;

    private String address;
    private String addressdetail;
    private String zonenumber;

    // 맵지움


    @Builder
    public BoardDTO(String boardtitle, String boardcontent, Long userkey, String address
    , String addressdetail, String zonenumber) {
        this.boardtitle = boardtitle;
        this.boardcontent = boardcontent;
        this.userkey = userkey;
        this.address = address;
        this.addressdetail = addressdetail;
        this.zonenumber = zonenumber;
    }

    public BoardEntity toEntity() {

        return BoardEntity.builder()
                .boardtitle(boardtitle)
                .boardcontent(boardcontent)
                .address(address)
                .addressdetail(addressdetail)
                .zonenumber(zonenumber)
                .build();
    }



}
