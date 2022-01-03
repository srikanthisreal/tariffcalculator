package com.varivox.tariffcalculator.model;

public enum Tariff {
	BASIC_ELECTRICITY_TARIFF(5, 12, 0.22, 0), PACKAGED_TARIFF(800, 1, 0.30, 4000);

	private final double baseRate; // in Euro
	private final double frequency; // in meters
	private final double perUnitCharge; // per kwh
	private final int availableUseage; // per kwh

	Tariff(double baseRate, double frequency, double perUnitCharge, int availableUseage) {
		this.baseRate = baseRate;
		this.frequency = frequency;
		this.perUnitCharge = perUnitCharge;
		this.availableUseage = availableUseage;
	}

	public double getFrequency(int desiredConsumption) {
		double value = baseRate;
		int chargableUnits = desiredConsumption - availableUseage;
		if (chargableUnits > 0) {
			value = (baseRate * frequency) + (chargableUnits * perUnitCharge);
		}
		return value;
	}

}
