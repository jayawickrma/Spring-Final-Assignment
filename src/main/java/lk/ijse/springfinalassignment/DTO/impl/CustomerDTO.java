package lk.ijse.springfinalassignment.DTO.impl;

import jakarta.persistence.Access;
import lk.ijse.springfinalassignment.DTO.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO implements SuperDTO {
    public String customerId;
    public String customerName;
    public String customerAddress;
    public String customerContact;
}
