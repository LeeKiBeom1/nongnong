package com.project.nongnong.dto;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDTO {

    private Long UserKey;
    private String UserEmail;
    private String UserPwd;
    private String UserNickname;

}
