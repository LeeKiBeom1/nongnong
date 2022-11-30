package com.project.nongnong.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity // -> 테이블을 의미한다 여기에 테이블 명을 적어주는 코드도 본적이 있다 @Table 라는 어노테이션도 본적이 있다.
@Table(name = "NongnongBoard")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoardEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long BoardKey;

    @Column
    private String BoardTitle;
    @Column
    private String BoardContent;
    @Column
    private String BoardMap;
    @Column
    private int BoardViews;
    @ManyToOne
    @JoinColumn(name = "user_key")
    private UserEntity userEntity;

    // BaseEntity로 상속받은 컬럼은 여기에 적을 필요 없다.


    public void change(String BoardTitle, String BoardContent){
        this.BoardTitle = BoardTitle;
        this.BoardContent = BoardContent;
    }








}
