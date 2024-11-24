package com.mealmap.order.controller;

import com.mealmap.order.dto.OrderDTO;
import com.mealmap.order.dto.OrderDTOFromFN;
import com.mealmap.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromFN orderDTOFromFN){
        OrderDTO addedOrder = orderService.saveOrder(orderDTOFromFN);
        return new ResponseEntity<>(addedOrder, HttpStatus.CREATED);
    }
}
