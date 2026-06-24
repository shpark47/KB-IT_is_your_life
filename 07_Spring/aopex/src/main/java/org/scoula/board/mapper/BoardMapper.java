package org.scoula.board.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.scoula.board.vo.BoardVO;
import org.scoula.board.vo.BoardFileVO;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardVO> getList();

    BoardVO get(Long no);

    void insert(BoardVO board);

    void insertFile(BoardFileVO file);

    BoardFileVO getFile(Long fileId);

    BoardFileVO getFileByBoardNo(Long boardNo);
}