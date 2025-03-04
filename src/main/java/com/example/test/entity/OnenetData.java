package com.example.test.entity;

public class OnenetData {
    private OldOnenetMsg msg;
    private String msg_signature;
    private String nonce;

    public OnenetData(OldOnenetMsg msg, String msg_signature, String nonce) {
        this.msg = msg;
        this.msg_signature = msg_signature;
        this.nonce = nonce;
    }


    public OldOnenetMsg getMsg() {
        return msg;
    }

    public void setMsg(OldOnenetMsg msg) {
        this.msg = msg;
    }

    public String getMsg_signature() {
        return msg_signature;
    }

    public void setMsg_signature(String msg_signature) {
        this.msg_signature = msg_signature;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    @Override
    public String toString() {
        return "OnenetData{" +
                "msg=" + msg +
                ", msg_signature='" + msg_signature + '\'' +
                ", nonce='" + nonce + '\'' +
                '}';
    }
}
