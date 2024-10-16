package lk.ijse.springfinalassignment.service;



import lk.ijse.springfinalassignment.dto.ItemStatus;
import lk.ijse.springfinalassignment.dto.impl.ItemDTO;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO itemDTO);
    void updateItem(String itemId,ItemDTO itemDTO);
    void deleteItem(String itemId);
    ItemStatus getItem(String itemId);
    List<ItemDTO>getAllItem();
}
