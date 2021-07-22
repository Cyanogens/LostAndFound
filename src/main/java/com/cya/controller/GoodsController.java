package com.cya.controller;

import com.cya.pojo.Goods;
import com.cya.service.GoodsServiceImpl;
import com.cya.utils.AddPic;
import com.cya.utils.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GoodsController {

    @Autowired
    @Qualifier("serviceGoods")
    private GoodsServiceImpl goodsService;

    //展示所有物品
    @RequestMapping()
    public String allGoods(Model model){
        List<Goods> goods = goodsService.queryAllGoods();
        model.addAttribute("list", goods);
        return "";
    }

    //跳转到添加页面
    @RequestMapping("")
    public String addGoods(){
        return "";
    }

    //进行添加操作
    @RequestMapping("")
    //直接取发文者的userId
    public String addingGoods(Goods goods, MultipartFile file, HttpServletRequest request){
        String label = request.getParameter("");
        goods.setLabel(label);
        goods.setGoodsId(Uuid.uuid());
        Goods goodses = AddPic.addPic(file, goods);
        goodsService.addGoods(goodses);
        //重定向可防止刷新提交?
        return "";
    }

    //跳到更新页面
    @RequestMapping("")
    public String updateGoods(int id, Model model){
        Goods goods = goodsService.queryGoods(id);
        model.addAttribute("", goods);
        return "";
    }

    //进行更新操作
    @RequestMapping("")
    public String updatingGoods(Goods goods, MultipartFile file){
        Goods goodses = AddPic.addPic(file, goods);
        goodsService.updateGoods(goodses);
        return "";
    }

    //删除
    //通过goodsId删除
    @RequestMapping("")
    public String deleteGoods(int id){
        goodsService.deleteGoods(id);
        return "";
    }

    //模糊查询
    @RequestMapping("")
    public String queryFuzzy(@RequestParam("") String str, Model model, HttpServletRequest request){
        String label = request.getParameter("label");
        List<Goods> goods = goodsService.queryFuzzyGoods(str,label);
        model.addAttribute("",goods);
        return "";
    }
}
