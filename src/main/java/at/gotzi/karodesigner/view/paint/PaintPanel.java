package at.gotzi.karodesigner.view.paint;

import at.gotzi.karodesigner.KaroDesigner;

import javax.swing.*;
import java.awt.*;

public class PaintPanel extends JPanel {

    private KaroDesigner karoDesigner;
    public PaintPanel(KaroDesigner karoDesigner) {
        this.karoDesigner = karoDesigner;

        setBackground(Color.BLACK);
        setVisible(true);
        setSize(500, 500);
    }


    public void off() {
        KaroDesigner.LOGGER.info("disabled");
        setVisible(false);
    }


    public void on() {
        KaroDesigner.LOGGER.info("enabled");
        setVisible(true);
    }
}
