package tests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCases implements IRetryAnalyzer
{
	private int retryCnt=0;
	private int retryMaxCnt=1;
	
	public boolean retry(ITestResult result)
	{
		if(retryCnt<retryMaxCnt)
		{
			System.out.println("Retrying "+result.getName());
			retryCnt++;
			return true;
		}
		return false;
	}
}
