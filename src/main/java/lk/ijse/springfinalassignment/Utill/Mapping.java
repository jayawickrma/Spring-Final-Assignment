package lk.ijse.springfinalassignment.Utill;

import lk.ijse.springfinalassignment.DTO.impl.CustomerDTO;
import lk.ijse.springfinalassignment.DTO.impl.ItemDTO;
import lk.ijse.springfinalassignment.Entity.impl.CustomerEntity;
import lk.ijse.springfinalassignment.Entity.impl.ItemEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

        public CustomerEntity toCustomerEntity(CustomerDTO customerDTO){return modelMapper.map(customerDTO,CustomerEntity.class);}
        public CustomerDTO toCustomerDto(CustomerEntity customer){return modelMapper.map(customer,CustomerDTO.class);}
        public List<CustomerDTO> allCustomers(List<CustomerEntity>customerEntities){
            return modelMapper.map(customerEntities,new TypeToken<List<CustomerDTO>>(){}.getType());
        }


        public ItemEntity toItemEntity(ItemDTO itemDTO){return modelMapper.map(itemDTO,ItemEntity.class);}
        public ItemDTO toItemDto(ItemEntity itemEntity){return modelMapper.map(itemEntity,ItemDTO.class);}
        public List<ItemDTO> allItems(List<ItemEntity>itemEntities){
            return modelMapper.map(itemEntities,new TypeToken<List<ItemDTO>>(){}.getType());
        }
}

