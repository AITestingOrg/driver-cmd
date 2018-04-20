package org.aitesting.microservices.drivercmd.models;

import org.aitesting.microservices.drivercmd.domain.models.DriverDto;
import org.junit.Assert;
import org.junit.Test;

import static org.aitesting.microservices.drivercmd.configuration.TestConstants.*;

public class DriverDtoTest {

    @Test
    public void createdDriverDtoSuccess() {
        //given
        DriverDto driver = new DriverDto(FIRST_NAME, LAST_NAME, ADDRESS, EMAIL, PHONE,
                LICENSE);

        //assert
        Assert.assertEquals(driver.getFirstName(), FIRST_NAME);
        Assert.assertEquals(driver.getLastName(), LAST_NAME);
        Assert.assertEquals(driver.getAddress(), ADDRESS);
        Assert.assertEquals(driver.getEmail(), EMAIL);
        Assert.assertEquals(driver.getPhone(), PHONE);
        Assert.assertEquals(driver.getLicense(), LICENSE);
    }
}
