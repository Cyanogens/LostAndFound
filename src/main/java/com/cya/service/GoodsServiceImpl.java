package com.cya.service;


import com.cya.dao.GoodsMapper;
import com.cya.pojo.Goods;
import com.cya.utils.Times;
import com.cya.utils.Uuid;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {

    private GoodsMapper goodsMapper;

    public void setGoodsMapper(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }

    @Override
    public int addGoods(Goods goods) {
        goods.setGoodsId(Uuid.uuid());
        goods.setTimes(Times.getTime());
        return goodsMapper.addGoods(goods);
    }

    @Override
    public int deleteGoods(String goodsId) {
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
    public List<Goods> queryTypeGoods(String str) {
        return goodsMapper.queryTypeGoods(str);
    }

    @Override
    public List<Goods> queryFuzzyGoods(String str, String label,String typeTable) {
        str = "%" + str + "%";
        return goodsMapper.queryFuzzyGoods(str,label,typeTable);
    }

    @Override
    public List<Goods> queryAllGoodsByUserId(String userId) {
        return goodsMapper.queryAllGoodsByUserId(userId);
    }

    @Override
    public Goods queryGoodsByGoodsId(String goodsId) {
        return goodsMapper.queryGoodsByGoodsId(goodsId);
    }

}
