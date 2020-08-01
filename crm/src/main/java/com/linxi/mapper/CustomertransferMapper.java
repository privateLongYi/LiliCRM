package com.linxi.mapper;

import com.linxi.entity.Customertransfer;

public interface CustomertransferMapper {

    Customertransfer queryTransferByCtcid(Integer ctcid);

    void saveTransfer(Customertransfer ct);

    void editTransferByCtid(Customertransfer ct);

}