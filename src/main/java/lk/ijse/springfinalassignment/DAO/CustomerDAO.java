package lk.ijse.springfinalassignment.DAO;

import lk.ijse.springfinalassignment.Entity.impl.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<CustomerEntity,String> {
}
