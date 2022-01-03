package com.varivox.tariffcalculator.controller;

import java.util.List;

import javax.xml.bind.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.varivox.tariffcalculator.dto.TariffDTO;
import com.varivox.tariffcalculator.service.TariffCalculatorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * TariffCalculatorController.
 * 
 * @author Srikanth
 *
 */
@RestController
@RequestMapping(value = "/api/v1/tariff")
@Api(value = "TariffCalculator")
public class TariffCalculatorController {

	// All possible logger advice to handled with Spring AOP
	private static final Logger logger = LoggerFactory.getLogger(TariffCalculatorController.class);

	@Autowired
	private TariffCalculatorService tariffCalculatorService;

	/**
	 * tariffComparision.
	 * 
	 * @param consumption
	 * @return
	 * @throws ValidationException
	 */
	@ApiOperation(value = "Compare Products based on Desired Consumption")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Processed successfully", response = List.class),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/{consumption}/compare", produces = "application/json; charset=UTF-8")
	public ResponseEntity<List<TariffDTO>> tariffComparision(@PathVariable Integer consumption)
			throws ValidationException {
		logger.info("ENTRY : tariffComparision - Desired Consumption {}", consumption);
		if (consumption <= 0) {
			logger.debug("EXIT : tariffComparision - Bad Request {}", HttpStatus.BAD_REQUEST);
			throw new ValidationException("Provide valid consumption value");
		}
		List<TariffDTO> tariffs = tariffCalculatorService.tariffComparision(consumption);
		if (tariffs.isEmpty()) {
			logger.debug("EXIT : tariffComparision - No Content {}", HttpStatus.NO_CONTENT);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		logger.info("EXIT : tariffComparision - Processed successfully {}", tariffs);
		return ResponseEntity.ok(tariffs);

	}

}
