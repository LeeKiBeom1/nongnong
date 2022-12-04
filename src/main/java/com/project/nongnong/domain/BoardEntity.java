package com.project.nongnong.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.apache.catalina.User;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "nongnongboard") // -> 테이블을 의미한다 여기에 테이블 명을 적어주는 코드도 본적이 있다 @Table 라는 어노테이션도 본적이 있다.
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardkey;

    @Column(length = 500, nullable = false)
    private String boardtitle;
    @Column(length = 2000,nullable = false)
    private String boardcontent;
    @Column(length = 500,nullable = false)
    private String boardmap;
    @ColumnDefault("0")
    private int boardviews;

    // 게시글과 회원은  다대일(N : 1) 관계 지정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userkey")
    @JsonIgnore
    private UserEntity userEntity;

    // BaseEntity로 상속받은 컬럼은 여기에 적을 필요 없다.

    // 생성자
    @Builder
    public BoardEntity(UserEntity userEntity,String boardtitle, String boardcontent, String boardmap) {
        this.userEntity = userEntity;
        this.boardtitle = boardtitle;
        this.boardcontent = boardcontent;
        this.boardmap = boardmap;

    }
/*
이슈 01
엔티티의 컬럼명을 정할때 JPA는 대문자를 기준으로 _ 를 사용해서 컬럼명을 디비에 넣는다.(uesrKey -> user_key)
그래서 UserKey 형태로 했더니 DB에 user_key형태로 컬럼명이 만들어 졌고 postman을 통해 json 데이터를
"user_key" : "1" 형태로 전송해도 데이터가 null값이 들어왔고
https://the-dev.tistory.com/21 를 통해 첫 두글자에 대문자를 사용하는경우 혼선이 오거나 값이 안들어 갈 수 있다고 해서
모든 Entity의 컬럼명을 소문자로 바꿧고 그다음에 다시 요청했더니 정상적으로 값이 들어왔다.
 */






}
