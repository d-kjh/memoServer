package com.green.memoserver;

import com.green.memoserver.config.model.ResultResponse;
import com.green.memoserver.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ResultContext;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/memo")
public class MemoController {
    private final MemoService memoService;

    // Create (post) /api/memo
    @PostMapping
    public ResultResponse<Integer> postMemo(@RequestBody MemoPostReq req) {// @RequestBody를 쓰지 않으면 form 데이터로 인식
        log.info("req={}", req);
        int result = memoService.save(req);
        return new ResultResponse<>("삽입 성공", result);
    }

    // Read (get)
    @GetMapping
    public ResultResponse<List<MemoGetRes>> getMemo(@ModelAttribute MemoGetReq req) {
        log.info("req={}", req);
        List<MemoGetRes> result = memoService.findAll(req);
        String message = String.format("rows: %d", result.size());
        return new ResultResponse<>(message, result);
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
    public ResultResponse<MemoGetOneRes> getOneMemo(@PathVariable(name = "id") int id){
        log.info("id={}", id);
        MemoGetOneRes result = memoService.findById(id);
        return new ResultResponse<>("조회 성공", result);
    }

    //Update
    @PutMapping
    public ResultResponse<Integer> putMemo(@RequestBody MemoPutReq req){
        log.info("req={}", req);
        int result = memoService.modify(req);
        return new ResultResponse<>("수정 성공", result);

    }

    //Delete
    @DeleteMapping
    public ResultResponse<Integer> delMemo(@RequestParam(name = "id") int id){
        log.info("id={}", id);
        int result = memoService.deleteById(id);
        //int result = memoService.deleteById(id);
        // result == 1 ? "삭제 성공" : "삭제 실패";
        return new ResultResponse<>("삭제성공", result);
    }
}
