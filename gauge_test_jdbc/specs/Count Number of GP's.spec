# Check Specialist table count is correct

This is an executable specification file. This file follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

To execute this specification, run
	gauge specs


	Context

	Populate Specification Store with SQL Values
	Rules are:
	 each query should only return 1 row
	 each query within the specification should return the same data set
	 Column names should be entered in uppcase
	 To Pass a field from expected query to actual use {}
	 e.g. GMCID
	 Select person_uid as GMCID from account where rowid=1;
	 select person_uid from specialist where person_uid={GMCID};

* get expected results "Select count(*) as COUNT from account where specialist='N' and GP = 'Y'"
* get actual results "Select count(*) as COUNT from gp"

## Check number of GPs
* Assert expected value for "COUNT" equals actual value for "COUNT"