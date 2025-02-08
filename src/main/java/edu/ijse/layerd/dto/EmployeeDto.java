package edu.ijse.layerd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDto {
    private String id;
    private String name;
    private String role;
    private String mobile;
    private String email;

}
