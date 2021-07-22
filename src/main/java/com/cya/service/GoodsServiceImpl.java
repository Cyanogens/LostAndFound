package com.cya.service;


import com.cya.dao.GoodsMapper;
import com.cya.pojo.Goods;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {

    private GoodsMapper goodsMapper;

    public void setGoodsMapper(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }

    @Override
    public int addGoods(Goods goods) {
        return goodsMapper.addGoods(goods);
    }

    @Override
    public int deleteGoods(int goodsId) {
        return goodsMapper.deleteGoods(goodsId);
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsMapper.updateGoods(goods);
    }

    @Override
    public Goods queryGoods(int goodsId) {
        return goodsMapper.queryGoods(goodsId);
    }

    @Override
    public List<Goods> queryAllGoods() {
        return goodsMapper.queryAllGoods();
    }

    @Override
    public List<Goods> queryFuzzyGoods(String str, String label) {
        str = "%" + str + "%";
        return goodsMapper.queryFuzzyGoods(str,label);
    }
}
