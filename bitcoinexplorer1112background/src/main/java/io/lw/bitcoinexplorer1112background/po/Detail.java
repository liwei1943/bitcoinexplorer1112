package io.lw.bitcoinexplorer1112background.po;

public class Detail {
    private String txDetailId;

    private Integer transactionId;

    private String address;

    private Byte type;

    private Double amount;

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

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type == null ? null : type.byteValue();
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount == null ? null : amount.doubleValue();
    }
}