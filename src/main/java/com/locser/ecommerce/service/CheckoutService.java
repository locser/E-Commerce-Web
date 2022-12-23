package com.locser.ecommerce.service;

import com.locser.ecommerce.dto.Purchase;
import com.locser.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
