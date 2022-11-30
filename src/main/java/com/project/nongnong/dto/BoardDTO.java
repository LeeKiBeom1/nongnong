package com.project.nongnong.dto;


import com.project.nongnong.domain.BoardEntity;
import com.project.nongnong.domain.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {

    private String BoardTitle;
    private String BoardContent;
    private String BoardMap;
    private Long UserKey;


}
