package com.tech.assesment.service;

import com.tech.assesment.constants.UserType;
import com.tech.assesment.entity.RetailUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemBillService {

    @Autowired
    UserService userService;


    public double calculateDiscountedBill(double totalAmount, RetailUser retailUser,  boolean isGrocery) {



        double discountAmount = 0;
        double furtherDiscount = 0;

        // Apply discount rules
        if (!isGrocery) {
            if (retailUser.getUserType().equals(UserType.EMPLOYEE)) {
                discountAmount += totalAmount * 0.30;
            } else if (retailUser.getUserType().equals(UserType.AFFILIATE)) {
                discountAmount += totalAmount * 0.10;
            } else if (retailUser.getUserType().equals(UserType.CUSTOMER_OVER_TWO_YEARS)) {
                discountAmount += totalAmount * 0.05;
            }

        }
        // Apply $5 discount for every $100
        furtherDiscount += (int) (totalAmount / 100) * 5;
        discountAmount = discountAmount + furtherDiscount;

        return totalAmount - discountAmount;
    }
}
