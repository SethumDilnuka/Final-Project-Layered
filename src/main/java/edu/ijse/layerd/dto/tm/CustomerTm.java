package edu.ijse.layerd.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class CustomerTm {
    private String id;
    private String name;
    private String address;
    private String mobile;
    private String email;
    private String dob;
}
