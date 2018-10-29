package space.jwqwy.receipt.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import space.jwqwy.receipt.service.EmailService;

/**
 * receipt
 *
 * @author Vinci
 * Create: 2018/10/23 11:51
 * Description: Email发送实现类
 */
@Component
public class EmailServiceImpl implements EmailService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender mailSender;

    @Value("${mail.fromMail.addr}")
    private String from;

    @Override
    public int sendReceiptEmail(String clientEmailAddr, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(clientEmailAddr);
        message.setSubject(subject);
        message.setText(content);
        try {
            mailSender.send(message);
            logger.info("简单邮件已经发送。");
            return 1;
        } catch (Exception e) {
            logger.error("发送简单邮件时发生异常！", e);
            return -1;
        }
    }
}
