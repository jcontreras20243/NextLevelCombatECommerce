package com.contrerasjose.ecommercemanagement.ecommercemgt;

import com.contrerasjose.ecommercemanagement.ecommercemgt.entity.AvailableMerchandise;
import com.contrerasjose.ecommercemanagement.ecommercemgt.repository.MerchandiseRepository;
import com.contrerasjose.ecommercemanagement.ecommercemgt.service.AvailableMerchandiseService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AvailableMerchandiseServiceTest {

    @Mock
    private MerchandiseRepository merchandiseRepository;

    @InjectMocks
    private AvailableMerchandiseService availableMerchandiseService;

    @ParameterizedTest
    @ValueSource(doubles = {19.99, 0.00, 99.99})
    public void testSaveMerchandise(double price) {
        // Arrange
        AvailableMerchandise merchandise = new AvailableMerchandise();
        merchandise.setPrice(price);
        merchandise.setName("Test Product");
        merchandise.setBrand("Test Brand");

        when(merchandiseRepository.save(any(AvailableMerchandise.class))).thenReturn(merchandise);

        // Act
        availableMerchandiseService.save(merchandise);

        // Assert
        assertEquals(price, merchandise.getPrice());
    }
}
