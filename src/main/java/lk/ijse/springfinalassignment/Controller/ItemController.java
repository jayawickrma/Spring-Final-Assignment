package lk.ijse.springfinalassignment.Controller;

import lk.ijse.springfinalassignment.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
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

        }
    }
}
