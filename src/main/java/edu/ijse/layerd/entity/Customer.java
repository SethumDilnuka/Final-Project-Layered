package edu.ijse.layerd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

    private String id;
    private String name;
    private String address;
    private String mobile;
    private String email;
    private String dob;
}
