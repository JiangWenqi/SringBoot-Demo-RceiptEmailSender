package org.zhangyuying.receipt.service;

import org.springframework.stereotype.Service;

/**
 * receipt
 *
 * @author Vinci
 * Create: 2018/10/23 11:49
 * Description: 发送Email服务
 */
@Service
public interface EmailService {
    /**
     * 发送邮件
     * @param clientEmailAddr 客户的邮件地址
     * @param subject 主题
     * @param content 内容（发票链接）
     * @return 是否成功{成功为1；不成功为2}
     */
    int sendReceiptEmail(String clientEmailAddr, String subject, String content);
}
