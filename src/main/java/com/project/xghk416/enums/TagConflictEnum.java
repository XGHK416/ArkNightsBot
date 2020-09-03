package com.project.xghk416.enums;

import com.project.xghk416.util.ArrayUtil;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public enum TagConflictEnum {
    //这里是可以自己定义的，方便与前端交互即可
    RARITY_CONFLICT(Arrays.asList("高级资深干员","高质","高级资深","资深干员","新手")),
    POSITION_CONFLICT(Arrays.asList("远程位","近战位")),
    PROFESSION_CONFLICT(Arrays.asList("先锋干员","狙击干员","医疗干员","术师干员","近卫干员","重装干员","辅助干员","特种干员")),
    ;

    private final List<String> list;

    TagConflictEnum(List<String> list) {
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    public boolean filterConflict(List<String> tag) throws IOException, ClassNotFoundException {
        List<String> testList = ArrayUtil.deepCopy(tag);
        testList.retainAll(list);
        return testList.size() <= 1;
    }

}
