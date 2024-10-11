package lk.ijse.springfinalassignment.Controller;

import lk.ijse.springfinalassignment.DAO.CustomerDAO;
import lk.ijse.springfinalassignment.DTO.impl.CustomerDTO;
import lk.ijse.springfinalassignment.Entity.impl.CustomerEntity;
import lk.ijse.springfinalassignment.Exeptions.DataPersistExeption;
import lk.ijse.springfinalassignment.Service.CustomerService;
import lk.ijse.springfinalassignment.Utill.AppUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v3/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;


@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCustomer(CustomerDTO customerDTO) {

        try {
            customerDTO.setCustomerId(AppUtill.customerId());

            customerService.saveCustomer(customerDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistExeption e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/{cid}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("cid")String customerId){
            customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

