package lk.ijse.springfinalassignment.DTO.impl;

import lk.ijse.springfinalassignment.DTO.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDTO implements SuperDTO {
    public String itemCode;
    public String itemDesc;
    public String itemQTY;
    public String itemPrice;
}
