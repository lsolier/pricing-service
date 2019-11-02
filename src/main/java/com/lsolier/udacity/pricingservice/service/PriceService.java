package com.lsolier.udacity.pricingservice.service;

import static com.lsolier.udacity.pricingservice.util.PriceGenerator.PRICES;

import com.lsolier.udacity.pricingservice.domain.price.Price;

import org.springframework.stereotype.Service;

/**
 * Implements the pricing service to get prices for each vehicle.
 */
@Service
public class PriceService {

  /**
   * If a valid vehicle ID, gets the price of the vehicle from the stored array.
   * @param vehicleId ID number of the vehicle the price is requested for.
   * @return price of the requested vehicle
   * @throws PriceException vehicleID was not found
   */
  public Price getPrice(Long vehicleId) throws PriceException {
    if (!PRICES.containsKey(vehicleId)) {
      throw new PriceException("Cannot find price for Vehicle " + vehicleId);
    }
    return PRICES.get(vehicleId);
  }
}
