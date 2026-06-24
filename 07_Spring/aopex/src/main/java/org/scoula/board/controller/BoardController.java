package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import org.scoula.board.mapper.BoardMapper;
import org.scoula.board.service.BoardService;
import org.scoula.board.vo.BoardFileVO;
import org.scoula.board.vo.BoardVO;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.net.URLEncoder;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;
    private final BoardMapper mapper;

    @GetMapping("/list")
    public String list(Model model){

        model.addAttribute(
                "list",
                service.getList());

        return "board/list";
    }

    @GetMapping("/register")
    public String registerForm(){
        return "board/register";
    }

    @PostMapping("/register")
    public String register(BoardVO board,
                           MultipartFile uploadFile)
            throws Exception {

        service.register(board, uploadFile);

        return "redirect:/board/list";
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<byte[]> download(
            @PathVariable Long fileId)
            throws Exception {

        BoardFileVO file = mapper.getFile(fileId);

        String fileName =
                URLEncoder.encode(
                        file.getFileName(),
                        "UTF-8");

        return ResponseEntity.ok()
                .contentType(
                        MediaType.APPLICATION_OCTET_STREAM)
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" +
                                fileName + "\"")
                .body(file.getFileData());
    }

    @GetMapping("/read")
    public String read(Long no,
                       Model model){

        model.addAttribute(
                "board",
                mapper.get(no));

        model.addAttribute(
                "file",
                mapper.getFileByBoardNo(no));

        return "board/read";
    }
}