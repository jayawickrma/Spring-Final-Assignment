package lk.ijse.springfinalassignment.service;


import lk.ijse.springfinalassignment.dto.OrderStatus;
import lk.ijse.springfinalassignment.dto.impl.OrderDTO;

import java.util.List;

public interface OrderService {
    void saveOrder(OrderDTO orderDTO);
    void updateOrder(String orderId,OrderDTO orderDTO);
    void deleteOrder(String orderId);
    OrderStatus getOrder(String orderId);
    List<OrderDTO>getAllOrder();
}
