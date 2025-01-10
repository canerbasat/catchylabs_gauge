package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtil {
    private static ExtentReports extent;
    private static ExtentTest test;
    private static ExtentSparkReporter sparkReporter;

    public static void initReport() {
        // Rapor dosyasını belirtiyoruz
        sparkReporter = new ExtentSparkReporter("extentReport.html");

        // Raporu ExtentReports ile ilişkilendiriyoruz
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Rapor meta bilgilerini ekliyoruz (opsiyonel)
        extent.setSystemInfo("Tester", "Caner Basat");
        extent.setSystemInfo("Environment", "Test");
    }

    public static void startTest(String testName, String description) {
        // Yeni bir test başlat
        test = extent.createTest(testName, description);
    }

    public static void log(String message) {
        // Test logu ekle
        test.info(message);
    }

    public static void flushReport() {
        // Raporu finalize et ve kaydet
        extent.flush();
    }
    // Hata durumlarını loglamak için fail metodu
    public static void fail(String message) {
        if (extent != null) {
            test.fail(message);
        }
    }


    // Başarılı durumları loglamak için pass metodu
    public static void pass(String message) {
        if (test != null) {
            test.pass(message);
        }
    }
}