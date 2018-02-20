package com.teamtreehouse.techdegree.hardware;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

import com.example.accessory.Horn;
import com.example.accessory.Strobe;

public class FrightMachineTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    private FrightMachine machine;
    private Horn horn;
    private Strobe strobe;
    private Camera camera;

    @Before
    public void setUp() throws Exception {
        machine = new FrightMachine();
        horn = new Horn();
        strobe = new Strobe();
        camera = new Camera();

        machine.addObserver("horn", horn);
        machine.addObserver("strobe", strobe);
        machine.addObserver("camera", camera);
    }

    @Test
    public void whenMotionIsDetectedExpectedPluginsKickOff() throws Exception {
        machine.simulateMotion();
        assertThat(systemOutRule.getLog(), allOf(containsString("BEEEEEEEP"),
                                                 containsString("Flashing lights"),
                                                 containsString("Photo #5 taken")));
    }
}