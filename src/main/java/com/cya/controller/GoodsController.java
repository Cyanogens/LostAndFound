package com.cya.controller;

import com.cya.pojo.Goods;
import com.cya.service.GoodsServiceImpl;
import com.cya.utils.AddPic;
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

    //登录
    @RequestMapping("/login")
    public String login(){
        return "All";
    }

    //展示所有物品
    @RequestMapping("/main")
    public String allGoods(Model model){
        List<Goods> goods = goodsService.queryAllGoods();
        model.addAttribute("list", goods);
        return "All";
    }

    //跳转到添加页面
    @RequestMapping("/toAdd")
    public String addGoods(){
        return "Add";
    }

    //进行添加操作
    @RequestMapping("/adding")
    //直接取发文者的userId
    public String addingGoods(Goods goods, MultipartFile file, HttpServletRequest request){
        String type = request.getParameter("type");
        goods.setTypeTable(type);
        String label = request.getParameter("label");
        goods.setTypeTable(label);
        Goods goodses = AddPic.addPic(file, goods);
        goodsService.addGoods(goodses);
        //重定向可防止刷新提交?
        return "redirect:/All.html";
    }

    //跳到更新页面
    @RequestMapping("/toUpdate")
    public String updateGoods(int id, Model model){
        Goods goods = goodsService.queryGoods(id);
        model.addAttribute("getGoods", goods);
        return "";
    }

    //进行更新操作
    @RequestMapping("/updating")
    public String updatingGoods(Goods goods, MultipartFile file, HttpServletRequest request){
        String type = request.getParameter("type");
        goods.setTypeTable(type);
        String label = request.getParameter("label");
        goods.setTypeTable(label);
        Goods goodses = AddPic.addPic(file, goods);
        goodsService.updateGoods(goodses);
        return "redirect:/Person";
    }

    //跳到挂失信息页面
    @RequestMapping("toFind")
    public String toFindLost(){
        return "All";
    }

//    //删除
//    //通过goodsId删除
//    @RequestMapping("/delete")
//    public String deleteGoods(int id){
//        goodsService.deleteGoods(id);
//        return "Person";
//    }

    //模糊查询
    @RequestMapping()
    public String queryFuzzy(String str, Model model, HttpServletRequest request){
        String label = request.getParameter("label");
        List<Goods> goods = goodsService.queryFuzzyGoods(str,label);
        model.addAttribute("",goods);
        return "";
    }
}
