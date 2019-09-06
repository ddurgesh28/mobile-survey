package controllers;

import java.util.UUID;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;

import com.appirio.mobilesurvey.db.MSServicesException;
import com.appirio.mobilesurvey.db.manager.AccountDBManager;
import com.appirio.mobilesurvey.db.manager.SurveyDBManager;
import com.appirio.mobilesurvey.db.manager.api12.SurveyDBManager12;
import com.appirio.mobilesurvey.db.manager.api13.SurveyDBManager13;
import com.appirio.mobilesurvey.db.manager.api14.SurveyDBManager14;
import com.appirio.mobilesurvey.db.manager.api15.SurveyDBManager15;
import com.appirio.mobilesurvey.db.manager.api17.SurveyDBManager17;
import com.appirio.mobilesurvey.db.manager.api20.SurveyDBManager20;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class SurveyServices extends Controller {

	@With(SecureAction.class)
	public static Result getSurveysByAccount(String accountId) {
		try {
			SurveyDBManager manager = new SurveyDBManager(request().getHeader("uid"));
			ArrayNode result = null;
			
			try {
				result = manager.getSurveys(accountId);
			} finally {
				manager.close();
				
			}
			
			return ok(result);
    	} catch (MSServicesException e) {
    		e.printStackTrace();
    		
    		return internalServerError(ControllerUtils.messageToJson(e.getMessage()));
    	} catch (Exception e) {
    		e.printStackTrace();
    		
    		return internalServerError(ControllerUtils.messageToJson("An unexpected error occurred!"));
    	}
	}

	@With(SecureAction.class)
	public static Result getSurveysByAccount12(String accountId) {
		try {
			SurveyDBManager12 manager = new SurveyDBManager12(request().getHeader("uid"));
			AccountDBManager accountManager = new AccountDBManager();
			Result result = null;
			
			try {
				ObjectNode account = accountManager.getAccount(accountId);
				
				if(account != null) {
					ArrayNode surveys = manager.getSurveys(account);
					result = ok(surveys);
				} else {
					result = badRequest(ControllerUtils.messageToJson("Invalid account ID"));
				}
				
			} finally {
				manager.close();
				accountManager.close();
			}
			
			return result;
    	} catch (MSServicesException e) {
    		e.printStackTrace();
    		
    		return internalServerError(ControllerUtils.messageToJson(e.getMessage()));
    	} catch (Exception e) {
    		e.printStackTrace();
    		
    		return internalServerError(ControllerUtils.messageToJson("An unexpected error occurred!"));
    	}
	}

	@With(SecureAction.class)
	public static Result getSurveysByAccount13(String accountId) {
		try {
			SurveyDBManager13 manager = new SurveyDBManager13(request().getHeader("uid"));
			AccountDBManager accountManager = new AccountDBManager();
			Result result = null;
			
			try {
				ObjectNode account = accountManager.getAccount(accountId);
				
				if(account != null) {
					ArrayNode surveys = manager.getSurveys(account);
					result = ok(surveys);
				} else {
					result = badRequest(ControllerUtils.messageToJson("Invalid account ID"));
				}
				
			} finally {
				manager.close();
				accountManager.close();
			}
			
			return result;
    	} catch (MSServicesException e) {
    		e.printStackTrace();
    		
    		return internalServerError(ControllerUtils.messageToJson(e.getMessage()));
    	} catch (Exception e) {
    		e.printStackTrace();
    		
    		return internalServerError(ControllerUtils.messageToJson("An unexpected error occurred!"));
    	}
	}

	@With(SecureAction.class)
	public static Result getSurveysByAccount14(String accountId) {
		try {
			SurveyDBManager14 manager = new SurveyDBManager14(request().getHeader("uid"));
			AccountDBManager accountManager = new AccountDBManager();
			Result result = null;
			
			try {
				ObjectNode account = accountManager.getAccount(accountId);
				
				if(account != null) {
					ArrayNode surveys = manager.getSurveys(account);
					result = ok(surveys);
				} else {
					result = badRequest(ControllerUtils.messageToJson("Invalid account ID"));
				}
				
			} finally {
				manager.close();
				accountManager.close();
			}
			
			return result;
    	} catch (MSServicesException e) {
    		e.printStackTrace();
    		
    		return internalServerError(ControllerUtils.messageToJson(e.getMessage()));
    	} catch (Exception e) {
    		e.printStackTrace();
    		
    		return internalServerError(ControllerUtils.messageToJson("An unexpected error occurred!"));
    	}
	}
	
	@With(SecureAction.class)
	public static Result getSurveysByAccount15(String accountId) {
		try {
			SurveyDBManager15 manager = new SurveyDBManager15(request().getHeader("uid"));
			AccountDBManager accountManager = new AccountDBManager();
			Result result = null;
			
			try {
				ObjectNode account = accountManager.getAccount(accountId);
				
				if(account != null) {
					ArrayNode surveys = manager.getSurveys(account);
					result = ok(surveys);
				} else {
					result = badRequest(ControllerUtils.messageToJson("Invalid account ID"));
				}
				
			} finally {
				manager.close();
				accountManager.close();
			}
			
			return result;
    	} catch (MSServicesException e) {
    		e.printStackTrace();
    		
    		return internalServerError(ControllerUtils.messageToJson(e.getMessage()));
    	} catch (Exception e) {
    		e.printStackTrace();
    		
    		return internalServerError(ControllerUtils.messageToJson("An unexpected error occurred!"));
    	}
	}
	
	@With(SecureAction.class)
	public static Result getSurveysByAccount17(String accountId) {
		try {
			SurveyDBManager17 manager = new SurveyDBManager17(request().getHeader("uid"));
			AccountDBManager accountManager = new AccountDBManager();
			Result result = null;
			
			try {
				ObjectNode account = accountManager.getAccount(accountId);
				
				if(account != null) {
					ArrayNode surveys = manager.getSurveys(account);
					result = ok(surveys);
				} else {
					result = badRequest(ControllerUtils.messageToJson("Invalid account ID"));
				}
				
			} finally {
				manager.close();
				accountManager.close();
			}
			
			return result;
    	} catch (MSServicesException e) {
    		e.printStackTrace();
    		
    		return internalServerError(ControllerUtils.messageToJson(e.getMessage()));
    	} catch (Exception e) {
    		e.printStackTrace();
    		
    		return internalServerError(ControllerUtils.messageToJson("An unexpected error occurred!"));
    	}
	}
	
	@With(SecureAction.class)
	public static Result getUniversalSurveys() {
		try {
			SurveyDBManager manager = new SurveyDBManager(request().getHeader("uid"));
			ArrayNode result = null;
			
			try {
				result = manager.getSurveys();
			} finally {
				manager.close();
				
			}
			
			return ok(result);
    	} catch (MSServicesException e) {
    		e.printStackTrace();
    		
    		return internalServerError(ControllerUtils.messageToJson(e.getMessage()));
    	} catch (Exception e) {
    		e.printStackTrace();
    		
    		return internalServerError(ControllerUtils.messageToJson("An unexpected error occurred!"));
    	}
	}

	@With(SecureAction.class)
	public static Result getUniversalSurveys12() {
		try {
			SurveyDBManager12 manager = new SurveyDBManager12(request().getHeader("uid"));
			ArrayNode result = null;
			
			try {
				result = manager.getUniversalSurveys();
			} finally {
				manager.close();
				
			}
			
			return ok(result);
    	} catch (MSServicesException e) {
    		e.printStackTrace();
    		
    		return internalServerError(ControllerUtils.messageToJson(e.getMessage()));
    	} catch (Exception e) {
    		e.printStackTrace();
    		
    		return internalServerError(ControllerUtils.messageToJson("An unexpected error occurred!"));
    	}
	}

	@With(SecureAction.class)
	public static Result getUniversalSurveys13() {
		try {
			SurveyDBManager13 manager = new SurveyDBManager13(request().getHeader("uid"));
			ArrayNode result = null;
			
			try {
				result = manager.getUniversalSurveys();
			} finally {
				manager.close();
				
			}
			
			return ok(result);
    	} catch (MSServicesException e) {
    		e.printStackTrace();
    		
    		return internalServerError(ControllerUtils.messageToJson(e.getMessage()));
    	} catch (Exception e) {
    		e.printStackTrace();
    		
    		return internalServerError(ControllerUtils.messageToJson("An unexpected error occurred!"));
    	}
	}

	@With(SecureAction.class)
	public static Result getUniversalSurveys14() {
		try {
			SurveyDBManager14 manager = new SurveyDBManager14(request().getHeader("uid"));
			ArrayNode result = null;
			
			try {
				result = manager.getUniversalSurveys();
			} finally {
				manager.close();
				
			}
			
			return ok(result);
    	} catch (MSServicesException e) {
    		e.printStackTrace();
    		
    		return internalServerError(ControllerUtils.messageToJson(e.getMessage()));
    	} catch (Exception e) {
    		e.printStackTrace();
    		
    		return internalServerError(ControllerUtils.messageToJson("An unexpected error occurred!"));
    	}
	}
	
	@With(SecureAction.class)
	public static Result getUniversalSurveys15() {
		try {
			SurveyDBManager15 manager = new SurveyDBManager15(request().getHeader("uid"));
			ArrayNode result = null;
			
			try {
				result = manager.getUniversalSurveys();
			} finally {
				manager.close();
				
			}
			
			return ok(result);
    	} catch (MSServicesException e) {
    		e.printStackTrace();
    		
    		return internalServerError(ControllerUtils.messageToJson(e.getMessage()));
    	} catch (Exception e) {
    		e.printStackTrace();
    		
    		return internalServerError(ControllerUtils.messageToJson("An unexpected error occurred!"));
    	}
	}
	
	@With(SecureAction.class)
	public static Result getUniversalSurveys17() {
		try {
			SurveyDBManager17 manager = new SurveyDBManager17(request().getHeader("uid"));
			ArrayNode result = null;
			
			try {
				result = manager.getUniversalSurveys();
			} finally {
				manager.close();
				
			}
			
			return ok(result);
    	} catch (MSServicesException e) {
    		e.printStackTrace();
    		
    		return internalServerError(ControllerUtils.messageToJson(e.getMessage()));
    	} catch (Exception e) {
    		e.printStackTrace();
    		
    		return internalServerError(ControllerUtils.messageToJson("An unexpected error occurred!"));
    	}
	}

	@With(SecureAction.class)
	public static Result getUniversalSurveys20() {
		try {
			SurveyDBManager20 manager = new SurveyDBManager20(request().getHeader("uid"));
			ArrayNode result = null;
			
			try {
				result = manager.getUniversalSurveys();
			} finally {
				manager.close();
				
			}
			
			return ok(result);
    	} catch (MSServicesException e) {
    		e.printStackTrace();
    		
    		return internalServerError(ControllerUtils.messageToJson(e.getMessage()));
    	} catch (Exception e) {
    		e.printStackTrace();
    		
    		return internalServerError(ControllerUtils.messageToJson("An unexpected error occurred!"));
    	}
	}

	@With(SecureAction.class)
	public static Result saveSurvey() {
	    try {
			JsonNode body = request().body().asJson();
			// Auto generate random externalId that will be unique
			//String externalId = manager.md5Java();
			String externalId = UUID.randomUUID().toString();
			
			System.out.println(body);
			
			if(body != null) {
			    
				SurveyDBManager manager = new SurveyDBManager(request().getHeader("uid"));

				String grade = null;
				String percentage = null;
				String message = null;
				
				try {
					manager.createSurvey(body, externalId);
				    String query = "select grade__c, score__c, message__c from salesforce.dd_survey_submission__c where external_id__c='"+ externalId +"'";
				    ArrayNode ss = manager.getSS(query);
				    
				    grade = ss.get(0).get("grade__c").asText();
				    percentage = ss.get(0).get("score__c").asText();
				    message = ss.get(0).get("message__c").asText();
				    
				    if (grade.equalsIgnoreCase("null") && percentage.equalsIgnoreCase("null")) {
				        return ok();
				    }
				} finally {
				    manager.close();
				}
				
				return ok(ControllerUtils.gradeScoreToJson(grade, percentage, message));
			} else {
				return badRequest(ControllerUtils.messageToJson("json body expected"));
			}
    	} catch (MSServicesException e) {
    		e.printStackTrace();
    		
    		return internalServerError(e.getMessage());
    	} catch (Exception e) {
    		e.printStackTrace();
    		
    		return internalServerError(ControllerUtils.messageToJson("An unexpected error occurred!"));
    	}
	}
	
	@With(SecureAction.class)
	public static Result saveSurvey20() {
	    try {
			JsonNode body = request().body().asJson();
			// Auto generate random externalId that will be unique
			//String externalId = manager.md5Java();
			String externalId = UUID.randomUUID().toString();
			
			System.out.println(body);
			
			if(body != null) {
			    
				SurveyDBManager manager = new SurveyDBManager(request().getHeader("uid"));

				String grade = null;
				String percentage = null;
				String message = null;
				
				try {
					manager.createSurvey(body, externalId);
				    String query = "select grade__c, score__c, message__c from salesforce.dd_survey_submission__c where external_id__c='"+ externalId +"'";
				    ArrayNode ss = manager.getSS(query);
				    
				    grade = ss.get(0).get("grade__c").asText();
				    percentage = ss.get(0).get("score__c").asText();
				    message = ss.get(0).get("message__c").asText();
				    
				    if (grade.equalsIgnoreCase("null") && percentage.equalsIgnoreCase("null")) {
				        return ok();
				    }
				} finally {
				    manager.close();
				}
				
				return ok(ControllerUtils.gradeScoreToJson(grade, percentage, message));
			} else {
				return badRequest(ControllerUtils.messageToJson("json body expected"));
			}
    	} catch (MSServicesException e) {
    		e.printStackTrace();
    		
    		return internalServerError(e.getMessage());
    	} catch (Exception e) {
    		e.printStackTrace();
    		
    		return internalServerError(ControllerUtils.messageToJson("An unexpected error occurred!"));
    	}
	}	
}
