package lk.ijse.springfinalassignment.Controller;

import lk.ijse.springfinalassignment.DAO.CustomerDAO;
import lk.ijse.springfinalassignment.DTO.impl.CustomerDTO;
import lk.ijse.springfinalassignment.Entity.impl.CustomerEntity;
import lk.ijse.springfinalassignment.Exeptions.DataPersistExeption;
import lk.ijse.springfinalassignment.Service.CustomerService;
import lk.ijse.springfinalassignment.Utill.AppUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v3/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    public ResponseEntity<Void> saveCustomer(
            @RequestPart("customerName") String customerName,
            @RequestPart("customerAddress") String customerAddress,
            @RequestPart("customerContact") String customerContact
    ) {
        try {
            String customerId = AppUtill.customerId();

            CustomerDTO customerDTO = new CustomerDTO();

            customerDTO.setCustomerId(customerId);
            customerDTO.setCustomerName(customerName);
            customerDTO.setCustomerAddress(customerAddress);
            customerDTO.setCustomerContact(customerContact);

            customerService.saveCustomer(customerDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistExeption e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

