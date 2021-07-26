package com.cya.controller;

import com.cya.pojo.Goods;
import com.cya.pojo.User;
import com.cya.service.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/LostAndFound")
public class GoodsActionController {

    @Autowired
    @Qualifier("goodsServiceImpl")
    private GoodsServiceImpl goodsService;

    //跳转到个人信息页
    @RequestMapping("/toPerson")
    public String toPerson(Model model, HttpServletRequest request){

        String userId = (String) request.getSession().getAttribute("user_Id");
        List<Goods> myGoods = goodsService.queryGoods(null, userId, null);
        model.addAttribute("myList", myGoods);

        User user = (User) request.getSession().getAttribute("user");
        if (user.getAddress() == null) {
            user.setAddress("无");
        }
        model.addAttribute("myself",user);
        return "Person";
    }

    //跳转到Find页面
    @RequestMapping("/toFind")
    public String toFind(Model model){
        List<Goods> findList = goodsService.queryGoods("寻物启事", null, null);
        model.addAttribute("list",findList);
        return "Find";
    }

    //跳转到Lose页面
    @RequestMapping("/toLose")
    public String toLose(Model model){
        List<Goods> loseList = goodsService.queryGoods("失物招领", null, null);
        model.addAttribute("list",loseList);
        return "Lose";
    }

    //跳转到发布页面
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "Add";
    }


    //跳转到物品详情页
    @RequestMapping("/toGoodsDetail")
    public String toGoodsDetail(Model model, String id){
        List<Goods> goods = goodsService.queryGoods(null, null, id);
        Goods goodses = goodsService.queryGoodsOfUser(goods.get(0));
        model.addAttribute("goods", goodses);
        return "DetailMessage";
    }

    //跳转到物品更新页面
    @RequestMapping("/toUpdate")
    public String toUpdate(Model model, String id){
        List<Goods> goods = goodsService.queryGoods(null, null, id);
        model.addAttribute("goods", goods.get(0));
        return "UpdateGoods";
    }

    //跳转到个人信息更新界面
    @RequestMapping("/toUpdateMyself")
    public String toUpdateMyself(Model model, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if (user.getAddress() == null) {
            user.setAddress("无");
        }
        model.addAttribute("myself",user);
        return "ChangeMyMessage";
    }

}
