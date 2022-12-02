package com.may.wechat;

/**
 * DES:
 * <p>
 * Date: 2022/11/22  20:57
 *
 * @author Jason
 */
public class MsgBean {
    private int iconRes;
    private String nickName;
    private String msgDetail;
    private String time;

    public MsgBean(int iconRes, String nickName, String msgDetail, String time) {
        this.iconRes = iconRes;
        this.nickName = nickName;
        this.msgDetail = msgDetail;
        this.time = time;
    }

    public int getIconRes() {
        return iconRes;
    }

    public String getNickName() {
        return nickName;
    }

    public String getMsgDetail() {
        return msgDetail;
    }

    public String getTime() {
        return time;
    }
}
