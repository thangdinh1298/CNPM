package Entities;

public class DepositReceipt {
    private int id;
    private float totalDepositPaid;

    public DepositReceipt(int id, float totalDepositPaid) {
        this.id = id;
        this.totalDepositPaid = totalDepositPaid;
    }

    public int getId() {
        return id;
    }

    public float getTotalDepositPaid() {
        return totalDepositPaid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTotalDepositPaid(float totalDepositPaid) {
        this.totalDepositPaid = totalDepositPaid;
    }
}
