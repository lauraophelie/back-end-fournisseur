package com.systeme.fournisseur.api;

public class ListAPIResponse extends APIResponse {
    public ListAPIResponse(String error, Object data) {
        super(error, data);
    }
    public ListAPIResponse(){}

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
