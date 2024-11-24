package com.mealmap.order.service;

import com.mealmap.order.dto.OrderDTO;
import com.mealmap.order.dto.OrderDTOFromFN;
import com.mealmap.order.dto.UserDTO;
import com.mealmap.order.entity.Order;
import com.mealmap.order.mapper.OrdereMapper;
import com.mealmap.order.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private SequenceGenerator sequenceGenerator;

    @Autowired
    private RestTemplate restTemplate;

    public OrderDTO saveOrder(OrderDTOFromFN orderDTOFromFN) {
        Integer newOrderId = sequenceGenerator.generateNextOrderId();
        UserDTO userDTO = fetchOrderDetailsFromUserMS(orderDTOFromFN.getUserId());
        Order order = new Order(newOrderId, orderDTOFromFN.getFoodItemList(), orderDTOFromFN.getRestaurant(),userDTO);
        orderRepo.save(order);
        return OrdereMapper.INSTANCE.mapOrderToOrderDTO(order);
    }

    private UserDTO fetchOrderDetailsFromUserMS(Integer userId) {
       return restTemplate.getForObject("http://USERINFORMATION/user/fetchUser/"+userId, UserDTO.class);
    }
}
