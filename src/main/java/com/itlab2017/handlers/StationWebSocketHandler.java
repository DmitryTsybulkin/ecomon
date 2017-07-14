package com.itlab2017.handlers;

import com.itlab2017.factories.WebSocketSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Created by Lenovo on 10.07.2017.
 */
@Component
public class StationWebSocketHandler extends TextWebSocketHandler {

    @Autowired
    private WebSocketSessionFactory webSocketSessionFactory;

    @Override
    public void handleTransportError(WebSocketSession session, Throwable throwable) throws Exception {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        webSocketSessionFactory.RemoveSession(session);

    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        webSocketSessionFactory.AddSession(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage jsonTextMessage) throws Exception {
        TextMessage msg = new TextMessage("hello");
        session.sendMessage(msg);
    }
}
