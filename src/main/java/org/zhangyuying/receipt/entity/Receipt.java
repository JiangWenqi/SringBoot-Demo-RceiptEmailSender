package org.zhangyuying.receipt.entity;

/**
 * receipt
 *
 * @author Vinci
 * Create: 2018/10/22 23:54
 * Description: 实体类
 */

public class Receipt {
    private String receiptID;
    private String cellphone;
    private String email;

    public String getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(String receiptID) {
        this.receiptID = receiptID;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
