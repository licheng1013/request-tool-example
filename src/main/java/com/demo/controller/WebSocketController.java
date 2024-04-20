package com.demo.controller;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;

/**
 * 连接
 * ws://localhost:8080/websocket
 *
 * @since 2024/4/21
 */
@Component
@ServerEndpoint("/websocket")
public class WebSocketController {


    @OnOpen
    public void onOpen(Session session) {
        //连接建立
        System.out.println("连接建立: " + session.getId());
    }

    @OnClose
    public void onClose(Session session, CloseReason reason) {
        //连接关闭
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        //接收文本信息
        System.out.println("收到: " + message);
        session.getAsyncRemote().sendText("收到: " + message);
    }

    @OnError
    public void onError(Session session, Throwable e) {
        //异常处理
    }
}

