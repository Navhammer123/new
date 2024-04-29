package NEWPAACKONE;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class listerb implements IRetryAnalyzer{
	
	private int retrycount=0;
	private static final int maxretrycount=3;

	@Override
	public boolean retry(ITestResult result) {
		if (!result.isSuccess()) {
			if (retrycount < maxretrycount) {
				retrycount++;
				
				return true;
			}
		}
		return false;
	}
	
	

}
