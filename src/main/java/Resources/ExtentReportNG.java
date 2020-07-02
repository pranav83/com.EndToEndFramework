package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
   public static ExtentReports eReport;
    public static ExtentReports getReportObject(){
      String path =  System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Automation Result for INDIANCOURTURE");
        reporter.config().setDocumentTitle("IndianCouture Test Result");

        ExtentReports eReport = new ExtentReports();
        eReport.attachReporter(reporter);
        eReport.setSystemInfo("QA Enginer","Pranav Pothiwala");
        return eReport;
    }
}
