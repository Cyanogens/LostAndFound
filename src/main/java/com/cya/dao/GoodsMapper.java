package com.cya.dao;

import com.cya.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {

    //增
    void addGoods(Goods goods);

    //删
    void deleteGoods(String goodsId);

    //改(根据id)
    void updateGoods(Goods goods);

    //查
    Goods queryGoods(int goodsId);
    List<Goods> queryTypeGoods(String typeTable);
    List<Goods> queryAllGoodsByUserId(String userId);
    //对于多个参数,要用@Param指明该参数代表什么
    List<Goods> queryFuzzyGoods(@Param("str") String str,@Param("label") String label,@Param("typeTable") String typeTable);
    Goods queryGoodsByGoodsId(String goodsId);
    Goods queryGoodsOfUser(Goods goods);

}
