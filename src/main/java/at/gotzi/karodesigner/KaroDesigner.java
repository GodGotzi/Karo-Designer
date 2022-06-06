package at.gotzi.karodesigner;

import at.gotzi.karodesigner.api.Application;
import at.gotzi.karodesigner.api.Model;
import at.gotzi.karodesigner.builder.MenuBarBuilder;
import at.gotzi.karodesigner.view.menubar.GMenuBar;
import at.gotzi.karodesigner.data.ModelLoader;
import at.gotzi.karodesigner.render.Window;
import at.gotzi.karodesigner.utils.Helper;
import at.gotzi.karodesigner.view.paint.PaintPanel;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.*;


public class KaroDesigner implements Application {

    public static Logger LOGGER;

    private GMenuBar menuBar;
    private PaintPanel paintPanel;
    private List<Model> models;

    public KaroDesigner() {
        LOGGER = Logger.getLogger("main-logger");

        this.loadModels();

        this.buildMenuBar();
        this.buildPaintPanel();
    }

    /**
     * It creates a new window, sets the size, centers it on the screen, maximizes it, and removes the title bar
     */
    @Override
    public void start() {
        Dimension dimension = new Dimension(1200, 675);
        Window window = new Window("Karo-Designer");

        window.setResizeable(true);
        window.setVisible(true);
        window.setMenuBar(menuBar);
        window.getPanel().add(paintPanel);

        window.getPanel().setBackground(Color.DARK_GRAY);
        window.getFrame().setSize(dimension);
        window.centerOnScreen();

        window.getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon imageIcon = new ImageIcon("resource/logo.png");
        window.getFrame().setIconImage(imageIcon.getImage());

        window.start();
    }

    /**
     * Build the menu bar and store it in the menuBar variable.
     */
    private void buildMenuBar() {
        MenuBarBuilder menuBarBuilder = new MenuBarBuilder(this);
        menuBarBuilder.build();
        this.menuBar = menuBarBuilder.getResult();
    }

    private void buildPaintPanel() {
        this.paintPanel = new PaintPanel(this);
    }

    /**
     * It loads the models from the `models` folder
     */
    private void loadModels() {
        ModelLoader modelLoader = new ModelLoader("models");
        List<Model> models = modelLoader.getResult();
        if (models == null) {
            Helper.showErrorMessage("Cannot load models correctly!");
            this.models = new LinkedList<>();
        } else this.models = models;
    }

    @Override
    public void stop() {

    }

    public GMenuBar getMenuBar() {
        return menuBar;
    }

    public PaintPanel getPaintPanel() {
        return paintPanel;
    }

    public List<Model> getModels() {
        return models;
    }
}