package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class customerAddRequest {

    //private int customerId;
    protected String name;
    protected int mobileNumber;
    protected String email;
    protected String password;

}
