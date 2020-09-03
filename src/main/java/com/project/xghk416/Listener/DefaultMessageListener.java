package com.project.xghk416.Listener;

import cc.moecraft.icq.event.EventHandler;
import cc.moecraft.icq.event.IcqListener;
import cc.moecraft.icq.event.events.message.EventMessage;

public class DefaultMessageListener extends IcqListener {
    @EventHandler
    public void doEvent(EventMessage message){
//        System.out.println(message.getMessage());
        if (message.getMessage().equals("白金")){
            message.respond("博士，要一起去游乐园吗");
        }else if (message.getMessage().startsWith("arks")){
            message.respond("博士，现在由我担任助理哦（输入'aph'查看帮助）");
        }
    }

}
