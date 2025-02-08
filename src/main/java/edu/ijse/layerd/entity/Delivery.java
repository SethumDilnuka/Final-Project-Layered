package edu.ijse.layerd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Delivery {

    private String id;
    private String order_id;
    private String emp_id;
    private String status;
    private String location;
    private String date;
}
