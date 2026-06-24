package org.scoula.board.vo;

import lombok.Data;
import java.util.Date;

@Data
public class BoardVO {

    private Long no;
    private String title;
    private String writer;
    private String content;
    private Date regDate;
}