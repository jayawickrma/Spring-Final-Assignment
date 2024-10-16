package lk.ijse.springfinalassignment.dto.impl;


import lk.ijse.springfinalassignment.dto.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements CustomerStatus {
    private String customerId;
    private String firstName;
    private String city;
    private String email;
    private String address;

}
