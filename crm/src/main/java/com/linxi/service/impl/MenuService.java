package com.linxi.service.impl;

import com.linxi.entity.Menu;
import com.linxi.mapper.MenuMapper;
import com.linxi.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author LongYi
 * @create 2020/9/7 19:55
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class MenuService implements IMenuService{

    @Autowired
    private MenuMapper menuMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Menu> queryMByMName(String mName, Integer page, Integer limit) {
        return menuMapper.queryMByMName(mName, page, limit);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getTotalByMName(String mName) {
        return menuMapper.getTotalByMName(mName);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Menu> queryMParent() {
        return menuMapper.queryMParent();
    }

    @Override
    public void saveMenu(Menu menu) {
        menuMapper.saveMenu(menu);
    }

    @Override
    public void delMByMId(Integer mId) {
        menuMapper.delMByMId(mId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Menu queryMByMId(Integer mId) {
        return menuMapper.queryMByMId(mId);
    }

    @Override
    public void editMByMId(Menu menu) {
        menuMapper.editMByMId(menu);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Menu> queryMenuAll() {
        return menuMapper.queryMenuAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Menu> queryMByMPId(Integer pId) {
        return menuMapper.queryMByMPId(pId);
    }
}
