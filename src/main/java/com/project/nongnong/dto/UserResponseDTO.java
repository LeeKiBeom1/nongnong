package com.project.nongnong.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponseDTO {

private String useremail;
private String usernickname;

@Builder
    public UserResponseDTO(String useremail, String usernickname) {
    this.useremail = useremail;
    this.usernickname = usernickname;
}



}
