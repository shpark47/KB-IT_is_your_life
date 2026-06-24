package org.scoula.board.vo;

import lombok.Data;

@Data
public class BoardFileVO {

    private Long fileId;
    private Long boardNo;

    private String fileName;
    private String contentType;

    private byte[] fileData;
}