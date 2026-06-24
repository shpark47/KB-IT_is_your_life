package org.scoula.board.service;

import org.scoula.board.vo.BoardVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BoardService {

    List<BoardVO> getList();

    void register(BoardVO board,
                  MultipartFile file) throws IOException;
}