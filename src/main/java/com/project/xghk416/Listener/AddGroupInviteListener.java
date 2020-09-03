package com.project.xghk416.Listener;

import cc.moecraft.icq.event.EventHandler;
import cc.moecraft.icq.event.IcqListener;
import cc.moecraft.icq.event.events.request.EventGroupAddRequest;
import cc.moecraft.icq.event.events.request.EventGroupInviteRequest;

public class AddGroupInviteListener extends IcqListener {
    @EventHandler
    public void doEvent(EventGroupInviteRequest event){
        System.out.println(event.getGroupId());
        event.getHttpApi().approveGroupRequest("bot","game");
        event.getBot().getAccountManager().refreshCache();
    }

}
