package com.challenge.ahorrafacil.infra.repositories;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.challenge.ahorrafacil.infra.entities.TransactionHistoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionHistoryRepository {

    private final DynamoDBMapper dynamoDBMapper;

    @Autowired
    public TransactionHistoryRepository(AmazonDynamoDB amazonDynamoDB) {
        this.dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
    }

    public void save(TransactionHistoryEntity transaction) {
        dynamoDBMapper.save(transaction);
    }

    public TransactionHistoryEntity findById(String transactionId) {
        return dynamoDBMapper.load(TransactionHistoryEntity.class, transactionId);
    }

    public List<TransactionHistoryEntity> findByClientId(int clientId) {
        TransactionHistoryEntity partitionKey = new TransactionHistoryEntity();
        partitionKey.setClientId(clientId);

        DynamoDBQueryExpression<TransactionHistoryEntity> queryExpression = new DynamoDBQueryExpression<TransactionHistoryEntity>()
                .withHashKeyValues(partitionKey);

        return dynamoDBMapper.query(TransactionHistoryEntity.class, queryExpression);
    }
}