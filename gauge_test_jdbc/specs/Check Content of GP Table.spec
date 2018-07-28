# Specification Heading

This is an executable specification file. This file follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

To execute this specification, run
	gauge specs


	Context

	Populate Specification Store with SQL Values
	Rules are:
	 each query should only return 1 row
	 each query within the specification should return the same data set



* get field value with "Select person_uid as {gmcid} from account where lastname='Smith' and specialist='N' and GP = 'Y' and rownum=1"
* get expected results "Select person_uid as gmcid,firstname,lastname,status from account where person_uid={GMCID}"
* get actual results "Select person_uid as gmcid,firstname as givenname,lastname,status from gp where person_uid={GMCID}"

## Check content of GP Table
* Assert expected value for "GMCID" equals actual value for "GMCID"
* Assert expected value for "FIRSTNAME" equals actual value for "GIVENNAME"
* Assert expected value for "LASTNAME" equals actual value for "LASTNAME"


## Check Doctors status
* Assert expected value for "STATUS" equals actual value for "STATUS"