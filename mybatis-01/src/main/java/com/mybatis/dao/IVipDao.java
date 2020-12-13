package com.mybatis.dao;

import com.mybatis.domain.Vip;

import java.util.List;

/**
 * @author Aiden
 * @version 1.0
 * @description  vip表的持久层接口
 * @date 2020-11-14 13:52:25
 */
public interface IVipDao {

    /**
     * 获取所有的vip信息
     *
     * @return List<Vip>
     */
    List<Vip> getAllVipInfo();

    int insertOneVipInfo(Vip vip);
}
