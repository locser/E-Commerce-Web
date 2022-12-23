package com.locser.ecommerce.service;

import com.locser.ecommerce.dao.CustomerRepository;
import com.locser.ecommerce.dto.Purchase;
import com.locser.ecommerce.dto.PurchaseResponse;
import com.locser.ecommerce.entity.Address;
import com.locser.ecommerce.entity.Customer;
import com.locser.ecommerce.entity.Order;
import com.locser.ecommerce.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;
    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

//        placeOrder = dat hang

        //retrieve the order info form dto
        Order order= purchase.getOrder();

        //generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        //populate order with orderItems
        Set<OrderItem> orderItems= purchase.getOrderItems();
        orderItems.forEach(order::add);
        /*
                orderItems.forEach(item -> order.add(item));
                populate order with billingAddress and shippingAddress
        */

        order.setShippingAddress(purchase.getShippingAddress());
        order.setBillingAddress(purchase.getBillingAddress());

        //populate customer with order
        Customer customer= purchase.getCustomer();
        customer.add(order);

        //save to the database
        customerRepository.save(customer);

        //return a respone
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        //generate a random UUID number (UUID version-4)
        //

        return UUID.randomUUID().toString();
    }
}
