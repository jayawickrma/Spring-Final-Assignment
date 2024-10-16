package lk.ijse.springfinalassignment.controller;


import lk.ijse.springfinalassignment.customeStatusCode.SelectedUserAndNoteErroStatus;

import lk.ijse.springfinalassignment.dto.CustomerStatus;
import lk.ijse.springfinalassignment.dto.impl.CustomerDTO;
import lk.ijse.springfinalassignment.exception.CustomerNotFoundException;
import lk.ijse.springfinalassignment.exception.DataPersistException;
import lk.ijse.springfinalassignment.service.CustomerService;
import lk.ijse.springfinalassignment.util.AppUtil;
import lk.ijse.springfinalassignment.util.RegexProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    static Logger logger= LoggerFactory.getLogger(CustomerController.class);
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>saveCustomer(@RequestBody CustomerDTO customerDTO){
       // customerDTO.setCustomerId(customerDTO.getCustomerId());
        String s = AppUtil.generateCustomerId();
        customerDTO.setCustomerId(s);
        try {
            customerService.saveCustomer(customerDTO);
            logger.info("Customer saved Successfully  "+customerDTO.getCustomerId());
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            logger.warn("Something went wrong> With Customer Code : "+customerDTO.getCustomerId());
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Not Responding... ",customerDTO.getCustomerId());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping(value = "/{customerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerStatus getSelectCustomer(@PathVariable("customerId") String customerId){
        if (!RegexProcess.customerIdMatcher(customerId)){
            logger.warn("Invalid Customer ID ",customerId);
            return new SelectedUserAndNoteErroStatus(1,"Customer Id is not valid");
        }
        return customerService.getCustomer(customerId);
    }
    @DeleteMapping(value = "/{customerId}")
    public ResponseEntity<Void>deleteCustomer(@PathVariable("customerId")String customerId){
        try {
            if (!RegexProcess.customerIdMatcher(customerId)){
                logger.warn("Invalid Customer Id ",customerId);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            customerService.deleteCustomer(customerId);
            logger.info("Customer Deleted Successfully With Customer Id ",customerId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (CustomerNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Internal server error with code "+customerId);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PutMapping(value = "/{customerId}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> updateCustomer(@PathVariable("customerId") String customerId,@RequestBody CustomerDTO customerDTO){
        try {
            customerService.updateCustomer(customerId,customerDTO);
            logger.info("Customer Update Successfully !!! ");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            logger.warn("Fail to Update Bad Request with code ",customerId);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.error("Internal server error ");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}
