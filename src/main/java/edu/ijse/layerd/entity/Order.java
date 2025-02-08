package edu.ijse.layerd.entity;

import edu.ijse.layerd.dto.tm.CartTm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Order {
    private String id;
    private String c_id;
    private LocalDate date;
    private Double payment;
    private List<CartTm> tmList = new ArrayList<>();
}
