package com.zhaoshg.test.event;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public enum CommonEventDispatcher implements EventDispatcher {
    INSTANCE;


    private final Map<EventType, Set<EventListener>> observers = new HashMap<>();


    @Override
    public void registerEvent(EventType evtType, EventListener listener) {
        Set<EventListener> listeners = observers.get(evtType);
        if (listeners == null) {
            listeners = new CopyOnWriteArraySet<EventListener>();
            observers.put(evtType, listeners);
        }
        listeners.add(listener);
    }

    @Override
    public void fireEvent(Event event) {
        if (event == null) {
            throw new NullPointerException("event cannot be null");
        }

        EventType evtType = event.getEvtType();
        Set<EventListener> listeners = observers.get(evtType);
        if (listeners != null) {
            for (EventListener listener : listeners) {
                try {
                    listener.handleEvent(event);
                } catch (Exception e) {
                    e.printStackTrace();  //防止其中一个listener报异常而中断其他逻辑
                }
            }
        }

    }
}
