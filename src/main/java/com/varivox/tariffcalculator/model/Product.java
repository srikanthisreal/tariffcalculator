package com.varivox.tariffcalculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	private Long id;
	private String tariff;
	private String cycle;
	private double basePrice;
	private double perUnitCharge; 

}
