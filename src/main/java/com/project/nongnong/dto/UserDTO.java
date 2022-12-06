package com.project.nongnong.dto;


import com.project.nongnong.domain.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserDTO {

    private String useremail;
    private String userpwd;
    private String usernickname;

    @Builder
    public UserDTO(String useremail, String userpwd, String usernickname) {
        this.useremail = useremail;
        this.userpwd = userpwd;
        this.usernickname = usernickname;

    }

    // 엔티티 클래스를 주고받으면 안되므로 DTO가 저장될때 엔티티로 변환시키는 작업도 여기서 한다
    public UserEntity toEntity() {
        return UserEntity.builder()
                .useremail(useremail)
                .userpwd(userpwd)
                .usernickname(usernickname)
                .build();
    }





}
