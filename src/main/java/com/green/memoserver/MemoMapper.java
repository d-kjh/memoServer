package com.green.memoserver;

import com.green.memoserver.model.MemoPostReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // 빈등록
public interface MemoMapper {

    int postMemo(MemoPostReq req);
    List<MemoPostReq> getMemoRes();
}
