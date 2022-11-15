package com.example.demo.dto;

import com.example.demo.model.Cart_items;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class cartItemAddRequest {
    private int customerId;
    private Cart_items cartItem;
}
