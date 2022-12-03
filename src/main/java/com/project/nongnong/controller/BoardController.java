package com.project.nongnong.controller;


import com.project.nongnong.domain.BoardEntity;
import com.project.nongnong.domain.UserEntity;
import com.project.nongnong.dto.BoardDTO;
import com.project.nongnong.dto.BoardPageResponseDTO;
import com.project.nongnong.dto.UserDTO;
import com.project.nongnong.exception.BoardException;
import com.project.nongnong.repository.BoardRepository;
import com.project.nongnong.repository.UserRepository;
import com.project.nongnong.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@Log4j2
@RequiredArgsConstructor // repository주입을 위해 사용
public class BoardController {


    // 레포지토리 주입받기
    private final BoardRepository boardRepository;
    private final BoardService boardService;


    // 게시글 작성하기
    @PostMapping("/api/board/write")
    public Long writeBoard(@RequestBody BoardDTO boardDTO) throws Exception {

        return boardService.save(boardDTO);


    }


    // 값을 빌더와 리스트를 이용해 여러개의 값을 담아 전달
    // 게시물 리스트 출력하기
    @GetMapping("/api/board/list")
    public Page<BoardPageResponseDTO> boardList(Pageable pageable) throws Exception {

        // List<BoardEntity> boardEntityListBy = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "boardkey"));
        return boardService.list(pageable);

    }
    @GetMapping("/api/board/list2")
    public Page<BoardPageResponseDTO> boardList2(Pageable pageable) throws Exception {

        // List<BoardEntity> boardEntityListBy = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "boardkey"));

        return boardService.list2(pageable);

    }


    // 게시글 상세 내용 보기
    @GetMapping("/api/board/{id}")
    public BoardEntity boardEntity(@PathVariable Long id) {
        // .findById()는 반환타입이 Optional이다, 즉 null을 반환할 수도 있다
        // 그렇기에 BoardEntity 를 Optional로 감싸준다
        Optional<BoardEntity> boardEntity = boardRepository.findById(id);
        if (boardEntity.isPresent()) {
            return boardEntity.get();
        }
        return null;
    }


    @ExceptionHandler(BoardException.class)
    public ResponseEntity<String> handlerNotFoundException(BoardException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // 같은 API주소지만 body에 데이터가 담겨있으면 PutMapping 을 통해 데이터를 수정할 수 있다.
    @PutMapping("/api/board/{id}")
    public String updateBoard(@PathVariable Long id, @RequestBody BoardDTO boardDTO) {
        Optional<BoardEntity> boardEntity = boardRepository.findById(id);

        String result = null;
        // if문을 사용하여 예외시 처리를 별도로 하고 코드실행
        if (!boardEntity.isPresent()) {
            // 예외발생시
            throw new BoardException("게시글이 존재하지 않습니다.");
        } else {
            boardEntity.get().setBoardtitle(boardDTO.getBoardtitle());
            boardEntity.get().setBoardcontent(boardDTO.getBoardcontent());
            boardEntity.get().setBoardmap(boardDTO.getBoardmap());
            boardRepository.save(boardEntity.get());
            log.info("게시글 수정 완료");
            result = "게시글 수정 완료";
        }

        // 이 경우 Optional이 아니기에 객체를 바로 받아 사용가능하다

//         BoardEntity boardEntity = boardRepository.findById(id)
//             .orElseThrow(() -> new BoardException("공지사항의 글이 존재하지 않습니다."));
//
//        boardEntity.get().setBoardtitle(boardDTO.getBoardtitle());
//        boardEntity.get().setBoardcontent(boardDTO.getBoardcontent());
//        boardEntity.get().setBoardmap(boardDTO.getBoardmap());
//        boardRepository.save(boardEntity.get());
//        log.info("게시글 수정 완료");
        return result;

    }

    // 조회수를 증가시키는 PatchMapping
    @PatchMapping("/api/board/{id}/views")
    public int boardViews(@PathVariable Long id) {
        BoardEntity boardEntity = boardRepository.findById(id)
                // 아이디를 찾음과 동시에 예외상황 발생할경우 예외처리 클래스를 생성하면서 오류메세지를 출력하고 있다.
                .orElseThrow(() -> new BoardException("게시글이 존재하지 않습니다."));

        boardEntity.setBoardviews(boardEntity.getBoardviews() + 1);
        int result = boardEntity.getBoardviews();
        boardRepository.save(boardEntity);
        return result;
    }

    @DeleteMapping("/api/board/{id}")
    public String deleteBoard(@PathVariable Long id) {

        BoardEntity boardEntity = boardRepository.findById(id)
                .orElseThrow(() -> new BoardException("게시글이 존재하지 않습니다."));

        boardRepository.delete(boardEntity);
        String result = "게시글 삭제 완료";
        return result;

    }

//    @DeleteMapping("/api/board/all")
//    public void deleteBoardAll() {
//        // List<BoardEntity> boardEntityList = boardRepository.findAll();
//        // 데이터를 전부 삭제하는건 관리자만 가능하게 해야함.
//        // 예제에선 게시글 데이터의 컬럼의 형태를 삭제여부? false -> true 이렇게 바꿨을뿐 실제 DB에선 삭제하지 않는다.
//    }



}
