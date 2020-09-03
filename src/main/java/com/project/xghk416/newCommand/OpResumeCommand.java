package com.project.xghk416.newCommand;

import com.xghk416.builder.MessageBuilder;
import com.xghk416.builder.components.ImgBuilder;
import com.xghk416.manager.components.AllMessageCommand;
import com.xghk416.manager.components.GroupMessageCommand;
import com.xghk416.pojo.CommandPrefix;
import com.xghk416.qq.BaseQq;
import com.xghk416.qq.GroupQqMessage;
import com.xghk416.util.ImageUtil;
import lombok.SneakyThrows;

import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class OpResumeCommand implements AllMessageCommand {
    @SneakyThrows
    @Override
    public String run(BaseQq qqInfo, ArrayList<String> commandParameter) {
        String baseUrl = "https://xghk416.oss-cn-beijing.aliyuncs.com/arkWiki/OperatorResumeCard/";
        String completeUrl = baseUrl+ URLEncoder.encode("白金","utf-8")+"_rank_default.png";
        return new MessageBuilder().add(ImgBuilder.UrlBuilder(completeUrl)).add("年后").toString();
    }

    @Override
    public CommandPrefix commandPrefix() {
        return new CommandPrefix("apo");
    }
}
