package at.gotzi.karodesigner.api;

import java.io.IOException;

public interface Application {

    void start() throws IOException;

    void stop();

}
