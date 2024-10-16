package lk.ijse.springfinalassignment.util;

import lk.ijse.springfinalassignment.dto.impl.CustomerDTO;
import lk.ijse.springfinalassignment.dto.impl.ItemDTO;
import lk.ijse.springfinalassignment.dto.impl.OrderDTO;
import lk.ijse.springfinalassignment.dto.impl.OrderDetailsDTO;
import lk.ijse.springfinalassignment.entity.impl.CustomerEntity;
import lk.ijse.springfinalassignment.entity.impl.ItemEntity;
import lk.ijse.springfinalassignment.entity.impl.OrderDetailsEntity;
import lk.ijse.springfinalassignment.entity.impl.OrderEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    public CustomerEntity tocustomerEntity(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, CustomerEntity.class);
    }
    public CustomerDTO tocustomerDTO(CustomerEntity customerEntity) {
        return modelMapper.map(customerEntity, CustomerDTO.class);
    }
    public List<CustomerDTO> asCustomerDTOList(List<CustomerEntity> customerEntities) {
        return modelMapper.map(customerEntities, new TypeToken<List<CustomerDTO>>() {}.getType());
    }



    public ItemEntity toItemEntity(ItemDTO itemDTO){
        return modelMapper.map(itemDTO, ItemEntity.class);
    }
    public ItemDTO toItemDTO(ItemEntity itemEntity){
        return modelMapper.map(itemEntity, ItemDTO.class);
    }
    public List<ItemDTO>toItemList(List<ItemEntity>itemList){
        return modelMapper.map(itemList,new TypeToken<List<ItemDTO>>(){}.getType());
    }


    public OrderEntity toOrderentity (OrderDTO orderDTO){
        return modelMapper.map(orderDTO, OrderEntity.class);
    }
    public OrderDTO toOrderDTO(OrderEntity orderEntity){
        return modelMapper.map(orderEntity, OrderDTO.class);
    }
    public List<OrderDTO>toOrderList(List<OrderEntity>orderList){
        return modelMapper.map(orderList,new TypeToken<List<OrderDTO>>(){}.getType());
    }

    public List<OrderDetailsEntity> toOrderEntityDetailsList(List<OrderDetailsDTO>orderList){
        return modelMapper.map(orderList,new TypeToken<List<OrderDetailsEntity>>(){}.getType());
    }
    public OrderDetailsEntity toOrderDetailsEntity(OrderDetailsDTO orderDetailsDTO){
        return modelMapper.map(orderDetailsDTO, OrderDetailsEntity.class);
    }

}
