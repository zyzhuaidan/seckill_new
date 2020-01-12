package com.zyz.seckill.redis;

public class SeckillUserKey extends BasePrefix {
    private static final int TOKEN_EXPIRE = 3600*24*2;
    public SeckillUserKey(int expireSeconds,String prefix) {
        super(expireSeconds,prefix);
    }

    public static SeckillUserKey token = new SeckillUserKey(TOKEN_EXPIRE,"tk");
    public static SeckillUserKey getByName = new SeckillUserKey(TOKEN_EXPIRE,"name");


}
