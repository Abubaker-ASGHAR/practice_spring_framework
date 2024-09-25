package org.example.service;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    public double calculateDiscount(double price) {
        return price * 0.10;
    }


}
