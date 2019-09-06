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
    (Active__c is null or Active__c = true)
    and (start_date__c is null OR start_date__c <= current_date)
    and (end_date__c is null OR current_date <= end_date__c) 
    and (
		(select count(*) from dms_question__c q where q.DMS_Survey__c=s.sfid)>0 
		or (select count(*) from dms_survey__c sr where sr.Active__c = true and sr.Parent_Survey__c=s.sfid)>0
	)
    and (
    	universal_survey__c
    	or (
    		(
    			sector__c is null 
    			or sector__c = ''ALL'' 
    			or sector__c = '''' 
    			or sector__c like ''%{0}%''
    		) and (
    			trade_channel__c is null 
    			or trade_channel__c = ''ALL'' 
    			or trade_channel__c = '''' 
    			or trade_channel__c like ''%{1}%''
    		) and (
    			sub_channel__c is null 
    			or sub_channel__c = ''ALL'' 
    			or sub_channel__c = '''' 
    			or sub_channel__c like ''%{2}%''
    		) and (
    			state__c is null 
    			or state__c = '''' 
    			or state__c like ''%{3}%''
    		) and (
    			zip_codes__c is null 
    			or zip_codes__c = '''' 
    			or zip_codes__c like ''%{4}%''
    		) and (
    			national_account__c is null 
    			or national_account__c = '''' 
    			or national_account__c = ''{5}''
    		) and (
    			marketing_group__c is null 
    			or marketing_group__c = '''' 
    			or marketing_group__c = ''{6}''
    		) and (
    			tdlinx_acct_level_e__c is null 
    			or tdlinx_acct_level_e__c = '''' 
    			or tdlinx_acct_level_e__c = ''{7}''
			) and (
				account_segmentation__c is null
				or account_segmentation__c = '''' 
				or account_segmentation__c = ''{8}''
    		) and ( 
				category__c is NULL 
                or category__c = ''''
                {9}
			)
    	)
	) and (
		universal_survey__c 
		or sfid in (
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
                        INNER JOIN salesforce.dd_survey_member__c sm ON sm.dd_survey_group__c = gm.dd_survey_group__c
                    WHERE
                        gm.contact__c = ''{10}''
                ) 
		) or (
			SELECT
				count(*)
			FROM
				salesforce.dd_survey_member__c
			WHERE
				dd_survey__c = s.sfid
		) = 0
	)
ORDER BY 
    sfid