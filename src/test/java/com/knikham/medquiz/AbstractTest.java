package com.knikham.medquiz;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.boot.test.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
//@SpringApplicationConfiguration( classes = MedQuizApplicatoin.class)
@SpringBootTest
public class AbstractTest {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
}
