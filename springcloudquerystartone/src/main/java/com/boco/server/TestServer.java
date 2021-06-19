package com.boco.server;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boco.entity.Test;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestServer extends BaseMapper<Test> {
}
