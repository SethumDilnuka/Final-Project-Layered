package edu.ijse.layerd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDto {
    private String id;
    private String name;
    private String category;
    private String brand;
    private double unitPrice;
    private int qty;
}
