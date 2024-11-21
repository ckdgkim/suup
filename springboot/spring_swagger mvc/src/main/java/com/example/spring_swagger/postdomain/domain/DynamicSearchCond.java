package com.example.spring_swagger.postdomain.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DynamicSearchCond {
    private String userName;
    private Integer likes;

}
