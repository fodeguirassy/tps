package com.furkilic.tpintent;

import java.io.Serializable;

public class MessageHolder implements Serializable{

    private String message;

    public MessageHolder(String message){
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
