package com.cya.service;

import com.cya.pojo.Goods;

import java.util.List;

public interface GoodsService {

    //增
    void addGoods(Goods goods);

    //删
    void deleteGoods(String goodsId);

    //改(根据id)
    void updateGoods(Goods goods);

    //查
    List<Goods> queryTypeGoods(String str);
    List<Goods> queryFuzzyGoods(String str,String label, String typeTable);
    List<Goods> queryAllGoodsByUserId(String userId);
    Goods queryGoodsByGoodsId(String goodsId);
    Goods queryGoodsOfUser(Goods goods);
}
