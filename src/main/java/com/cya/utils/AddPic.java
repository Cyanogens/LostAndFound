package com.cya.utils;

import com.cya.pojo.Goods;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class AddPic {
    public static Goods addPic(MultipartFile file, Goods goods) {

        //图片上传成功后，将图片写到数据库
        //保存图片的路径
        String filePath = "D:\\Code\\Practice\\SSM\\LostAndFound\\pic";
        File path = new File(filePath);
        if (!path.exists()){
            path.mkdir();
        }
        //获取原始图片的拓展名
        String originalFilename = file.getOriginalFilename();
        //新的文件名字，使用uuid随机生成数+原始图片名字，这样不会重复
        String newFileName = Uuid.uuid()+originalFilename;
        //封装上传文件位置的全路径，就是硬盘路径+文件名
        File targetFile = new File(path,newFileName);
        //把本地文件上传到已经封装好的文件位置的全路径就是上面的targetFile
        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        goods.setPic(newFileName);
        return goods;
    }
}
