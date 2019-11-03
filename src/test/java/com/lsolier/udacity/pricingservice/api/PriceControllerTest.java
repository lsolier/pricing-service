package com.lsolier.udacity.pricingservice.api;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import com.lsolier.udacity.pricingservice.domain.price.Price;
import com.lsolier.udacity.pricingservice.service.PriceService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@WebMvcTest(PriceController.class)
public class PriceControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private PriceService priceService;

  @Test
  public void getPrice() throws Exception {
    Price price = getPriceMock();
    given(priceService.getPrice(any())).willReturn(price);

    mockMvc.perform(
        get("/services/price")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .param("vehicleId", "1")
            .accept(MediaType.APPLICATION_JSON_UTF8))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(content().json("{}"));

    Mockito.verify(priceService, times(1)).getPrice(ArgumentMatchers.isA(Long.class));
  }

  /**
   * Creates an example Price object for use in testing.
   * @return an example Price object
   */
  private Price getPriceMock() {
    Price price = new Price();
    price.setCurrency("USD");
    price.setPrice(BigDecimal.valueOf(15200.36));
    price.setVehicleId(1L);
    return price;
  }

}