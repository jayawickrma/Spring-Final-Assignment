package lk.ijse.springfinalassignment.Service.impl;

import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lk.ijse.springfinalassignment.DTO.impl.CustomerDTO;
import lk.ijse.springfinalassignment.Service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class customerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return null;
    }

    @Override
    public CustomerDTO getCustomer(String customerId) {
        return null;
    }

    @Override
    public void deleteCustomer(String customerId) {

    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO, String customerId) {

    }
}
