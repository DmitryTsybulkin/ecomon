//package com.itlab2017.factories;
//
//import com.itlab2017.bootstrap.DeviceLoader;
//import org.apache.log4j.Logger;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Lenovo on 10.07.2017.
// */
//@Component
//public class WebSocketSessionFactory {
//    private Logger log =  Logger.getLogger(DeviceLoader.class);
//
//
//    private final List<WebSocketSession> webSocketSessions = new ArrayList<WebSocketSession>();
//
//    public void AddSession (WebSocketSession webSocketSession){
//        webSocketSessions.add(webSocketSession);
//        log.debug("Session added. Count of sessions "+ webSocketSessions.size());
//    }
//    public void RemoveSession (WebSocketSession webSocketSession){
//        webSocketSessions.removeIf(session ->  session.getId() == webSocketSession.getId());
//        log.debug("Session removed. Count of sessions "+ webSocketSessions.size());
//    }
//    @Scheduled(fixedDelay = 1000)
//    private void testMessage(){
//        try {
//
//        for (WebSocketSession session: webSocketSessions) {
//            session.sendMessage(new TextMessage("lol"));
//        }
//        } catch (IOException e){
//
//        }
//    }
//
//}
