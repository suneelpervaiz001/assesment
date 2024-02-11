package com.tech.assesment.dto;

import com.tech.assesment.entity.RetailUser;
import lombok.Data;

@Data
public class Bill {
   private double totalAmount;
   private RetailUser retailUser;
   private boolean isGrocery;
}
