package com.tech.assesment.controller;

import com.tech.assesment.dto.Bill;
import com.tech.assesment.service.ItemBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
public class BillController {


    private final ItemBillService itemBillService;

    @Autowired
    BillController (ItemBillService itemBillService){
        this.itemBillService = itemBillService;
    }


    @PostMapping("/calculate")
    public double calculateTotalBill(@RequestBody Bill bill) {
        return itemBillService.calculateDiscountedBill(bill.getTotalAmount(),bill.getRetailUser(), bill.isGrocery());
    }

}
