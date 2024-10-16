package lk.ijse.springfinalassignment.service.impl;

import jakarta.transaction.Transactional;

import lk.ijse.springfinalassignment.customeStatusCode.SelectedUserAndNoteErroStatus;
import lk.ijse.springfinalassignment.dao.CustomerDao;
import lk.ijse.springfinalassignment.dto.CustomerStatus;
import lk.ijse.springfinalassignment.dto.impl.CustomerDTO;
import lk.ijse.springfinalassignment.entity.impl.CustomerEntity;
import lk.ijse.springfinalassignment.exception.CustomerNotFoundException;
import lk.ijse.springfinalassignment.exception.DataPersistException;
import lk.ijse.springfinalassignment.service.CustomerService;
import lk.ijse.springfinalassignment.util.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private Mapping mapping;
    static Logger logger=LoggerFactory.getLogger(CustomerServiceIMPL.class);
    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        logger.info("Attempting to save customer With Id "+customerDTO.getCustomerId());
        CustomerEntity saveCustomer= customerDao.save(mapping.tocustomerEntity(customerDTO));
        if (saveCustomer == null) {
            throw new DataPersistException("Customer not saved");
        }else {
            logger.info("Customer Saved Successfully !!!");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        logger.info("Request to get all customers");
      List<CustomerDTO> allCustomers=mapping.asCustomerDTOList(customerDao.findAll());
      if (allCustomers.isEmpty()){
          logger.warn("No Customer Found ");
      }else {
          logger.info("Number of customers found ",allCustomers.size());
      }
      return allCustomers;
    }

    @Override
    public CustomerStatus getCustomer(String customerId) {
        logger.info("Request to get customer");
        if (customerDao.existsById(customerId)){
            logger.info("Customer With Id Found "+customerId);
            return mapping.tocustomerDTO(customerDao.getReferenceById(customerId));
        }else {
            logger.warn("Customer Id Not Found ",customerId);
            return new SelectedUserAndNoteErroStatus(2,"Customer with id "+ customerId + "not found");
        }
    }

    @Override
    public void deleteCustomer(String customerId) {
        logger.info("Request to delete customer "+customerId);
        Optional<CustomerEntity> exitsCustomer = customerDao.findById(customerId);
        logger.error("Customer Id Not Found "+customerId);
        if (!exitsCustomer.isPresent()){
            throw new CustomerNotFoundException("Customer with id "+ customerId + "not found");
        }else {
            customerDao.deleteById(customerId);
            logger.info("Customer Delete Succesfully With id "+customerId);
        }
    }

    @Override
    public void updateCustomer(String customerId, CustomerDTO customerDTO) {
        logger.info("Attempting to update customer with Id "+customerId);
        Optional<CustomerEntity> tmpCustomer = customerDao.findById(customerId);
        if (tmpCustomer.isPresent()){
            tmpCustomer.get().setFirstName(customerDTO.getFirstName());
            tmpCustomer.get().setCity(customerDTO.getCity());
            tmpCustomer.get().setEmail(customerDTO.getEmail());
            tmpCustomer.get().setAddress(customerDTO.getAddress());
            logger.info("Customer Update Successfully !!! with Id "+customerId);
        }else {
            logger.warn("Customer Not Found For Update With Id "+customerId);
        }
    }
}
