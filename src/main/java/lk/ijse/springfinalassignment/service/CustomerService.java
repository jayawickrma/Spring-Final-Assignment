package lk.ijse.springfinalassignment.service;



import lk.ijse.springfinalassignment.dto.CustomerStatus;
import lk.ijse.springfinalassignment.dto.impl.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);
    List<CustomerDTO>getAllCustomers();
    CustomerStatus getCustomer(String customerId);
    void deleteCustomer(String customerId);
    void updateCustomer(String customerId,CustomerDTO customerDTO);
}
