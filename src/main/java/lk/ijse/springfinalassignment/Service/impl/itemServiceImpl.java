package lk.ijse.springfinalassignment.Service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.springfinalassignment.DAO.ItemDAO;
import lk.ijse.springfinalassignment.DTO.impl.ItemDTO;
import lk.ijse.springfinalassignment.Entity.impl.ItemEntity;
import lk.ijse.springfinalassignment.Exeptions.DataPersistExeption;
import lk.ijse.springfinalassignment.Service.ItemService;
import lk.ijse.springfinalassignment.Utill.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class itemServiceImpl implements ItemService {
    @Autowired
    private ItemDAO itemDAO;
    @Autowired
    private Mapping mapping;
    @Override
    public ItemDTO daveItem(ItemDTO itemDTO) {
        ItemEntity saveItem =itemDAO.save(mapping.toItemEntity(itemDTO));
            if (saveItem==null){
                throw new DataPersistExeption("something went wrong");
            }
            return mapping.toItemDto(saveItem);
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<ItemEntity> allitems =itemDAO.findAll();
        return mapping.allItems(allitems);
    }

    @Override
    public ItemDTO getItem(String itemCode) {
        return null;
    }

    @Override
    public void deleteItem(String itemCode) {

    }

    @Override
    public void updateItem(ItemDTO itemDTO, String itemCode) {

    }
}
