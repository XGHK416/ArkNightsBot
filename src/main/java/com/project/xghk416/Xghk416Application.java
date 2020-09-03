package com.project.xghk416;

import com.project.xghk416.command.OpPublicOfferingCommand;
import com.project.xghk416.command.OpResumeCommand;
import com.xghk416.XghkBot;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.project.xghk416.pojo.dao") //扫描的mapper
@SpringBootApplication
public class Xghk416Application {

    public static void main(String[] args) {
//        PicqConfig config = new PicqConfig(8088);
//        PicqBotX bot = new PicqBotX(config);
//        bot.addAccount("小白金","127.0.0.1",31091);
//        bot.getEventManager().registerListeners(new AddGroupListener(),new DefaultMessageListener());
//        bot.enableCommandManager("ap");
//        bot.getCommandManager().registerCommands(new OpResumeCommand(),new OpHelpCommand(),new OpPublicOfferingCommand());
//        bot.startBot();
        XghkBot bot = new XghkBot("127.0.0.1", 8404);
        bot.getCommandManager()
                .addCommand("apo",new OpResumeCommand())
                .addCommand("app",new OpPublicOfferingCommand());
        bot.start();
        SpringApplication.run(Xghk416Application.class, args);
    }

}
