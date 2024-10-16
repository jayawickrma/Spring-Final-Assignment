package lk.ijse.springfinalassignment.entity.impl;

import jakarta.persistence.*;

import lk.ijse.springfinalassignment.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "item")
public class ItemEntity implements SuperEntity {
    @Id
    private String itemCode;
    private String itemName;
    private int qtyOnHand;
    private double unitPrice;
    @OneToMany(mappedBy = "item",cascade = CascadeType.ALL)
    private List<OrderDetailsEntity> orderList;

}
