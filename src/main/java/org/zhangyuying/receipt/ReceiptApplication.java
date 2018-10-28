package org.zhangyuying.receipt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zhangyuying.receipt.entity.Receipt;
import org.zhangyuying.receipt.service.EmailService;


/**
 * @author Vinci
 */
@SpringBootApplication
@Controller
public class ReceiptApplication {


    @Autowired
    EmailService emailService;

    /**
     * 传递Receipt对象到Index页面，Index页面才能提交一个Bean到后台
     *
     * @param model
     * @return index.html
     */
    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("receipt", new Receipt());
        return "index";
    }

    /**
     * 把receipt传递到success页面
     * TODO
     *
     * @param receipt 前端把信息赋值给Receipt对象
     * @param model
     * @return success.html
     */
    @RequestMapping("/sendReceiptEmail")
    public String sendReceiptEmail(@ModelAttribute(value = "receipt") Receipt receipt, Model model) {
        model.addAttribute("receipt", receipt);

        /*
        在这里掉接口，查询发票链接：如

        String receiptURL = CompanyInterface.getReceiptURL(receipt.getReceiptID());
        然后发邮件给用户

         */
        // 假设这是从公司服务器接口取出来的发票链接
        String receiptURL = "http://receiptURL.jwqwy.space";

        int success = emailService.sendReceiptEmail(receipt.getEmail(), "发票地址", receiptURL);

        if (success == 1) {
            return "success";
        } else {
            return "error";
        }

    }

    public static void main(String[] args) {

        SpringApplication.run(ReceiptApplication.class, args);
    }
}
