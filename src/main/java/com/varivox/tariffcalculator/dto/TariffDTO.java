package com.varivox.tariffcalculator.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class TariffDTO implements Comparable<TariffDTO> {

	private Long id;
	private String name;
	private double consumptionCost;

	@Override
	public int compareTo(TariffDTO o) {
		return Double.compare(this.consumptionCost, o.consumptionCost);
	}

}
