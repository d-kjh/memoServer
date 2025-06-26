package com.green.memoserver;

import com.green.memoserver.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/memo")
public class MemoController {
    private final MemoService memoService;

    // Create (post) /api/memo
    @PostMapping
    public String postMemo(@RequestBody MemoPostReq req) {// @RequestBody를 쓰지 않으면 form 데이터로 인식
        log.info("req={}", req);
        int result = memoService.save(req);
        return result == 1 ? "success" : "fail";
    }

    // Read (get)
    @GetMapping
    public List<MemoGetRes> getMemo(@ModelAttribute MemoGetReq req) {
        log.info("req={}", req);
        return memoService.findAll(req);
    }
//    public String getMemo(@RequestParam(name = "search_text", required = false) String searchText
//                        , @RequestParam(required = false) Integer page) {
        //log.info("search={}, page={}", searchText, page);
//        MemoGetReq req = MemoGetReq.builder()
//                                   .page(page)
//                                   .searchText(searchText)
//                                   .build();
        //memoService.getMomoList(searchText, page);
        //memoService.getMomoList(req);

    @GetMapping("{id}")
    public MemoGetOneRes getOneMemo(@PathVariable(name = "id") int id){
        log.info("id={}", id);
        return memoService.findById(id);
    }

    //Update
    @PutMapping
    public String putMemo(@RequestBody MemoPutReq req){
        log.info("req={}", req);
        return "수정 완료";
    }

    //Delete
    @DeleteMapping
    public int delMemo(@RequestParam(name = "id") int id){
        log.info("id={}", id);
        //int result = memoService.deleteById(id);
        // result == 1 ? "삭제 성공" : "삭제 실패";
        return memoService.deleteById(id);
    }
}
