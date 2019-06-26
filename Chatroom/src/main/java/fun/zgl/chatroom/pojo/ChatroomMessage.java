package fun.zgl.chatroom.pojo;

/**
 * @ Description: 定义一个消息载体，用来每次返回消息
 * @ Author: zwl
 * @ Create: 2019/6/26
 * @ Since: 1.0.0
 */
public class ChatroomMessage {
    public ChatroomMessage(){}
    public ChatroomMessage(int srcId, int dstId, String msg) {
        this.msg = msg;
        this.srcId = srcId;
        this.dstId = dstId;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getSrcId() {
        return srcId;
    }

    public void setSrcId(int srcId) {
        this.srcId = srcId;
    }

    public int getDstId() {
        return dstId;
    }

    public void setDstId(int dstId) {
        this.dstId = dstId;
    }

    String msg;
    int srcId;
    int dstId;

}
