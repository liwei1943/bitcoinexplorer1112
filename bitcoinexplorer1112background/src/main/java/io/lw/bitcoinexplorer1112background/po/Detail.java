package io.lw.bitcoinexplorer1112background.po;

public class Detail {
    private String txDetailId;

    private Integer transactionId;

    private String address;

    private String type;

    private String amount;

    public String getTxDetailId() {
        return txDetailId;
    }

    public void setTxDetailId(String txDetailId) {
        this.txDetailId = txDetailId == null ? null : txDetailId.trim();
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }
}