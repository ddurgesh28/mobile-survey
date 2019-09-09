package com.demo.mobilesurvey.db.manager.api14;

import java.text.MessageFormat;

import com.demo.mobilesurvey.db.MSServicesException;
import com.demo.mobilesurvey.db.manager.AccountDBManager;
import com.demo.mobilesurvey.geolocation.HaversineCalculator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;


public class AccountDBManager14 extends AccountDBManager {

	public AccountDBManager14() throws MSServicesException {
		super();
	}
	
	public JsonNode findAccounts(Double latitude, Double longitude, Double radius, long limit) throws MSServicesException {
		double degrees = radius / 50;
		
		ArrayNode result = queryToJson(MessageFormat.format(getSQLStatement("accounts-query-14"), latitude, longitude, latitude - degrees, latitude + degrees, longitude - degrees, longitude + degrees, limit));
		
		return processAccounts(result, latitude, longitude);
	}
}
