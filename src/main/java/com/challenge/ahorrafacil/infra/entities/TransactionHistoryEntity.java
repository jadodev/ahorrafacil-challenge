package com.challenge.ahorrafacil.infra.entities;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.time.LocalDateTime;

@DynamoDBTable(tableName = "AccountHistory")
public class TransactionHistoryEntity {
    private int transactionId;
    @DynamoDBHashKey(attributeName = "clientId")
    private int clientId;
    private int productId;
    private String transactionType;
    private LocalDateTime transactionDate;
    private double amount;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
    @DynamoDBHashKey(attributeName = "clientId")
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @DynamoDBAttribute(attributeName = "productId")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @DynamoDBAttribute(attributeName = "transactionType")
    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @DynamoDBTypeConverted(converter = LocalDateTimeConverter.class)
    @DynamoDBAttribute(attributeName = "transactionDate")
    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    @DynamoDBAttribute(attributeName = "amount")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public static class LocalDateTimeConverter implements DynamoDBTypeConverter<String, LocalDateTime> {
        @Override
        public String convert(LocalDateTime object) {
            return object.toString();
        }

        @Override
        public LocalDateTime unconvert(String object) {
            return LocalDateTime.parse(object);
        }
    }
}