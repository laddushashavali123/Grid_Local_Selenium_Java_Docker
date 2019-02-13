package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTC implements IRetryAnalyzer {
    private int count = 0;
    private static int maxTry = Integer.parseInt(System.getProperty("retryFailed"));

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {                      //Check if HelloController not succeed
            if (count < maxTry) {                            //Check if maxtry count is reached
                count++;                                     //Increase the maxTry count by 1
                iTestResult.setStatus(ITestResult.FAILURE);  //Mark HelloController as failed
                return true;                                 //Tells TestNG to re-run the HelloController
            } else {
                iTestResult.setStatus(ITestResult.FAILURE);  //If maxCount reached,HelloController marked as failed
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);      //If HelloController passes, TestNG marks it as passed
        }
        return false;
    }
}
