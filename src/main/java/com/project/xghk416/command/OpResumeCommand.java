package com.project.xghk416.command;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.project.xghk416.pojo.dao.ArkOperatorBaseDao;
import com.project.xghk416.pojo.po.ArkOperatorBasePo;
import com.project.xghk416.service.serviceImpl.ArkRobotServiceImpl;
import com.project.xghk416.util.SpringUtils;
import com.xghk416.builder.MessageBuilder;
import com.xghk416.builder.components.ImgBuilder;
import com.xghk416.manager.components.AllMessageCommand;
import com.xghk416.pojo.CommandPrefix;
import com.xghk416.qq.BaseQq;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class OpResumeCommand implements AllMessageCommand {

//    @Override
//    public String run(EventMessage eventMessage, User user, String s, ArrayList<String> arrayList) {
//        ArkRobotServiceImpl arkRobotService= SpringUtils.getBean(ArkRobotServiceImpl.class);
//        String rankType = "default";
//        String baseUrl = "https://xghk416.oss-cn-beijing.aliyuncs.com/arkWiki/OperatorResumeCard/";
//        List<String> commands = Arrays.asList(eventMessage.message.split("\\s+"));
////        System.out.println(commands);
//        if (commands.size()==3){
//            if (arkRobotService.judgeHasOperator(commands.get(1))){
//                return new MessageBuilder()
//                        .add("没找到该干员")
//                        .toString();
//            }
//            if (judgeRankType(commands.get(2))){
//                rankType = commands.get(2);
//            }
//        }else if (commands.size()==2){
//            if (arkRobotService.judgeHasOperator(commands.get(1))){
//                return new MessageBuilder()
//                        .add("没找到该干员")
//                        .toString();
//            }
//        }else {
//            return new MessageBuilder()
//                    .add("指令不完整")
//                    .toString();
//        }
//
////        https://xghk416.oss-cn-beijing.aliyuncs.com/arkWiki/op/12F_rank_default.png
//        String completeUrl = baseUrl+commands.get(1)+"_rank_"+rankType+".png";
////        System.out.println(completeUrl);
////        System.out.println(eventMessage.message);
//        return new MessageBuilder()
//                .add(new ComponentImage(completeUrl))
//                .toString();
//    }

    @SneakyThrows
    @Override
    public String run(BaseQq baseQq, ArrayList<String> arrayList) {
        ArkRobotServiceImpl arkRobotService= SpringUtils.getBean(ArkRobotServiceImpl.class);
        String rankType = "default";
        String baseUrl = "https://xghk416.oss-cn-beijing.aliyuncs.com/arkWiki/OperatorResumeCard/";
//        System.out.println(commands);
        if (arrayList.size()==2) {
            if (arkRobotService.judgeHasOperator(arrayList.get(1))) {
                return new MessageBuilder()
                        .add("没找到该干员")
                        .toString();
            }
        }else {
            return new MessageBuilder()
                    .add("指令不完整")
                    .toString();
        }

//        https://xghk416.oss-cn-beijing.aliyuncs.com/arkWiki/op/12F_rank_default.png
        String completeUrl = baseUrl+ URLEncoder.encode(arrayList.get(1),"utf-8")+"_rank_default.png";
        return new MessageBuilder().add(ImgBuilder.UrlBuilder(completeUrl)).toString();
    }

    @Override
    public CommandPrefix commandPrefix() {
        return new CommandPrefix("apo");
    }

    @Deprecated
    public Boolean judgeRankType(String type){
//        System.out.println(type);
        boolean result = false;
        boolean isNum = type.matches("[0-9]*");
//        System.out.println(isNum);
        if (isNum) {
            if (Integer.parseInt(type) > 0 && Integer.parseInt(type) <= 3) {
                result = true;
            }
        }
        return result;
    }

}
