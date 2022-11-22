package com.project.nongnong.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {

    private int user_key;
    private String user_email;
    private String user_pwd;
    private String user_nickname;
    private int user_role;

}
