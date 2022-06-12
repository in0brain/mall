package pers.lnz.entity.vo;

/**
 * 消息模型对象
 * flag是是否复合跳转的条件
 * msg是传输的信息
 * obj一般是User对象
 */
public class MessageModel {
    private String kind;
    private boolean flag = true;
    private String msg = "";
    private Object obj;

    public MessageModel() {
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "MessageModel{" +
                "flag=" + flag +
                ", msg='" + msg+"'}";
    }
}
