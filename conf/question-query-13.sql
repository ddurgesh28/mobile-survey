SELECT 
    conditional_answer__c,
    next_question__c,
    label_for_add_l_comments__c,
    answer_options__c,
    sfid,
    question_text__c,
    parent_question__c,
    NAME,
    sfid,
    question_type__c,
    dms_survey__c
FROM 
    dms_question__c
WHERE dms_survey__c IN (SELECT sfid
            FROM dms_survey__c
            WHERE (Active__c IS NULL OR Active__c = true)
            AND (IsParent__c IS NULL OR IsParent__c = false)
            AND parent_survey__c IS NULL)
ORDER BY 
    dms_survey__c