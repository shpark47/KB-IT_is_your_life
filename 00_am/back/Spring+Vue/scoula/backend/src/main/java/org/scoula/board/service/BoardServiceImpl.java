package org.scoula.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.domain.BoardVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.mapper.BoardMapper;
import org.scoula.common.util.UploadFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service //스프링 시작할 때 스캔해서 싱글톤으로 만들어줌.
@RequiredArgsConstructor //생성자호출할 때 Autowired해줌.
@Log4j2
public class BoardServiceImpl implements BoardService {

    //    @Autowired
    final private BoardMapper mapper;

    private final static String BASE_DIR = "c:/upload/board";

    @Override
    public List<BoardDTO> getList() {

        //전처리하고
        //db처리해달라고 요청
        //db처리 싱글톤 객체 여기에서 써야함.
        return mapper.getList().stream().map(BoardDTO::of).toList();
        //List<BoardVO> --> Stream<BoardVO> --> Stream<BoardDTO> --> List<BoardDTO>
    }

    @Override
    public BoardDTO get(Long no) {
        log.info("서비스의 get() 호출됨...");
        return BoardDTO.of(mapper.get(no));
    }

//    @Override
//    public BoardDTO create(BoardDTO board) {
//        BoardVO vo = board.toVo();
//        mapper.create(vo);
//        board.setNo(vo.getNo()); //dto에 db에서 생성된 no를 넣어줌.
//        return get(vo.getNo());
//    }

    @Override
    public BoardDTO update(BoardDTO board) {
        log.info("update...... " + board);
        BoardVO boardVO = board.toVo();
        log.info("update...... " + boardVO);
        mapper.update(boardVO);
        // 파일 업로드 처리
        List<MultipartFile> files = board.getFiles();
        if(files != null && !files.isEmpty()) {
            upload(board.getNo(), files);
        }
        return get(board.getNo());
    }


    @Override
    public BoardDTO delete(Long no) {
        log.info("delete...." + no);
        BoardDTO board = get(no);
        mapper.delete(no);
        return board;
    }

    // 2개 이상의 insert 문이 실행될 수 있으므로 트랜잭션 처리 필요
    // RuntimeException인 경우만 자동 rollback.
    @Transactional // 2개 이상의 insert 문이 실행될 수 있으므로 트랜잭션 처리 필요
    @Override
    public BoardDTO create(BoardDTO board) {
        log.info("create......" + board);

        BoardVO boardVO= board.toVo();
        mapper.create(boardVO);

        // 파일 업로드 처리
        List<MultipartFile> files = board.getFiles();
        if(files != null && !files.isEmpty()) {
            upload(boardVO.getNo(), files);
        }
        return get(boardVO.getNo());
    }


    private void upload(Long bno, List<MultipartFile> files) {
        for (MultipartFile part : files) {
            if (part.isEmpty()) continue;
            try {
                String uploadPath = UploadFiles.upload(BASE_DIR, part);
                BoardAttachmentVO attach = BoardAttachmentVO.of(part, bno, uploadPath);
                mapper.createAttachment(attach);
            } catch (IOException e) {
                throw new RuntimeException(e); // @Transactional에서 감지, 자동 rollback
            }
        }
    }

    // 첨부파일 한 개 얻기
    @Override
    public BoardAttachmentVO getAttachment(Long no) {
        return mapper.getAttachment(no);

    }

    // 첨부파일 삭제
    @Override
    public boolean deleteAttachment(Long no) {
        return mapper.deleteAttachment(no) == 1;
    }
}
