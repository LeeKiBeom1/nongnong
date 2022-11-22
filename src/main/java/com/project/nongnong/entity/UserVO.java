package com.project.nongnong.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nongnong_user")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
    // domain 아래의 UserVO dto 아래의 UserDTO는 왜 나눈건지 각사용법이 어떻게 다른지 나눳을때의 좋은점이 뭔지 질문
    // 여기가 유저 엔티티가 되는것임
    @Id
    private int user_key;


}
