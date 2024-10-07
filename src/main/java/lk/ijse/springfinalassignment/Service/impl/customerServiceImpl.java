package lk.ijse.springfinalassignment.Service.impl;

import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lk.ijse.springfinalassignment.DAO.CustomerDAO;
import lk.ijse.springfinalassignment.DTO.impl.CustomerDTO;
import lk.ijse.springfinalassignment.Entity.impl.CustomerEntity;
import lk.ijse.springfinalassignment.Exeptions.DataPersistExeption;
import lk.ijse.springfinalassignment.Service.CustomerService;
import lk.ijse.springfinalassignment.Utill.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class customerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private Mapping mapping;
    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        CustomerEntity saveCustomer = customerDAO.save(mapping.toCustomerEntity(customerDTO));
        if (saveCustomer==null){
                throw new DataPersistExeption("something went wrong");
        }
        return mapping.toCustomerDto(saveCustomer);
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
