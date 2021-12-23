package com.example.banksystem.model;

public class UserInfo {

    private Integer id;
    private Integer bankId;

    private Integer sum;
    private Integer term;

    private Integer loan;

    public UserInfo(Integer id, Integer bankId, Integer sum, Integer term, Integer loan) {
        this(bankId, sum, term, loan);
        this.id = id;
    }

    public UserInfo(Integer bankId, Integer sum, Integer term, Integer loan) {
        this.bankId = bankId;
        this.sum = sum;
        this.term = term;
        this.loan = loan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Integer getLoan() {
        return loan;
    }

    public void setLoan(Integer loan) {
        this.loan = loan;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", bankId=" + bankId +
                ", sum=" + sum +
                ", term=" + term +
                ", loan=" + loan +
                '}';
    }
}
