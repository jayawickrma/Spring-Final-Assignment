package lk.ijse.springfinalassignment.DAO;

import lk.ijse.springfinalassignment.Entity.impl.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends JpaRepository<CustomerEntity,String> {
}
