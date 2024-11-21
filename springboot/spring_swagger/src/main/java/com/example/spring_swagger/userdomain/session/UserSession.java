package com.example.spring_swagger.userdomain.session;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserSession {
    private String userId;
    private String userName;
}
