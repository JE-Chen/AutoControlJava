package autocontroldriver.bind.image;

import autocontroldriver.utils.driver_manager.DriverManager;

public class Image {

    private DriverManager driverManager;
    /**
     *
     * @param driverManager:
     * */
    public Image(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    /**
     *
     * @param imagePath:
     * @param detectThreshold:
     * @param drawImage:
     * */
    public String locateAllImage(String imagePath, double detectThreshold, boolean drawImage) {
        imagePath = imagePath.replace("\\", "/");
        return this.driverManager.sendCommand(
                String.format(  
                        "[[\"locate_all_image\", {\"image\": \"%s\"," +
                                "\"detect_threshold\": %.1f," +
                                "\"draw_image\": %b}]]",
                        imagePath, detectThreshold, drawImage)
        );
    }

    /**
     *
     * @param imagePath:
     * @param detectThreshold:
     * @param drawImage:
     * */
    public String locateImageCenter(String imagePath, double detectThreshold, boolean drawImage) {
        imagePath = imagePath.replace("\\", "/");
        return this.driverManager.sendCommand(
                String.format(
                        "[[\"locate_image_center\", {\"image\": \"%s\"," +
                                "\"detect_threshold\": %.1f," +
                                "\"draw_image\": %b}]]",
                        imagePath, detectThreshold, drawImage)
        );
    }

    /**
     *
     * @param imagePath:
     * @param mouseKeycode:
     * @param detectThreshold:
     * @param drawImage:
     * */
    public String locateAndClick(String imagePath, String mouseKeycode,double detectThreshold, boolean drawImage) {
        imagePath = imagePath.replace("\\", "/");
        return this.driverManager.sendCommand(
                String.format(
                        "[[\"locate_and_click\", {\"image\": \"%s\"," +
                                "\"mouse_keycode\": \"%s\"" +
                                "\"detect_threshold\": %.1f," +
                                "\"draw_image\": %b}]]",
                        imagePath, mouseKeycode,detectThreshold, drawImage)
        );
    }

}
