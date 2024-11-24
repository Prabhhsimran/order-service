package com.mealmap.order.entity;

import com.mealmap.order.dto.FoodItemDTO;
import com.mealmap.order.dto.Restaurant;
import com.mealmap.order.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("order")
public class Order {

    private Integer orderId;
    private List<FoodItemDTO> foodItemList;
    private Restaurant restaurant;
    private UserDTO userDTO;
}
