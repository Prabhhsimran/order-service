package com.mealmap.order.mapper;

import com.mealmap.order.dto.OrderDTO;
import com.mealmap.order.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.Mapping;

@Mapper
public interface OrdereMapper {

    OrdereMapper INSTANCE = Mappers.getMapper(OrdereMapper.class);

    OrderDTO mapOrderToOrderDTO(Order order);
    Order mapOrderDTOToOrder(OrderDTO orderDTO);

}
