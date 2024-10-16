package lk.ijse.springfinalassignment.dao;

import lk.ijse.springfinalassignment.entity.impl.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<CustomerEntity,String> {
}
