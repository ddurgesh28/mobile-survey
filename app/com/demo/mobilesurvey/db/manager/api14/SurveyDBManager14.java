package com.demo.mobilesurvey.db.manager.api14;

import java.text.MessageFormat;

import org.apache.commons.lang3.StringUtils;

import com.demo.mobilesurvey.db.MSServicesException;
import com.demo.mobilesurvey.db.manager.api13.SurveyDBManager13;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class SurveyDBManager14 extends SurveyDBManager13 {

	public SurveyDBManager14(String contactId) throws MSServicesException {
		super(contactId);
	}

	public ArrayNode getUniversalSurveys() throws MSServicesException {
		ArrayNode surveys = queryToJson(MessageFormat.format(getSQLStatement("survey-universal-query-14"), this.contactId));

		StringBuilder surveyIds = new StringBuilder();
		String separator = "";
		
		for(JsonNode survey : surveys) {
			surveyIds.append(separator);
			surveyIds.append("'");
			surveyIds.append(survey.get("sfid").asText());
			surveyIds.append("'");
			separator = ",";
		}
		
		ArrayNode result = mapper.createArrayNode(); 
		if(StringUtils.isNotBlank(surveyIds)){
			ArrayNode questions = queryToJson(MessageFormat.format(getSQLStatement("question-universal-query-14"), surveyIds.toString()));
			result = processSurveys(surveys, questions, false);
		}else{
			ObjectNode error = mapper.createObjectNode();
			error.put("error", "Survey not found.");
			result.add(error);
		}
		
		return result;
	}

	public ArrayNode getSurveys(ObjectNode account) throws MSServicesException {
		String zip = account.get("tdlinx_outlet_zip_code__c").asText();
		
		if(zip.length() > 5) {
			zip = zip.substring(0, 5);
		}
		
		String conditionTemplate = new String(" or category__c like ''%{0}%'' ");
		StringBuffer categoryCondition = new StringBuffer();
		
		String rawCategory = account.get("category__c").asText();
		if(rawCategory!=null && rawCategory!=""){
			String[] tArray = null;
			tArray = rawCategory.split(";");
			for (int i = 0; i < tArray.length; i++) {
				if(!tArray[i].equalsIgnoreCase("null")){
					categoryCondition.append(MessageFormat.format(conditionTemplate, tArray[i]));
				}
			}
		}
		String surveyQuery = MessageFormat.format(getSQLStatement("survey-query-with-filter-14"),
				account.get("tdlinx_sector__c").asText(), 
				account.get("tdlinx_trade_channel__c").asText(), 
				account.get("tdlinx_sub_channel__c").asText(),
				account.get("tdlinx_outlet_state__c").asText(), 
				zip, 
				account.get("national_account_group__c").asText(), 
				account.get("marketing_group__c").asText(), 
				account.get("tdlinx_account_level_e__c").asText(),
				account.get("account_segmentatiobn__c").asText(),
				categoryCondition.toString(),
				this.contactId);
		
		ArrayNode surveys = queryToJson(surveyQuery);
		
		StringBuilder surveyIds = new StringBuilder();
		String separator = "";
		
		for(JsonNode survey : surveys) {
			surveyIds.append(separator);
			surveyIds.append("'");
			surveyIds.append(survey.get("sfid").asText());
			surveyIds.append("'");
			separator = ",";
		}
		
		ArrayNode result = mapper.createArrayNode(); 
		if(StringUtils.isNotBlank(surveyIds)){
			ArrayNode questions = queryToJson(MessageFormat.format(getSQLStatement("question-query-with-filter-14"), surveyIds.toString()));
			result = processSurveys(surveys, questions, false);
		}else{
			ObjectNode error = mapper.createObjectNode();
			error.put("error", "Survey not found.");
			result.add(error);
		}
		
		return result;
	}	
}
