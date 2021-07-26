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

    //进行添加操作
    // 直接取发文者的userId
    @RequestMapping("/adding")
    public String addingGoods(Goods goods, MultipartFile file, HttpServletRequest request){

        String userId = (String) request.getSession().getAttribute("user_Id");
        goods.setUserId(userId);

        String type = request.getParameter("type");
        goods.setTypeTable(type);

        String label = request.getParameter("label");
        goods.setLabel(label);
        Goods goodses = AddPic.addPic(file, goods);

        goodsService.addGoods(goodses);
        if ("寻物启事".equals(type)) {
            return "redirect:/LostAndFound/toFind";
        }
        else {
            return "redirect:/LostAndFound/toLose";
        }
    }

    //进行物品更新操作
    @RequestMapping("/updatingGoods")
    public String updatingGoods(Goods goods, MultipartFile file, HttpServletRequest request){

        String type = request.getParameter("type");
        goods.setTypeTable(type);

        String label = request.getParameter("label");
        goods.setTypeTable(label);

        String userId = (String) request.getSession().getAttribute("user_Id");
        goods.setUserId(userId);

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
    @RequestMapping("/fuzzy")
    public String queryFuzzy(String str, Model model, HttpServletRequest request){
        String label = request.getParameter("label");
        String type = request.getParameter("type");
        System.out.println(label);
        System.out.println(type);
        List<Goods> goods = goodsService.queryFuzzyGoods(str,label,type);
        model.addAttribute("list",goods);

        if ("寻物启事".equals(type)) {
            return "Find";
        }
        else {
            return "Lose";
        }
    }
}
