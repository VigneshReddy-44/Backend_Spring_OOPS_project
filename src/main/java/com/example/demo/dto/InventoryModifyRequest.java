package com.example.demo.dto;

import com.example.demo.model.item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InventoryModifyRequest {
    item i1;
}
