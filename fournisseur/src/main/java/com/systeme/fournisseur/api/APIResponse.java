package com.systeme.fournisseur.api;

public class APIResponse {
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public APIResponse(String error, Object data) {
        setError(error);
        setData(data);
    }

    public APIResponse() {
    }
}
