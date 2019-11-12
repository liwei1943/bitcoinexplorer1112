package io.lw.bitcoinexplorer1112background.po;

public class Block {
    private String blockhash;

    private Integer blockId;

    private Integer confirmations;

    private Long time;

    private Integer height;

    private Integer txnumber;

    private Double difficulty;

    private Integer weight;

    private String merkleRoot;

    private String version;

    private Integer bits;

    private String miner;

    private Integer nonce;

    private Double txvolume;

    private Double blockReward;

    private Double feeReward;

    private Integer sizeondisk;

    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash == null ? null : blockhash.trim();
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public Integer getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(Integer confirmations) {
        this.confirmations = confirmations;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getTxnumber() {
        return txnumber;
    }

    public void setTxnumber(Integer txnumber) {
        this.txnumber = txnumber;
    }

    public Double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Double difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getMerkleRoot() {
        return merkleRoot;
    }

    public void setMerkleRoot(String merkleRoot) {
        this.merkleRoot = merkleRoot == null ? null : merkleRoot.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public Integer getBits() {
        return bits;
    }

    public void setBits(Integer bits) {
        this.bits = bits;
    }

    public String getMiner() {
        return miner;
    }

    public void setMiner(String miner) {
        this.miner = miner == null ? null : miner.trim();
    }

    public Integer getNonce() {
        return nonce;
    }

    public void setNonce(Integer nonce) {
        this.nonce = nonce;
    }

    public Double getTxvolume() {
        return txvolume;
    }

    public void setTxvolume(Double txvolume) {
        this.txvolume = txvolume;
    }

    public Double getBlockReward() {
        return blockReward;
    }

    public void setBlockReward(Double blockReward) {
        this.blockReward = blockReward;
    }

    public Double getFeeReward() {
        return feeReward;
    }

    public void setFeeReward(Double feeReward) {
        this.feeReward = feeReward;
    }

    public Integer getSizeondisk() {
        return sizeondisk;
    }

    public void setSizeondisk(Integer sizeondisk) {
        this.sizeondisk = sizeondisk;
    }
}