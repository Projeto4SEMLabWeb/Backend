package com.example.demo.Enums;

import lombok.Getter;

@Getter
public enum LoginEnum {
    USER("user");

    private String role;

    LoginEnum(String role) {
        this.role = role;
    }
}
