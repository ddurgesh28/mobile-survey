SELECT 
	isparent__c, 
	parent_survey__c, 
	enable_edit_on_review_screen__c, 
	name, 
	sfid, 
	survey_type__c, 
	first_question__c, 
	grading_scale__c, 
	total_possible_score__c 
FROM 
	salesforce.dms_survey__c s
WHERE
    (
    	(Active__c is null or Active__c = true)    
    	and (IsParent__c is null or IsParent__c = false) 
    	and parent_survey__c is null
    	and (start_date__c is null OR start_date__c <= current_date)
    	and (end_date__c is null OR current_date <= end_date__c) 
    	and (
    		(select count(*) from salesforce.dms_question__c q where q.DMS_Survey__c=s.sfid)>0 
    		or (select count(*) from salesforce.dms_survey__c sr where sr.Active__c = true and sr.Parent_Survey__c=s.sfid)>0
		)  
    ) and universal_survey__c	
    or (
        sfid in (
          SELECT
              DISTINCT dd_survey__c
          FROM
              salesforce.dd_survey_member__c
          WHERE
              dd_survey_group__c IN (
                  SELECT
                      sm.dd_survey_group__c
                  FROM
                      salesforce.dd_group_member__c gm
                      INNER JOIN dd_survey_member__c sm ON sm.dd_survey_group__c = gm.dd_survey_group__c
                  WHERE
                      gm.contact__c = ''{0}''
              ) 
        )
    )
ORDER BY
	sfid