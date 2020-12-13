package com.mybatis.dao;

import com.mybatis.domain.RunningAccount;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-12-9 21:19:36
 */
public interface IRunningAccountDao {
    int insertRunningAccountItems(RunningAccount runningAccount);
}
