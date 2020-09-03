package com.project.xghk416.enums;

import java.util.Arrays;
import java.util.List;

public enum PublicOfferingEnum {
    //这里是可以自己定义的，方便与前端交互即可
    POSITION(Arrays.asList("远程位","近战位")),
    PROFESSION(Arrays.asList("先锋干员","狙击干员","医疗干员","术师干员","近卫干员","重装干员","辅助干员","特种干员")),
    PROFESSION_SIMPLIFY(Arrays.asList("先锋","狙击","医疗","术师","近卫","重装","辅助","特种")),
    TAG(Arrays.asList("治疗","支援","输出","群攻","减速","生存","防护","削弱","位移","控场","爆发","召唤","快速复活","费用回复","支援机械")),
    ;

    private final List<String> list;

    PublicOfferingEnum(List<String> list) {
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    public boolean judgeIn(String tag){
        return list.contains(tag);
    }

}
