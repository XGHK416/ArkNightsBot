package com.project.xghk416.command;

import cc.moecraft.icq.command.CommandProperties;
import cc.moecraft.icq.command.interfaces.EverywhereCommand;
import cc.moecraft.icq.event.events.message.EventMessage;
import cc.moecraft.icq.sender.message.MessageBuilder;
import cc.moecraft.icq.sender.message.components.ComponentImage;
import cc.moecraft.icq.user.User;
import com.project.xghk416.service.serviceImpl.ArkRobotServiceImpl;
import com.project.xghk416.util.SpringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OpHelpCommand implements EverywhereCommand {

    @Override
    public String run(EventMessage eventMessage, User user, String s, ArrayList<String> arrayList) {
        List<String> commands = Arrays.asList(eventMessage.message.split("\\s+"));
        String introMsg = "";
        if (commands.size()>1){
            switch (commands.get(1)){
                case "apo":{
                     introMsg = "apo:查询干员卡片指令"+"\n"+
                             "使用方法:apo XXX(干员中文名) num(数字，可取1|2|3，代表不同专精等级)"+"\n"+
                             "如:apo 白金 1,代表查询干员白金的卡片及其技能专一时的说明。"+"\n"+
                             "[注]若不填数字,则默认返回全部等级的技能说明。";
                     break;
                }
                case "apm": {
                    introMsg = "apm:查询材料说明指令" + "\n" +
                            "待开发。";
                    break;
                }
                default:introMsg = "未知指令";
            }
        }else {
            introMsg = "白金助理可用指令:"+"\n"+
                    "apo:查询干员卡片"+"\n"+
                    "apm:查询材料卡片(未完工)"+"\n"+
                    "aph:帮助"+"\n"+
                    "使用'aph 指令'以便获得更多帮助。";
        }
        return new MessageBuilder().add(introMsg).toString();
    }

    @Override
    public CommandProperties properties() {
        return new CommandProperties("h");
    }

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
