package com.zhaoshg.test.event;

public interface EventDispatcher {


    /**
     * 注册事件
     */
    public void registerEvent(EventType evtType, EventListener listener);

    /**
     * 派发事件
     */
    public void fireEvent(Event event);

}
