package lk.ijse.springassignment.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.springassignment.customeStatusCode.SelectedUserAndNoteErroStatus;
import lk.ijse.springassignment.dao.ItemDao;
import lk.ijse.springassignment.dto.ItemStatus;
import lk.ijse.springassignment.dto.impl.ItemDTO;
import lk.ijse.springassignment.entity.impl.ItemEntity;
import lk.ijse.springassignment.exception.CustomerNotFoundException;
import lk.ijse.springassignment.exception.DataPersistException;
import lk.ijse.springassignment.service.ItemService;
import lk.ijse.springassignment.util.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private Mapping mapping;
    private static final Logger logger= LoggerFactory.getLogger(ItemServiceImpl.class);
    @Override
    public void saveItem(ItemDTO itemDTO) {
        logger.info("Attempting to save with code ",itemDTO.getItemCode());
        ItemEntity item=itemDao.save(mapping.toItemEntity(itemDTO));
        if (item==null){
            logger.error("Fail To Save Item With Code ",itemDTO.getItemCode());
            throw new DataPersistException("Item not saved");
        }else {
            logger.info("Item with code  has been saved successfully!!!!!!!",itemDTO.getItemCode());
        }
    }

    @Override
    public void updateItem(String itemId, ItemDTO itemDTO) {
        logger.info("Attempting to update with code ",itemId);
        Optional<ItemEntity> tmpItem=itemDao.findById(itemId);
        if (tmpItem.isPresent()){
            tmpItem.get().setItemName(itemDTO.getItemName());
            tmpItem.get().setQtyOnHand(itemDTO.getQtyOnHand());
            tmpItem.get().setUnitPrice(itemDTO.getUnitPrice());
            logger.info("Update Successfully with code ",itemId);
        }else {
            logger.warn("Not found for update ! with code ",itemId);
        }
    }

    @Override
    public void deleteItem(String itemId) {
        Optional<ItemEntity>tmpItem=itemDao.findById(itemId);
        if (!tmpItem.isPresent()){
            logger.info("Attempting to delete item with code ",itemId);
            throw new CustomerNotFoundException("item code with "+itemId+" NOt Found ");
        }else {
            itemDao.deleteById(itemId);
            logger.info("Delete Successfully with code ",itemId);
        }

    }

    @Override
    public ItemStatus getItem(String itemId) {
        logger.info("Fetching item with code "+itemId);
       if (itemDao.existsById(itemId)){
           return mapping.toItemDTO(itemDao.getReferenceById(itemId));
       }else {
           logger.warn("Not Found with code "+itemId);
           return new SelectedUserAndNoteErroStatus(2,"Selected item not found");
       }
    }

    @Override
    public List<ItemDTO> getAllItem() {
        logger.info("Fetching All items ");
     List<ItemDTO> items = mapping.toItemList(itemDao.findAll());
     if (items.isEmpty()){
         logger.info("No item is Empty");
     }else {
         logger.info("Number of items found ",items.size());
     }
     return items;
    }
}
