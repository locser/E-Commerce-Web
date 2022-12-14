package com.locser.ecommerce.controller;

import com.locser.ecommerce.dto.Purchase;
import com.locser.ecommerce.dto.PurchaseResponse;
import com.locser.ecommerce.service.CheckoutService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService){
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){

        PurchaseResponse  purchaseResponse = checkoutService.placeOrder(purchase);

        return purchaseResponse;
    }

}
