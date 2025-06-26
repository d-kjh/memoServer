package com.green.memoserver;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service // 빈등록
@RequiredArgsConstructor
    public class MemoService {
        private final MemoMapper memoMapper;

}
