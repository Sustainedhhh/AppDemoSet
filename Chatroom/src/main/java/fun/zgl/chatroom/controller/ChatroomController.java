package fun.zgl.chatroom.controller;

import fun.zgl.chatroom.pojo.ChatroomMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description chatroom的Controller
 * @author zwl
 * @date 2019/6/26
 * @since 1.0.0
 */
@RestController
//@RequestMapping(value = "chatroom")
public class ChatroomController {

    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public ChatroomController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @PostMapping(value = "/sendMessage")
    public void sendQueueMesaage(@RequestParam(value = "srcid", required = true) int srcId,
                                 @RequestParam(value = "dstid", required = true) int dstId,
                                 @RequestParam(value = "msg", required = true) String msg) {

        // 消息发送之后，需要告知双方(一方面是消息内容，一方面是消息是否发送成功)


        // 封装本次的信息
        ChatroomMessage message = new ChatroomMessage(srcId, dstId, msg);

        // 告知src本次请求要传递的消息
        simpMessagingTemplate.convertAndSendToUser(String.valueOf(message.getSrcId()), "/queue/getResponse", message);

        // 告知dst本次请求要传递的消息
        simpMessagingTemplate.convertAndSendToUser(String.valueOf(message.getDstId()), "/queue/getResponse", message);
    }

}
