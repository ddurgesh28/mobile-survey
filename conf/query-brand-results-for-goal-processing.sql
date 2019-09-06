SELECT
	b.id,
	r.goal_achievement__c,
	q.is_goal__c,
	r.answer_text__c,
	b.answer__c,
	q.question_type__c,
	q.goal_type__c
FROM
	salesforce.dd_survey_result_brands__c b
	INNER JOIN salesforce.dms_survey_result__c r ON  r.result_brand_ext_id__c = b.dms_survey_result__c__result_brand_ext_id__c
	INNER JOIN salesforce.dms_question__c q ON q.sfid = r.question__c
WHERE
	r.id IN ({0}) 