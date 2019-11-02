package com.lsolier.udacity.pricingservice.domain.price;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents the price of a given vehicle, including currency.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Price {

    private String currency;
    private BigDecimal price;
    private Long vehicleId;

}
