package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InventoryModifyRequest {
    private String name;
    private String category;
    private double price;
    private int stock;
    private String imageUrl;
}
