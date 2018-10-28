package org.zhangyuying.receipt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhangyuying.receipt.service.EmailService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReceiptApplicationTests {

    @Autowired
    private EmailService emailService;

    @Test
    public void contextLoads() {
    }

}
