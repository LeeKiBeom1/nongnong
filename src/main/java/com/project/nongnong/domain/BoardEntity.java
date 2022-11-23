package com.project.nongnong.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoardEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long board_key;

    private String board_title;
    private String board_content;
    private String board_map;
    private int board_views;
    private Long user_key;

    public void change(String board_title, String board_content){
        this.board_title = board_title;
        this.board_content = board_content;
    }






}
