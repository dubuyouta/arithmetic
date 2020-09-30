package com.example.algorithm.rectuting;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author heshineng
 * created by 2020/9/18
 */
public class GoodsSubscribeManager {
    /**
     * 同时有N个商品（用long类型的商品id表示），每个商品都可以被任何一个用户（long类型的用户id）订阅，
     * 每被订阅一次，该商品的订阅数加1，
     * 同一个用户对同一个商品只能订阅一次 编辑写一个类，
     * 用3个方法提供以下功能（这3个方法都是在单机多线程环境下调用）：
     * 1）为指定的用户id订阅指定的商品id
     * 2) 返回所有商品的订阅总数
     * 3）根据商品ID返回这个商品的订阅数
     */

    private Map<Long, Set<Long>> goodsSubscribeMap = new HashMap<>();

    ReadWriteLock lock = new ReentrantReadWriteLock();

    Lock readLock = lock.readLock();

    Lock writeLock = lock.writeLock();

    public boolean subscribe(long userId, long goodsId) {
        try {
            writeLock.lockInterruptibly();
            Set<Long> userIdSet = goodsSubscribeMap.get(goodsId);
            if (userIdSet == null) {
                userIdSet = new HashSet<>();
                goodsSubscribeMap.put(goodsId, userIdSet);
            }
            return userIdSet.add(userId);
        } catch (InterruptedException e) {

        } finally {
            writeLock.unlock();
        }
        return false;
    }

    public int allGoodsSubscribeCount() {
        int count = 0;
        try {
            readLock.lockInterruptibly();
            for (Set<Long> value : goodsSubscribeMap.values()) {
                count += value.size();
            }
        } catch (InterruptedException e) {

        } finally {
            readLock.unlock();
        }
        return count;
    }

    public int GoodsSubscribeCountByGoodId(int goodsId) {
        Set<Long> userIdSet = goodsSubscribeMap.get(goodsId);
        if(userIdSet!=null){
            return userIdSet.size();
        }
        return 0;
    }


}
