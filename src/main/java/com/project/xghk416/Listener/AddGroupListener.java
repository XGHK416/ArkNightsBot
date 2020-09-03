package com.project.xghk416.Listener;

import cc.moecraft.icq.event.EventHandler;
import cc.moecraft.icq.event.IcqListener;
import cc.moecraft.icq.event.events.request.EventGroupAddRequest;

public class AddGroupListener extends IcqListener {
    @EventHandler
    public void doEvent(EventGroupAddRequest event){
        System.out.println(event.getGroupId());
        event.getBot().getAccountManager().refreshCache();
    }

}
