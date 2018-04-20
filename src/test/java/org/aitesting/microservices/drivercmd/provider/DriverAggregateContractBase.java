package org.aitesting.microservices.drivercmd.provider;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.aitesting.microservices.drivercmd.DriverCmdApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = DriverCmdApplication.class)
public abstract class DriverAggregateContractBase {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

    @After
    public void teardown() {
    }
}
