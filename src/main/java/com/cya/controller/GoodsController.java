package com.cya.controller;

import com.cya.pojo.Goods;
import com.cya.service.GoodsServiceImpl;
import com.cya.utils.AddPic;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/LostAndFound")
public class GoodsController {

    @Autowired
    @Qualifier("goodsServiceImpl")
    private GoodsServiceImpl goodsService;

    //跳转到个人信息页
    @RequestMapping("/toPerson")
    public String toPerson(Model model, HttpServletRequest request){
        String user_id = (String) request.getSession().getAttribute("user_Id");
        List<Goods> myGoods = goodsService.queryAllGoodsByUserId(user_id);
        model.addAttribute("myList", myGoods);
        return "Person";
    }

    //跳转到Find页面
    @RequestMapping("/toFind")
    public String toFind(Model model){
        List<Goods> findList = goodsService.queryTypeGoods("寻物启事");
        model.addAttribute("list",findList);
        return "Find";
    }

    //跳转到Lose页面
    @RequestMapping("/toLose")
    public String toLose(){
        return "Lose";
    }

    //跳转到发布页面
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "Add";
    }


    //跳到物品详情页
    @RequestMapping("/toGoodsDetail")
    public String toGoodsDetail(Model model, String id){
        Goods goods = goodsService.queryGoodsByGoodsId(id);
        model.addAttribute("goods", goods);
        return "DetailMessage";
    }


    @RequestMapping("/toUpdate")
    //跳转到物品更新页面
    public String toUpdate(Model model,String id){
        Goods goods = goodsService.queryGoodsByGoodsId(id);
        model.addAttribute("goods", goods);
        return "UpdateGoods";
    }


    //进行添加操作
    @RequestMapping("/adding")
    //直接取发文者的userId
    public String addingGoods(Goods goods, MultipartFile file, HttpServletRequest request){
        String type = request.getParameter("type");
        goods.setTypeTable(type);
        String label = request.getParameter("label");
        goods.setLabel(label);

        String user_id = (String) request.getSession().getAttribute("user_Id");
        goods.setUserId(user_id);
        Goods goodses = AddPic.addPic(file, goods);

        goodsService.addGoods(goodses);
        if (type.equals("寻物启事"))
            return "redirect:/LostAndFound/toFind";
        else
            return  "redirect:/LostAndFound/toLose";
    }


    //寻物启事页
    @RequestMapping("/Finding")
    public String Finding(Model model){
        List<Goods> findList = goodsService.queryTypeGoods("寻物启事");
        model.addAttribute("list",findList);
        return "Find";
    }

    //失物招领页
    @RequestMapping("/Losing")
    public String Losing(Model model){
        List<Goods> loseList = goodsService.queryTypeGoods("失物招领");
        model.addAttribute("list",loseList);
        return "Lose";
    }

    //进行物品更新操作
    @RequestMapping("/updatingGoods")
    public String updatingGoods(Goods goods, MultipartFile file, HttpServletRequest request){
        String type = request.getParameter("type");
        goods.setTypeTable(type);
        String label = request.getParameter("label");
        goods.setTypeTable(label);
        Goods goodses = AddPic.addPic(file, goods);
        goodsService.updateGoods(goodses);
        return "redirect:/LostAndFound/toPerson";
    }


    //删除
    //通过goodsId删除
    @RequestMapping("/deleting")
    public String deleteGoods(String id){
        goodsService.deleteGoods(id);
        return "redirect:/LostAndFound/toPerson";
    }

    //模糊查询
    @RequestMapping()
    public String queryFuzzy(String str, Model model, HttpServletRequest request){
        String label = request.getParameter("label");
        String type = request.getParameter("type");
        List<Goods> goods = goodsService.queryFuzzyGoods(str,label,type);
        model.addAttribute("goodsList",goods);

        if (type.equals("寻物启事"))
            return "redirect:/LostAndFound/toFind";
        else
            return "redirect:/LostAndFound/toLose";
    }
}
