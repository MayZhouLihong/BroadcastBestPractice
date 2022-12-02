package com.may.wechat;

/**
 * DES:
 * <p>
 * Date: 2022/11/23  21:28
 *
 * @author Jason
 */
public class MsgHistory {
    public final static int MSG_TYPE_REC=0;
    public final static int MSG_TYPE_SEND=1;
    private int type;
    private String msg;

    public MsgHistory(int type, String msg) {
        this.type = type;
        this.msg = msg;
    }

    public int getType() {
        return type;
    }

    public String getMsg() {
        return msg;
    }
}
