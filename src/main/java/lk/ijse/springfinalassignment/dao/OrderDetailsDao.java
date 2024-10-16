package lk.ijse.springfinalassignment.dao;



import lk.ijse.springfinalassignment.entity.impl.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsDao extends JpaRepository<OrderDetailsEntity,String> {
}
