package com.project.nongnong.entity;


// 여기가 domain의 entity에 해당된다.
import lombok.*;

import javax.persistence.*;

@Entity(name = "nongnong_user")
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {
    // domain 아래의 UserVO dto 아래의 UserDTO는 왜 나눈건지 각사용법이 어떻게 다른지 나눳을때의 좋은점이 뭔지 질문
    // 여기가 유저 엔티티가 되는것임
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // IDENTITY : 데이터베이스에 위임한다.
    private Long user_key;
    @Column(length = 100, nullable = false)
    private String user_email;
    @Column(length = 100, nullable = false)
    private String user_pwd;
    @Column(length = 100, nullable = false)
    private String user_nickname;

    public void change(String user_pwd, String user_nickname) {
        this.user_pwd = user_pwd;
        this.user_nickname = user_nickname;
    }




}
