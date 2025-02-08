package edu.ijse.layerd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Supplier {
    public String id;
    public String company_name;
    public String location;
    public String mobile;
    public String email;
}
