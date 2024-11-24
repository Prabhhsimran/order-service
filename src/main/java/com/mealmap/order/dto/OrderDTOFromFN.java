package com.mealmap.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTOFromFN {

    private List<FoodItemDTO> foodItemList;
    private Integer userId;
    private Restaurant restaurant;
}
