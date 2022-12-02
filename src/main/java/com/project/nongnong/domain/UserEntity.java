package com.project.nongnong.domain;


// 여기가 domain의 entity에 해당된다.
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.nongnong.dto.UserDTO;
import lombok.*;
import org.apache.ibatis.annotations.One;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "nongnonguser")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userkey;

    @Column(length = 100, nullable = false)
    private String useremail;

    @Column(length = 100, nullable = false)
    private String userpwd;

    @Column(length = 100, nullable = false)
    private String usernickname;

    @Column
    private Long userrole;

    @Builder
    public UserEntity(String useremail, String userpwd, String usernickname) {
        this.useremail = useremail;
        this.userpwd = userpwd;
        this.usernickname = usernickname;
    }



}
