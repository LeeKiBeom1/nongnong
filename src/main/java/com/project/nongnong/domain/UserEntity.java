package com.project.nongnong.domain;


// 여기가 domain의 entity에 해당된다.
import lombok.*;
import org.apache.ibatis.annotations.One;

import javax.persistence.*;

@Entity(name = "NongnongUser")
@Data
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
    private Long UserKey;
    @Column(length = 100, nullable = false)
    private String UserEmail;
    @Column(length = 100, nullable = false)
    private String UserPwd;
    @Column(length = 100, nullable = false)
    private String UserNickname;


    public void change(String UserPwd, String UserNickname) {
        this.UserPwd = UserPwd;
        this.UserNickname = UserNickname;
    }




}
