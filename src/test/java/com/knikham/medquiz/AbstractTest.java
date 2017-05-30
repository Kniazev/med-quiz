package com.knikham.medquiz;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration( classes = MedQuizApplicatoin.class)
public class AbstractTest {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
}
