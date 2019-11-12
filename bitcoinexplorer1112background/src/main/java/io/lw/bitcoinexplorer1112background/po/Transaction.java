package io.lw.bitcoinexplorer1112background.po;

public class Transaction {
    private String txhash;

    private Integer confirmations;

    private Integer receivedtime;

    private Integer status;

    private Integer height;

    private Double totalinput;

    private Integer weight;

    private String totaloutput;

    private String fees;

    private Integer feeperbyte;

    private Integer feeperweight;

    private Integer size;

    private String blockhash;

    public String getTxhash() {
        return txhash;
    }

    public void setTxhash(String txhash) {
        this.txhash = txhash == null ? null : txhash.trim();
    }

    public Integer getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(Integer confirmations) {
        this.confirmations = confirmations;
    }

    public Integer getReceivedtime() {
        return receivedtime;
    }

    public void setReceivedtime(Integer receivedtime) {
        this.receivedtime = receivedtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Double getTotalinput() {
        return totalinput;
    }

    public void setTotalinput(Double totalinput) {
        this.totalinput = totalinput;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getTotaloutput() {
        return totaloutput;
    }

    public void setTotaloutput(String totaloutput) {
        this.totaloutput = totaloutput == null ? null : totaloutput.trim();
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees == null ? null : fees.trim();
    }

    public Integer getFeeperbyte() {
        return feeperbyte;
    }

    public void setFeeperbyte(Integer feeperbyte) {
        this.feeperbyte = feeperbyte;
    }

    public Integer getFeeperweight() {
        return feeperweight;
    }

    public void setFeeperweight(Integer feeperweight) {
        this.feeperweight = feeperweight;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash == null ? null : blockhash.trim();
    }
}