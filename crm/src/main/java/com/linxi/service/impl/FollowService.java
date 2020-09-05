package com.linxi.service.impl;

import com.linxi.entity.Follow;
import com.linxi.mapper.FollowMapper;
import com.linxi.service.IFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/5 15:42
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class FollowService implements IFollowService{

    @Autowired
    private FollowMapper followMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Follow> queryFByFCId(Integer fCId) {
        return followMapper.queryFByFCId(fCId);
    }
}
