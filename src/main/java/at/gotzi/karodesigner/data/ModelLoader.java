package at.gotzi.karodesigner.data;

import at.gotzi.karodesigner.api.Model;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ModelLoader extends ILoader<List<Model>> {

    private final File folder;

    public ModelLoader(File folder) {
        this.folder = folder;
    }

    public ModelLoader(String folder) {
        this(new File(folder));
    }

    @Override
    public List<Model> getResult() {
        List<Model> models = new LinkedList<>();

        File[] modelFiles = folder.listFiles();
        if (modelFiles == null || modelFiles.length == 0) return null;

        Arrays.stream(modelFiles).forEach(file -> {
            Model model = loadModel(file.getName());
            models.add(model);
        });

        return models;
    }

    private Model loadModel(String fileName) {
        return new Model(fileName.split("\\.")[0]);
    }

}
