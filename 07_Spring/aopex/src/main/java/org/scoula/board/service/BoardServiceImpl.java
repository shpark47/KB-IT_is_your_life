package org.scoula.board.service;

import lombok.RequiredArgsConstructor;
import org.scoula.board.mapper.BoardMapper;
import org.scoula.board.vo.BoardVO;
import org.scoula.board.vo.BoardFileVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl
        implements BoardService {

    private final BoardMapper mapper;

    @Override
    public List<BoardVO> getList() {
        return mapper.getList();
    }

    @Override
    public void register(BoardVO board,
                         MultipartFile file)
            throws IOException {

        mapper.insert(board);

        if(file != null && !file.isEmpty()) {

            BoardFileVO attach = new BoardFileVO();

            attach.setBoardNo(board.getNo());
            attach.setFileName(file.getOriginalFilename());
            attach.setContentType(file.getContentType());
            attach.setFileData(file.getBytes());

            mapper.insertFile(attach);
        }
    }
}