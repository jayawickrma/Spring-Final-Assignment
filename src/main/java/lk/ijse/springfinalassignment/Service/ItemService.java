package lk.ijse.springfinalassignment.Service;

import lk.ijse.springfinalassignment.DTO.impl.ItemDTO;

import java.util.List;

public interface ItemService {
    ItemDTO daveItem(ItemDTO itemDTO);
    List<ItemDTO> getAllItems();
    ItemDTO getItem(String itemCode);
    void deleteItem(String itemCode);
    void updateItem(ItemDTO itemDTO,String itemCode);
}
