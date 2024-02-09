package klaar.utilities;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class ImageComparer {
    public static boolean CompareImage(WebDriver driver, WebElement actualImageElement, String expectedImagePath) {
        try {
            JQueryInjector.Inject(driver);
            BufferedImage expectedImage = ImageIO.read(new File(expectedImagePath));

            Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, actualImageElement);
            BufferedImage actualImage = logoImageScreenshot.getImage();

            ImageDiffer imgDiff = new ImageDiffer();
            ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);

            return !diff.hasDiff();
        } catch (Exception ex) {
            return false;
        }
    }
}
