package com.project.nongnong.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardPageRequestDTO {

    // 여기가 프론트에 보내줄 데이터를 담는 곳이다 필요한 데이터는
    // 작성자 정보, 게시글 제목, 내용, 주소값, 조회수, 작성날짜, 수정날짜 이다.

    private Long userkey;
    private String usernickname;
    private String boardtitle;
    private String boardcontent;
    private String boardmap;
    private int boardviews;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;



//    @Builder.Default
//    private int page = 1;
//
//    @Builder.Default
//    private int size = 28;
//
//    public Pageable getPageable(String...props) {
//        return PageRequest.of(this.page -1, this.size, Sort.by(props).descending());
//    }






}
