package base;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Util {

    //applicable for all browser, but takes screnshot only the visible portion of the browser
    public static String getScreenshot(String imagename) throws IOException, IOException {
        TakesScreenshot ts = (TakesScreenshot) PageDriver.getCurrentDriver();
        File f = ts.getScreenshotAs(OutputType.FILE);
        String filePath = "./screenshot/"+imagename;
        FileUtils.copyFile(f, new File(filePath));
        return filePath;
    }

    public static String convertImg_Base64(String screenshotPath) throws IOException {
           /*File f = new File(screenshotPath);
            FileInputStream fis = new FileInputStream(f);
            byte[] bytes = new byte[(int)f.length()];
            fis.read(bytes);
            String base64Img =
                    new String(Base64.encodeBase64(bytes), StandardCharsets.UTF_8);
            */

        byte[] file = FileUtils.readFileToByteArray(new File(screenshotPath));
        String base64Img = Base64.encodeBase64String(file);
        return  base64Img;
    }
}
