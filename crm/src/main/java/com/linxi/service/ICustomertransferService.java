package com.linxi.service;

import com.linxi.entity.Customertransfer;

/**
 * @Author LongYi
 * @create 2020/8/1 16:20
 */
public interface ICustomertransferService {

    Customertransfer queryTransferByCtcid(Integer ctcid);

    void saveTransfer(Customertransfer ct);

    void editTransferByCtid(Customertransfer ct);

}
