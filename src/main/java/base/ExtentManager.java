package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports report;

    public static ExtentReports getInstance(){
        if(report == null){
            ExtentSparkReporter spark = new ExtentSparkReporter("./reports/spark.html");
            report = new ExtentReports();

            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("My own report");
            spark.config().setEncoding("utf-8");
            spark.config().setReportName("My report");

            report.attachReporter(spark);
        }


        return report;
    }

}
