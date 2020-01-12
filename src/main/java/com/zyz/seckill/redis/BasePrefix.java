package com.zyz.seckill.redis;

import javax.swing.*;

public abstract class BasePrefix implements KeyPrefix {
    //过期时间
    /*
    0表示永不过期
     */
    private int expireSeconds;
    private String prefix;

    public BasePrefix(String prefix) {//0表示永不过期
        this(0, prefix);
    }

    public BasePrefix(int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    @Override
    public int expireSeconds() {
        return expireSeconds;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className + ":" + prefix;
    }
}
