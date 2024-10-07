package lk.ijse.springfinalassignment.DAO;

import lk.ijse.springfinalassignment.Entity.impl.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDAO extends JpaRepository<ItemEntity,String> {
}
