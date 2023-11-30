package com.systeme.fournisseur.api;

import org.springframework.http.HttpStatus;

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
        setData(data);
        if (data == null) {
            setError(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        } else
            setError(error);
    }

    public APIResponse() {
    }
}
