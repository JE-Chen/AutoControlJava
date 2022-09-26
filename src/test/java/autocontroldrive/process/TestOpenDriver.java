package autocontroldrive.process;

import org.junit.Test;

import autocontroldriver.process.OpenDriverProcess;


public class TestOpenDriver {

    @Test
    public void testOpen() {
        OpenDriverProcess openDriverProcess = new OpenDriverProcess(
                "C:\\program_workspace\\java\\AutoControlJava\\test_resource\\generate_autocontrol_driver_win64.exe");
        openDriverProcess.start();
    }

}
