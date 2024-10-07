package lk.ijse.springfinalassignment.Controller;

import lk.ijse.springfinalassignment.DTO.impl.ItemDTO;
import lk.ijse.springfinalassignment.Exeptions.DataPersistExeption;
import lk.ijse.springfinalassignment.Service.ItemService;
import lk.ijse.springfinalassignment.Utill.AppUtill;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v3/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>saveItem(
            @RequestPart("itemDesc") String itemDesc,
            @RequestPart("itemQty") String itemQTY,
            @RequestPart("itemPrice") String itemPrice
    ){
        try{
            String itemCode = AppUtill.itemCode();

            ItemDTO itemDTO =new ItemDTO();
                itemDTO.setItemCode(itemCode);
                itemDTO.setItemDesc(itemDesc);
                itemDTO.setItemQTY(itemQTY);
                itemDTO.setItemPrice(itemPrice);

                itemService.daveItem(itemDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistExeption e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
