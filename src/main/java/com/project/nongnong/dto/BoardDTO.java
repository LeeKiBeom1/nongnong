package com.project.nongnong.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {

    private Long board_key;

    private String board_content;
    private String board_map;
    private int board_views;
    private Long user_key;

    private LocalDateTime regDate;

    private LocalDateTime modDate;

}
