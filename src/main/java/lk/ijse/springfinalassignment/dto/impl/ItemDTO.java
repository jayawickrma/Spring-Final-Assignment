package lk.ijse.springfinalassignment.dto.impl;


import lk.ijse.springfinalassignment.dto.ItemStatus;
import lk.ijse.springfinalassignment.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO implements SuperDTO, ItemStatus {
    private String itemCode;
    private String itemName;
    private int qtyOnHand;
    private double unitPrice;
}
