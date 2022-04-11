package com.uxunchina.taling.system.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * webSocket
 *
 * @author chenfeng
 * @date 2022/04/11 14:48
 **/
@Component
@Slf4j
@ServerEndpoint("/webSocket/{username}")
public class WebSocket {

    private static int onlineCount = 0;
    //用来存放每个客户端对应的WebSocket对象，适用于同时与多个客户端通信
    public static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<WebSocket>();
    private static Map<String, WebSocket> clients = new ConcurrentHashMap<>();
    private Session session;
    private String username;

    @OnOpen
    public void onOpen(@PathParam("username") String username, Session session) {
        this.username = username;
        this.session = session;
        addOnlineCount();
        webSocketSet.add(this);
        clients.put(username, this);
        log.info("{},已连接,当前在线人数为：{}人", username,getOnlineCount());
    }

    @OnClose
    public void onClose() throws IOException {
        clients.remove(username);
        webSocketSet.remove(this);
        subOnlineCount();
        log.info("{},离开，当前在线人数为：{}",username,getOnlineCount());
    }

    @OnMessage
    public void onMessage(String message) throws IOException {
        sendMessageAll(message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("webSocket通信异常：{}",error.getMessage());
    }

    public void sendMessageTo(String message, String To) throws IOException {

        // session.getBasicRemote().sendText(message);
        //session.getAsyncRemote().sendText(message);
        for (WebSocket item : clients.values()) {
            if (item.username.equals(To))
                item.session.getAsyncRemote().sendText(message);
        }

    }


    public void sendMessageAll(String message) throws IOException {
        for (WebSocket item : clients.values()) {
            item.session.getAsyncRemote().sendText(message);
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocket.onlineCount--;
    }

    public static synchronized Map<String, WebSocket> getClients() {
        return clients;
    }

}
