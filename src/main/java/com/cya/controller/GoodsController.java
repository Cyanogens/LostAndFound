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
    public String toPerson(){
        return "Person";
    }

    //跳转到Find页面
    @RequestMapping("/toFind")
    public String toFind(Model model){
        List<Goods> findList = goodsService.queryTypeGoods("寻物启事");
        model.addAttribute("list",findList);
        findList.forEach(System.out::println);
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
        System.out.println(type);
        System.out.println(label);

        if (type.equals("寻物启事"))
            return "redirect:/LostAndFound/toFind";
        else if (type.equals("失物招领"))
            return  "redirect:/LostAndFound/toLose";

        //重定向可防止刷新提交?
        return "Add";
    }

    //跳到更新页面
    @RequestMapping("/toUpdate")
    public String updateGoods(int id, Model model){
        Goods goods = goodsService.queryGoods(id);
        model.addAttribute("getGoods", goods);
        return "";
    }


    @RequestMapping("/Finding")
    public String Finding(Model model){
        List<Goods> findList = goodsService.queryTypeGoods("寻物启事");
        model.addAttribute("list",findList);
        return "Find";
    }
    @RequestMapping("/Losing")
    public String Losing(Model model){
        List<Goods> loseList = goodsService.queryTypeGoods("失物招领");
        model.addAttribute("list",loseList);
        return "Lose";
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
