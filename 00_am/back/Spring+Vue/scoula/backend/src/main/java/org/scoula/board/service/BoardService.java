package org.scoula.board.service;

import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    //mybatis용 인터페이스에 정의된 메서드는 다 만들어주어야함.
    //mybatis처리하기전 전처리/후처리 용도
    List<BoardDTO> getList();
    BoardDTO get(Long no);
    BoardDTO create(BoardDTO board);
    BoardDTO update(BoardDTO board);
    BoardDTO delete(Long no);

    BoardAttachmentVO getAttachment(Long no);
    boolean deleteAttachment(Long no);
}
