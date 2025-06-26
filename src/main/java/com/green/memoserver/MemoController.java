package com.green.memoserver;

import com.green.memoserver.model.MemoPostReq;
import com.green.memoserver.model.MemoPutReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/memo")
public class MemoController {
    private final MemoService memoService;

    // C (post) /api/memo
    @PostMapping
    public String PostMemo(@RequestBody MemoPostReq req) {// @RequestBody를 쓰지 않으면 form 데이터로 인식
        log.info("req={}", req);
        return "성공";
    }

    // R (get)
    @GetMapping
    public String getMemo(@RequestParam(name = "search_text", required = false) String searchText,
                           @RequestParam(required = false) Integer page) {
        log.info("search_text={}, page={}", searchText, page);
        return "메모리스트";
    }

    @GetMapping("{memoId}")
    public String getMemo(@PathVariable(name = "memoId") int memoId){
        log.info("memoId={}", memoId);
        return "메모하나";
    }

    //Update
    @PutMapping
    public String PutMemo(@RequestBody MemoPutReq req){
        log.info("req={}", req);
        return "수정 완료";
    }

    //Delete
    @DeleteMapping
    public String DelMemo(@RequestParam(name = "memo_id") String memoId){
        log.info("memo_id={}", memoId);
        return "삭제 완료";
    }
}
