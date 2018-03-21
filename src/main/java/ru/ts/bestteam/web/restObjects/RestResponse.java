package ru.ts.bestteam.web.restObjects;

public class RestResponse {
    private String message;
    private String response;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "RestResponse{" +
                "message='" + message + '\'' +
                ", response='" + response + '\'' +
                '}';
    }
}
