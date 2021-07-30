package com.models;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Fixer")
public class FixerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "base_currency", referencedColumnName = "id")
    private Currency baseCurrency;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "target_currency", referencedColumnName = "id")
    private Currency targetCurrency;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "date")
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Currency getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(Currency baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public Currency getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(Currency targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
