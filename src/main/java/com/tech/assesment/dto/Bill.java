package com.tech.assesment.dto;

import com.tech.assesment.entity.RetailUser;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Data
public class Bill {
   private double totalAmount;
   private RetailUser retailUser;
   private boolean isGrocery;
}
