package com.cya.dao;

import com.cya.pojo.Goods;

import java.util.List;

public interface GoodsMapper {

    //增
    int addGoods(Goods goods);

    //删
    int deleteGoods(int goodsId);

    //改(根据id)
    int updateGoods(Goods goods);

    //查
    Goods queryGoods(int goodsId);
    List<Goods> queryAllGoods();

    List<Goods> queryFuzzyGoods(String str, String label);

}
