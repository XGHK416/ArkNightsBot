package com.project.xghk416.util;

import com.project.xghk416.enums.PublicOfferingEnum;
import com.project.xghk416.enums.TagConflictEnum;
import com.project.xghk416.pojo.PublicOfferingEntity;
import com.project.xghk416.pojo.po.ArkOperatorBasePo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PublicOfferingUtil {
    public static List<PublicOfferingEntity> reformForm(List<List<String>> labelList) throws IOException, ClassNotFoundException {
        List<PublicOfferingEntity> formList = new ArrayList<>();
        for (List<String> labelItem :
                labelList) {
            if (TagCombinationFilter(labelItem)){
                PublicOfferingEntity item= reform(labelItem);
                if (item==null){
                    return null;
                }else {
                    formList.add(reform(labelItem));
                }
            }
        }
        return formList;
    }
    public static PublicOfferingEntity reform(List<String> labels){
        PublicOfferingEntity item= new PublicOfferingEntity();
        List<String> positionList = new ArrayList<>();
        List<String> professionList = new ArrayList<>();
        List<String> tagList = new ArrayList<>();
        for (String tag:
             labels) {
            if ("高级资深干员".equals(tag)||"高资".equals(tag)||"高级资深".equals(tag)){
                item.setHasHeightElite(true);
            }else if ("资深干员".equals(tag)||"资深".equals(tag)){
                item.setHasElite(true);
            }else if ("新手".equals(tag)){
                item.setHasNew(true);
            }
            else if (PublicOfferingEnum.POSITION.judgeIn(tag)){
                positionList.add(tag);
            }else if (PublicOfferingEnum.PROFESSION.judgeIn(tag)||PublicOfferingEnum.PROFESSION_SIMPLIFY.judgeIn(tag)){
                professionList.add(tag.replace("干员",""));
            }else if (PublicOfferingEnum.TAG.judgeIn(tag)){
                tagList.add(tag);
            }else {
                return null;
            }
        }
        item.setProfession(professionList);
        item.setTag(tagList);
        item.setPosition(positionList);
        return item;
    }
    public static Boolean TagCombinationFilter(List<String> tags) throws IOException, ClassNotFoundException {
        boolean flag = true;
        if (!TagConflictEnum.PROFESSION_CONFLICT.filterConflict(tags)){
            flag = false;
        }
        if (!TagConflictEnum.POSITION_CONFLICT.filterConflict(tags)){
            flag = false;
        }
        if (!TagConflictEnum.RARITY_CONFLICT.filterConflict(tags)){
            flag = false;
        }
        return flag;
    }
//    构建html，并创建png
    public static String getPOPic(Map<List<String>,List<ArkOperatorBasePo>> maps){

        String totalHtml = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Document</title>\n" +
                "    <style type=\"text/css\">\n" +
                "        button{\n" +
                "            margin: .25em;\n" +
                "            white-space: nowrap;\n" +
                "            background-color: transparent;\n" +
                "        }\n" +
                "        .mdc-button {\n" +
                "            font-family: Roboto,sans-serif;\n" +
                "            font-size: .875rem;\n" +
                "            letter-spacing: .0892857143em;\n" +
                "            text-decoration: none;\n" +
                "            text-transform: uppercase;\n" +
                "            min-width: 64px;\n" +
                "            height: 36px;\n" +
                "            border: none;\n" +
                "            padding: 0 10px;\n" +
                "            outline: none;\n" +
                "            line-height: 36px;\n" +
                "            text-align: center;\n" +
                "            border-radius: 2px;\n" +
                "        }\n" +
                "        .inline-block{\n" +
                "            display: inline;\n" +
                "        }\n" +
                "        .mdc-card{\n" +
                "            margin: 8px 4px;\n" +
                "            background-color: #363636;\n" +
                "            border-radius: 2px;\n" +
                "            box-shadow: 0 3px 1px -2px #0003, 0 2px 2px 0 #00000024, 0 1px 5px 0 #0000001f;\n" +
                "            display: flex;\n" +
                "            flex-direction: column;\n" +
                "            box-sizing: border-box;\n" +
                "        }\n" +
                "        .p-25{\n" +
                "            padding: .25em;\n" +
                "        }\n" +
                "       \n" +
                "        .mdc-button.mdc-button--outlined{\n" +
                "            padding: 0 .5em;\n" +
                "            background-color: #bbbbbb;\n" +
                "        }\n" +
                "        .mdc-button--outlined {\n" +
                "            border-style: solid;\n" +
                "            padding: 0 14px;\n" +
                "            border-width: 2px;\n" +
                "        }\n" +
                "        /* 各个等级的颜色 */\n" +
                "        .char-lvl-6{\n" +
                "            background-color: #d0694e;\n" +
                "            color: #fff;\n" +
                "        }\n" +
                "        .char-lvl-5{\n" +
                "            background-color: #f9ce8c;\n" +
                "            color: #1a1d1e;\n" +
                "        }\n" +
                "        .char-lvl-4{\n" +
                "            background-color: #589bad;\n" +
                "            color: #fff;\n" +
                "        }\n" +
                "        .char-lvl-3{\n" +
                "            background-color: #7ebc59;\n" +
                "            color: #fff;\n" +
                "        }\n" +
                "        .char-lvl-2{\n" +
                "            background-color: #c3e3e5;\n" +
                "            color: #1a1d1e;\n" +
                "        }\n" +
                "        .char-lvl-1{\n" +
                "            background-color: #1a1d1e;\n" +
                "            color: #fff;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body style=\"background-color:#3f3f3f;\">\n" +
                "<div>\n"+
                buildHtml(maps)+
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        return totalHtml;
    }
    public static String buildHtml(Map<List<String>,List<ArkOperatorBasePo>> maps){
        String units = "";
        for (Map.Entry<List<String>, List<ArkOperatorBasePo>> entry : maps.entrySet()) {
            if (entry.getValue().size()==0){
                continue;
            }
            String tagHtml = buildTagHtml(entry.getKey());
            String opHtml = buildOpHtml(entry.getValue());
            units += reformUnitHtml(tagHtml,opHtml);
        }
        return units;
    }
    public static String reformUnitHtml(String tag,String op){
        String unitHtml = " <div class=\"mdc-card\">\n" +
                "            <div class=\"p-25 inline-block\">" +
                tag+
                "            </div>\n" +
                "            <span class=\"p-25\">"+
                op+
                " </span>\n" +
                "</div>";
        return unitHtml;
    }
    public static String buildTagHtml(List<String> tags){
        String tagHtml = "";
        for (String tag :
                tags) {
            tagHtml +=  "                <button class=\"btn-tag mdc-button--outlined mdc-button\">\n" +
                        tag+
                        "                </button>     \n";
        }
        return tagHtml;
    }
    public static String buildOpHtml(List<ArkOperatorBasePo> ops){
        String opHtml = "";
        for (ArkOperatorBasePo op :
                ops) {
            switch (op.getOperatorRarity()){
                case 0:{
                    opHtml+="                <button class=\"char-lvl-1 mdc-button\">\n"+op.getOperatorCn() +
                            "                </button>\n";
                    break;
                }
                case 1:{
                    opHtml+="                <button class=\"char-lvl-2 mdc-button\">\n"+op.getOperatorCn() +
                            "                </button>\n";
                    break;
                }
                case 2:{
                    opHtml+="                <button class=\"char-lvl-3 mdc-button\">\n"+op.getOperatorCn() +
                            "                </button>\n";
                    break;
                }
                case 3:{
                    opHtml+="                <button class=\"char-lvl-4 mdc-button\">\n"+op.getOperatorCn() +
                            "                </button>\n";
                    break;
                }
                case 4:{
                    opHtml+="                <button class=\"char-lvl-5 mdc-button\">\n"+op.getOperatorCn() +
                            "                </button>\n";
                    break;
                }
                case 5:{
                    opHtml+="                <button class=\"char-lvl-6 mdc-button\">\n"+op.getOperatorCn() +
                            "                </button>\n";
                    break;
                }
            }
        }
        return opHtml;

    }

}
