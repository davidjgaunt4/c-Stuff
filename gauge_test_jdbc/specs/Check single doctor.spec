Specification Heading
=====================
Created by davidgaunt on 22/07/2018

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
     

* get field value with "select person_uid as {GMC_ID} from account where firstname='John' and lastname='Smith' and GP = 'Y' and specialist='N' and rownum=1"

* get expected results "SELECT (SELECT COUNT(*) FROM GP) AS GP_CNT, (SELECT COUNT(*) FROM ACCOUNT WHERE GP='Y' AND SPECIALIST='N') AS ACCOUNT_GP_CNT, (SELECT COUNT(*) FROM SPECIALIST) AS SPEC_CNT, (SELECT COUNT(*) FROM ACCOUNT WHERE GP='N' AND SPECIALIST='Y') AS ACCOUNT_SPEC_CNT, (SELECT COUNT(*) FROM SPECIALIST_GP) AS SPEC_GP_CNT, (SELECT COUNT(*) FROM ACCOUNT WHERE GP='Y' AND SPECIALIST='Y') AS ACCOUNT_SPEC_GP_CNT FROM GP WHERE ROWNUM = 1"

* get actual results "select * from v_testcnt"


Scenario Heading
----------------


 * Assert expected value for "GP_CNT" equals actual value for "GP_CNT"
 * Assert expected value for "ACCOUNT_GP_CNT" equals actual value for "ACCOUNT_GP_CNT"
 * Assert expected value for "SPEC_CNT" equals actual value for "SPEC_CNT"
 * Assert expected value for "ACCOUNT_SPEC_CNT" equals actual value for "ACCOUNT_SPEC_CNT"
 * Assert expected value for "SPEC_GP_CNT" equals actual value for "SPEC_GP_CNT"
 * Assert expected value for "ACCOUNT_SPEC_GP_CNT" equals actual value for "ACCOUNT_SPEC_GP_CNT"
