package com.example.aenrishi;

import java.util.List;

public class ResponseWrapper {

    private boolean success;
    private List<Qcm> users;

    // Getters
    public boolean isSuccess() {
        return success;
    }

    public List<Qcm> getUsers() {
        return users;
    }

    // Setters
    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setUsers(List<Qcm> users) {
        this.users = users;
    }
}

