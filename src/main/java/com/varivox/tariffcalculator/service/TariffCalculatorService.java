package com.varivox.tariffcalculator.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.varivox.tariffcalculator.dto.TariffDTO;
import com.varivox.tariffcalculator.model.Tariff;

/**
 * TariffCalculatorService.
 * 
 * @author Srikanth
 *
 */
@Service
public class TariffCalculatorService {

	private static final Logger logger = LoggerFactory.getLogger(TariffCalculatorService.class);

	/**
	 * tariffComparision
	 * 
	 * @param desiredConsumption
	 * @return
	 */
	public List<TariffDTO> tariffComparision(Integer desiredConsumption) {
		logger.debug("ENTRY : tariffComparision - Desired Consumption {}", desiredConsumption);
		List<TariffDTO> tariffs = new ArrayList<>();
		for (Tariff p : Tariff.values()) {
			TariffDTO tariffDTO = new TariffDTO();
			tariffDTO.setId(Long.valueOf(tariffs.size() + 1));
			tariffDTO.setName(p.name());
			tariffDTO.setConsumptionCost(p.getFrequency(desiredConsumption));
			logger.info("INFO : tariffComparision desiredConsumption {} - Annual Cost {}", tariffs);
			tariffs.add(tariffDTO);
		}
		Collections.sort(tariffs);
		logger.debug("EXIT : tariffComparision - list of Iteams {}", tariffs);
		return tariffs;
	}

}
