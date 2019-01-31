package com.zhaoshg.test.event;

public class Event {
    private final String userName;     //玩家昵称
    private final EventType evtType;    //事件类型

    public Event(String userName, EventType evtType) {
        this.userName = userName;
        this.evtType = evtType;
    }

    public String getUserName() {
        return userName;
    }

    public EventType getEvtType() {
        return evtType;
    }

}
