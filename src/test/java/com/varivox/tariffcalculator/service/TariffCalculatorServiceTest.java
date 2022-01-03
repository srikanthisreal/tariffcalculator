package com.varivox.tariffcalculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.varivox.tariffcalculator.dto.TariffDTO;
import com.varivox.tariffcalculator.model.Tariff;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TariffCalculatorServiceTest {

	@Autowired
	TariffCalculatorService tariffCalculatorService;

	@Test
	void testTariffComparision3500() {

		List<TariffDTO> tariffComparision = tariffCalculatorService.tariffComparision(3500);
		assertTrue(!tariffComparision.isEmpty());
		System.out.println("-------------------------" + tariffComparision);
		assertEquals(Tariff.PACKAGED_TARIFF.toString(), tariffComparision.get(0).getName());
		assertEquals(800d, tariffComparision.get(0).getConsumptionCost());
		assertEquals(Tariff.BASIC_ELECTRICITY_TARIFF.toString(), tariffComparision.get(1).getName());
		assertEquals(830d, tariffComparision.get(1).getConsumptionCost());

	}

	@Test
	void testTariffComparision4000() {

		List<TariffDTO> tariffComparision = tariffCalculatorService.tariffComparision(4000);
		assertTrue(!tariffComparision.isEmpty());
		System.out.println("-------------------------" + tariffComparision);
		assertEquals(Tariff.PACKAGED_TARIFF.toString(), tariffComparision.get(0).getName());
		assertEquals(800d, tariffComparision.get(0).getConsumptionCost());
		assertEquals(Tariff.BASIC_ELECTRICITY_TARIFF.toString(), tariffComparision.get(1).getName());
		assertEquals(940d, tariffComparision.get(1).getConsumptionCost());

	}

	@Test
	void testTariffComparision6000() {

		List<TariffDTO> tariffComparision = tariffCalculatorService.tariffComparision(6000);
		assertTrue(!tariffComparision.isEmpty());
		System.out.println("-------------------------" + tariffComparision);
		assertEquals(Tariff.BASIC_ELECTRICITY_TARIFF.toString(), tariffComparision.get(0).getName());
		assertEquals(1380d, tariffComparision.get(0).getConsumptionCost());
		assertEquals(Tariff.PACKAGED_TARIFF.toString(), tariffComparision.get(1).getName());
		assertEquals(1400d, tariffComparision.get(1).getConsumptionCost());

	}

	@ParameterizedTest
	@ValueSource(ints = { 3500, 4000, 6000, 100, 100000, Integer.MAX_VALUE })
	void testLoadTestTariffComparision(Integer consumption) {
		List<TariffDTO> tariffComparision = tariffCalculatorService.tariffComparision(consumption);
		assertTrue(!tariffComparision.isEmpty());

	}

}
