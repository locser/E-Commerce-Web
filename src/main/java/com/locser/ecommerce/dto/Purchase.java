package com.locser.ecommerce.dto;

import com.locser.ecommerce.entity.Address;
import com.locser.ecommerce.entity.Customer;
import com.locser.ecommerce.entity.Order;
import com.locser.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private Customer customer;
    private Address shippingAddress;
    private  Address billingAddress;;
    private Order order;
    private Set<OrderItem> orderItems;

}
