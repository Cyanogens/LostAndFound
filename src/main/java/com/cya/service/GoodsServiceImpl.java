package com.cya.service;

import com.cya.dao.GoodsMapper;
import com.cya.pojo.Goods;
import com.cya.utils.Times;
import com.cya.utils.Uuid;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {

    private GoodsMapper goodsMapper;

    //spring注入
    public void setGoodsMapper(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }

    @Override
    public void addGoods(Goods goods) {
        goods.setGoodsId(Uuid.uuid());
        goods.setReleaseTime(Times.getTime());
        goodsMapper.addGoods(goods);
    }

    @Override
    public void deleteGoods(String goodsId) {
        goodsMapper.deleteGoods(goodsId);
    }

    @Override
    public void updateGoods(Goods goods) {
        goodsMapper.updateGoods(goods);
    }

    @Override
    public List<Goods> queryFuzzyGoods(String str, String label,String typeTable) {
        str = "%" + str + "%";
        return goodsMapper.queryFuzzyGoods(str,label,typeTable);
    }

    @Override
    public List<Goods> queryGoods(String typeTable, String userId, String goodsId) {
        return goodsMapper.queryGoods(typeTable,userId,goodsId);
    }

    @Override
    public Goods queryGoodsOfUser(Goods goods) {
        return goodsMapper.queryGoodsOfUser(goods);
    }

}
