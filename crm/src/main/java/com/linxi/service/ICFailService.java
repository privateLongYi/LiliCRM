package com.linxi.service;

import com.linxi.entity.CFail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/8/2 15:11
 */
public interface ICFailService {

    List<CFail> queryCF(@Param("page") Integer page,
                        @Param("limit") Integer limit);

    Integer getTotal();

    void saveCFail(CFail cf);

    void delCFByCfId(Integer cfId);

    CFail queryCFByCfId(Integer cfId);

    void editCFByCfId(CFail cf);

}
