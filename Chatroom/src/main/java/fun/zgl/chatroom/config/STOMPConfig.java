package fun.zgl.chatroom.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @description 启用STOMP的配置类
 * @author zwl
 * @date 2019/6/26
 * @since 1.0.0
 */
@Configuration
@EnableWebSocketMessageBroker
public class STOMPConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 注册一个STOMP端点，并使用了SockJs协议
        // fixme 这里的跨域配置是否可以由单独的跨域配置替代 回头要试试
        registry.addEndpoint("/chatroom").setAllowedOrigins("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 为点对点需求配置一个 /user 消息代理
        // 为广播式需求配置一个 /topic 消息代理
        registry.enableSimpleBroker("/topic","/user");

        // 设置订阅前缀，使用UserDestinationPrefix这个前缀的地址会被特殊处理
        registry.setUserDestinationPrefix("/user");
    }
}
