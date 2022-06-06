package at.gotzi.karodesigner.api;

public class Model {

    private String id;

    public Model(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
}