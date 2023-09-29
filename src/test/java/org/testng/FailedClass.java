package org.testng;

public class FailedClass implements IRetryAnalyzer {

	int min =0 ; int max =3;
	
	public boolean retry(ITestResult arg0) {
		if (min<max) {
			
			min++;
			return true;
		}
		return false;
	}

}
