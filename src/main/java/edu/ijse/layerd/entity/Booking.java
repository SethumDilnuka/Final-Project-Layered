package edu.ijse.layerd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Booking {
    private String id;
    private String c_id;
    private String nic;
    private String date;
    private String table_name;
}
