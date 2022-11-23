package com.project.nongnong.dto;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDTO {

    private Long user_key;
    private String user_email;
    private String user_pwd;
    private String user_nickname;
    private Long user_role;

}
