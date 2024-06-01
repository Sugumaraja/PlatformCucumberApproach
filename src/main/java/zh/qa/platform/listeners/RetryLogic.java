package zh.qa.platform.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryLogic implements IRetryAnalyzer{
private int count=0;
private static int maxTry=2;
@Override
public boolean retry(ITestResult iTestResult) {
if (!iTestResult.isSuccess()) {//check if the test result is not success.
	if(count<maxTry) {//check the retry attempt less than count
		count++;//increase the count when it enter the loop.
		iTestResult.setStatus(ITestResult.FAILURE);//Set the test result as failure
		return true;// it will run the test again
	}
	else {
		iTestResult.setStatus(ITestResult.FAILURE);// once the count reach max will come to this and set the result as failure
	}}
	else {
		iTestResult.setStatus(ITestResult.SUCCESS);//if the first condition is success it will result success
	}
return false;// tentNG will not run the test again.
}
}
