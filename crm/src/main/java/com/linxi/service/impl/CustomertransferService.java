package com.linxi.service.impl;

import com.linxi.entity.Customertransfer;
import com.linxi.mapper.CustomertransferMapper;
import com.linxi.service.ICustomertransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author LongYi
 * @create 2020/8/1 16:20
 */
@Service
public class CustomertransferService implements ICustomertransferService{

    @Autowired
    private CustomertransferMapper customertransferMapper;

    @Override
    public Customertransfer queryTransferByCtcid(Integer ctcid) {
        return customertransferMapper.queryTransferByCtcid(ctcid);
    }

    @Override
    public void saveTransfer(Customertransfer ct) {
        customertransferMapper.saveTransfer(ct);
    }

    @Override
    public void editTransferByCtid(Customertransfer ct) {
        customertransferMapper.editTransferByCtid(ct);
    }
}
