package com.awsexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamoDbConfig {
	
	public static final String ACCESS_KEY = "AKIAXKFNDV3IPY5T7UGK";
	
	public static final String SECRET_KEY = "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";
	public static final String SERVICE_ENDPOINT = "dynamodb.eu-north-1.amazonaws.com";
	public static final String REGION = "eu-north-1";
	@Bean
	DynamoDBMapper mapper() {
		return new DynamoDBMapper(amaconDynamoDbConfig());
	}

	private AmazonDynamoDB amaconDynamoDbConfig() {
		return AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(SERVICE_ENDPOINT, REGION))
				.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY)))
				.build();
	}

}
