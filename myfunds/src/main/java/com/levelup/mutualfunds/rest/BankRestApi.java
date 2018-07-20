package com.levelup.mutualfunds.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

public class BankRestApi extends BankRestApiModel {
	//==================================================================Account==========================================================================
	//get account by id
	@Override
	public HttpResponse getAccount(String AccountID) throws Exception {
		HttpClientFactory factory = new HttpClientFactory();
		HttpClient client = factory.getHttpsClient();		
		HttpGet request = new HttpGet("https://dev.botsfinancial.com/api/accounts/" + AccountID);
		//header:
		request.addHeader(BankRestApiModel.getHeaderAuthKey(), BankRestApiModel.getHeaderAuthValue());
		HttpResponse response = client.execute(request);
		return response;
	}
	@Override
	public HttpResponse getAllTransactions(String AccountID) throws Exception {
		HttpClientFactory factory = new HttpClientFactory();
		HttpClient client = factory.getHttpsClient();		
		HttpGet request = new HttpGet("https://dev.botsfinancial.com/api/accounts/" + AccountID + "/transactions");
		//header:
		request.addHeader(BankRestApiModel.getHeaderAuthKey(), BankRestApiModel.getHeaderAuthValue());
		HttpResponse response = client.execute(request);
		return response;
	}
	@Override
	public void updateAccountBalance(Object JSON) throws Exception {
		// TODO: IMPLEMENT
		
	}
	
	
	//==================================================================Customer==========================================================================
	//getCustomer by CustomerID
	@Override
	public HttpResponse getCustomer(String CustomerID) throws Exception {
		HttpClientFactory factory = new HttpClientFactory();
		HttpClient client = factory.getHttpsClient();		
		HttpGet request = new HttpGet("https://dev.botsfinancial.com/api/customers/" + CustomerID);
		//header:
		request.addHeader(BankRestApiModel.getHeaderAuthKey(), BankRestApiModel.getHeaderAuthValue());
		HttpResponse response = client.execute(request);				
		return response;
	}

	@Override
	public HttpResponse getAllCustomerAccounts(String CustomerID) throws Exception {
		HttpClientFactory factory = new HttpClientFactory();
		HttpClient client = factory.getHttpsClient();		
		HttpGet request = new HttpGet("https://dev.botsfinancial.com/api/customers/" + CustomerID + "/accounts");
		//header:
		request.addHeader(BankRestApiModel.getHeaderAuthKey(), BankRestApiModel.getHeaderAuthValue());
		HttpResponse response = client.execute(request);				
		return response;
	}
	
	@Override
	public HttpResponse getAllCustomerTransactions(String CustomerID) throws Exception {
		HttpClientFactory factory = new HttpClientFactory();
		HttpClient client = factory.getHttpsClient();		
		HttpGet request = new HttpGet("https://dev.botsfinancial.com/api/customers/" + CustomerID + "/transactions");
		//header:
		request.addHeader(BankRestApiModel.getHeaderAuthKey(), BankRestApiModel.getHeaderAuthValue());
		HttpResponse response = client.execute(request);				
		return response;
	}


	//==================================================================Transaction==========================================================================
	@Override
	public HttpResponse getTransaction(String ID) throws Exception {
		HttpClientFactory factory = new HttpClientFactory();
		HttpClient client = factory.getHttpsClient();		

		HttpGet request = new HttpGet("https://dev.botsfinancial.com/api/transactions/" + ID);
		//header:
		request.addHeader(BankRestApiModel.getHeaderAuthKey(), BankRestApiModel.getHeaderAuthValue());
		HttpResponse response = client.execute(request);				
		return response;
	}
	
	//==================================================================Transfer==========================================================================
	@Override
	public HttpResponse getTransferReceipt(String ID) throws Exception {
		HttpClientFactory factory = new HttpClientFactory();
		HttpClient client = factory.getHttpsClient();		
		HttpGet request = new HttpGet("https://dev.botsfinancial.com/api/transfers/" + ID);
		//header:
		request.addHeader(BankRestApiModel.getHeaderAuthKey(), BankRestApiModel.getHeaderAuthValue());
		HttpResponse response = client.execute(request);				
		return response;
	}
	
	
	
	
	//===================================================================misc================================================================================
	public void printToScreen(HttpResponse response) throws IllegalStateException, IOException {
		HttpEntity entity = response.getEntity();
		BufferedReader rd = new BufferedReader
			    (new InputStreamReader(
			    entity.getContent()));
				// use org.apache.http.util.EntityUtils to read json as string
				String jsonString = EntityUtils.toString(entity, StandardCharsets.UTF_8);
				System.out.println("HTTPS RESPONSE: " + jsonString);	
	}

	
}
