package Entities;

import java.util.Date;

public class OverdueBill {
    private int id;
    private Date paymentDeadline;
//    private float totalAmountToPay;

    public OverdueBill(int id, Date paymentDeadline) {
        this.id = id;
        this.paymentDeadline = paymentDeadline;
    }

    public int getId() {
        return id;
    }

    public Date getPaymentDeadline() {
        return paymentDeadline;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPaymentDeadline(Date paymentDeadline) {
        this.paymentDeadline = paymentDeadline;
    }
}
