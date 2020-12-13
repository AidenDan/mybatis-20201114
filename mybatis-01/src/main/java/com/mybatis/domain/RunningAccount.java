package com.mybatis.domain;

import java.io.Serializable;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-12-9 21:17:46
 */
public class RunningAccount implements Serializable {
    private String serializeId;

    public String getSerializeId() {
        return serializeId;
    }

    public void setSerializeId(String serializeId) {
        this.serializeId = serializeId;
    }

    @Override
    public String toString() {
        return "RunningAccount{" +
                "serializeId='" + serializeId + '\'' +
                '}';
    }
}
