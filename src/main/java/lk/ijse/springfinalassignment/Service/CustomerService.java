package lk.ijse.springfinalassignment.Service;

import lk.ijse.springfinalassignment.DTO.impl.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomer(String customerId);
    void deleteCustomer(String customerId);
    void updateCustomer(CustomerDTO customerDTO,String customerId);
}
