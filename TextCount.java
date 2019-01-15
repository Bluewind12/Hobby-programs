import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TextCount extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        TextArea label = new TextArea("Hello JavaFX!");
        label.textProperty().addListener((obs, old, niu) -> {
            String data = label.getText().replace(" ", "");
            data = data.replace("\t", "");
            data = data.replace("\n", "");
            data = data.replace("@", "");

            String value = "•¶š”" + data.length();
            stage.setTitle(value);
        });
        label.setWrapText(true);
        BorderPane pane = new BorderPane();
        pane.setCenter(label);
        Scene scene = new Scene(pane, 320, 240);
        stage.setScene(scene);
        stage.show();
    }
}