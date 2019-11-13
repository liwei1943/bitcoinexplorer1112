package io.lw.bitcoinexplorer1112background.po;

public class Transaction {

    private Integer txid;

    private Integer transactionId;

    private String txhash;

    private String confirmations;

    private Integer time;

    private Integer amount;

    private Integer height;

    private Double totalInput;

    private Integer weight;

    private Integer statu;

    private String totalOutput;

    private String fees;

    private Integer feePerByte;

    private Integer feePerWeight;

    private Integer sizeondisk;

    private String blockId;

    public Integer getTxid() {
        return txid;
    }

    public void setTxid(Integer txid) {
        this.txid = txid;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getTxhash() {
        return txhash;
    }

    public void setTxhash(String txhash) {
        this.txhash = txhash;
    }

    public String getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(String confirmations) {
        this.confirmations = confirmations;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Double getTotalInput() {
        return totalInput;
    }

    public void setTotalInput(Double totalInput) {
        this.totalInput = totalInput;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    public String getTotalOutput() {
        return totalOutput;
    }

    public void setTotalOutput(String totalOutput) {
        this.totalOutput = totalOutput;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public Integer getFeePerByte() {
        return feePerByte;
    }

    public void setFeePerByte(Integer feePerByte) {
        this.feePerByte = feePerByte;
    }

    public Integer getFeePerWeight() {
        return feePerWeight;
    }

    public void setFeePerWeight(Integer feePerWeight) {
        this.feePerWeight = feePerWeight;
    }

    public Integer getSizeondisk() {
        return sizeondisk;
    }

    public void setSizeondisk(Integer sizeondisk) {
        this.sizeondisk = sizeondisk;
    }

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }
}