package com.project.xghk416.command;


import com.project.xghk416.pojo.PublicOfferingEntity;
import com.project.xghk416.pojo.po.ArkOperatorBasePo;
import com.project.xghk416.service.serviceImpl.ArkRobotServiceImpl;
import com.project.xghk416.service.serviceImpl.PublicOfferingServiceImpl;
import com.project.xghk416.util.*;
import com.xghk416.builder.MessageBuilder;
import com.xghk416.builder.components.ImgBuilder;
import com.xghk416.manager.components.AllMessageCommand;
import com.xghk416.pojo.CommandPrefix;
import com.xghk416.qq.BaseQq;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpPublicOfferingCommand implements AllMessageCommand {
    @Override
    public String run(BaseQq baseQq, ArrayList<String> arrayList) {
        if (arrayList.size()>6){
            return new MessageBuilder().add("词条最多选5个呢").toString();
        }
        if (!ArrayUtil.judgeHasSame(arrayList)){
            return new MessageBuilder().add("存在相同tag哦").toString();
        }
        PublicOfferingServiceImpl publicOfferingService= SpringUtils.getBean(PublicOfferingServiceImpl.class);
        List<List<String>> labelList = new ArrayList<>();
//        System.out.println(arrayList);
        List<String> bList=new ArrayList<String>();
//        获得所有组合
        ArrayUtil.getSonSet1(0,arrayList.subList(1,arrayList.size()),bList,labelList);
//        格式化所有组合
        List<PublicOfferingEntity> col = null;
        try {
            col = PublicOfferingUtil.reformForm(labelList);
//            是否存在非法词条
            if (col==null){
                return new MessageBuilder().add("存在未知tag，请重新选择").toString();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
//        为所有组合进行查询
        Map<String,List<ArkOperatorBasePo>> result = new HashMap<>();
        System.out.println(result);
        Map<List<String>,List<ArkOperatorBasePo>> resultToPng = new HashMap<>();
        for (PublicOfferingEntity item :
                col) {
            result.put(item.getAllTags(),publicOfferingService.getPublicOffering(item));
            resultToPng.put(item.getAllTagsList(),publicOfferingService.getPublicOffering(item));
        }
////        构建输出
//        String message = "";
//        for (Map.Entry<String, List<ArkOperatorBasePo>> entry : result.entrySet()) {
//            System.out.println(entry.getKey().length());
//            String values = "";
//            for (ArkOperatorBasePo op :
//                    entry.getValue()) {
//                values += op.getOperatorCn() + " ";
//            }
//            message += entry.getKey()+" : "+values+"\n";
//        }
////        构建图片
        String html = PublicOfferingUtil.getPOPic(resultToPng);
        String imgLocal = HtmlToImageUtil.html2Img(html,System.getProperty("user.dir")+"\\src\\main\\resources\\tempPic\\temp.png");
//        转base64
        String base64 = PicUtil.ImageToBase64(imgLocal);
//        删除源文件
        FileUtil.delFile(imgLocal);
        try {
            return new MessageBuilder().add(ImgBuilder.BaseCodeBuilder(base64)).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new MessageBuilder().add("错误").toString();
    }

    @Override
    public CommandPrefix commandPrefix() {
        return new CommandPrefix("app");
    }
//    @Override
//    public String run(EventMessage eventMessage, User user, String s, ArrayList<String> arrayList) {
//        if (arrayList.size()>5){
//            return new MessageBuilder().add("词条最多选5个呢").toString();
//        }
//        if (!ArrayUtil.judgeHasSame(arrayList)){
//            return new MessageBuilder().add("存在相同tag哦").toString();
//        }
//        PublicOfferingServiceImpl publicOfferingService= SpringUtils.getBean(PublicOfferingServiceImpl.class);
//        List<List<String>> labelList = new ArrayList<>();
////        System.out.println(arrayList);
//        List<String> bList=new ArrayList<String>();
////        获得所有组合
//        ArrayUtil.getSonSet1(0,arrayList,bList,labelList);
////        System.out.println(labelList);
////        格式化所有组合
//        List<PublicOfferingEntity> col = null;
//        try {
//            col = PublicOfferingUtil.reformForm(labelList);
////            是否存在非法词条
//            if (col==null){
//                return new MessageBuilder().add("存在未知tag，请重新选择").toString();
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
////        为所有组合进行查询
//        Map<String,List<ArkOperatorBasePo>> result = new HashMap<>();
//        Map<List<String>,List<ArkOperatorBasePo>> resultToPng = new HashMap<>();
//        for (PublicOfferingEntity item :
//                col) {
//            result.put(item.getAllTags(),publicOfferingService.getPublicOffering(item));
//            resultToPng.put(item.getAllTagsList(),publicOfferingService.getPublicOffering(item));
//        }
//////        构建输出
////        String message = "";
////        for (Map.Entry<String, List<ArkOperatorBasePo>> entry : result.entrySet()) {
////            System.out.println(entry.getKey().length());
////            String values = "";
////            for (ArkOperatorBasePo op :
////                    entry.getValue()) {
////                values += op.getOperatorCn() + " ";
////            }
////            message += entry.getKey()+" : "+values+"\n";
////        }
//////        构建图片
//        String html = PublicOfferingUtil.getPOPic(resultToPng);
//        String imgLocal = HtmlToImageUtil.html2Img(html,System.getProperty("user.dir")+"\\src\\main\\resources\\tempPic\\temp.png");
////        转base64
//        String base64 = PicUtil.ImageToBase64(imgLocal);
////        删除源文件
//        FileUtil.delFile(imgLocal);
//        return new MessageBuilder().add(new ComponentImageBase64(base64)).toString();
//    }


}
