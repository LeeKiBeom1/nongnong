package com.project.nongnong.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity // -> 테이블을 의미한다 여기에 테이블 명을 적어주는 코드도 본적이 있다 @Table 라는 어노테이션도 본적이 있다.
@Table(name = "nongnong_board")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoardEntity extends BaseEntity {

    @Id // ->
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long board_key;

    @Column
    private String board_title;
    private String board_content;
    private String board_map;
    private int board_views;
    private Long user_key;

    // BaseEntity로 상속받은 컬럼은 여기에 적을 필요 없다.


    public void change(String board_title, String board_content){
        this.board_title = board_title;
        this.board_content = board_content;
    }






}
