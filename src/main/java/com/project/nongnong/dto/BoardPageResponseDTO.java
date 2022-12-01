package com.project.nongnong.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class BoardPageResponseDTO<E> {

    private int page;
    private int size;
    private int total;
    private int start;
    private int end;

    private boolean prev;
    private boolean next;

    private List<E> dtoList;

//    @Builder(builderMethodName = "withAll")
//    public BoardPageResponseDTO(BoardPageRequestDTO boardPageRequestDTO, List<E> dtoList, int total) {
//
//        if (total <= 0) {
//
//            return;
//
//        }
//
//        this.page = boardPageRequestDTO.getPage();
//        this.size = boardPageRequestDTO.getSize();
//
//    }

}
