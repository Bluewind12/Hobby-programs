import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.*;
import javafx.stage.*;

/**
 * DotChange8x8
 */
public class DotChange8x8 extends Application {
    ToggleButton[][] toggle = {
            { new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" "),
                    new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" ") },
            { new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" "),
                    new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" ") },
            { new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" "),
                    new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" ") },
            { new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" "),
                    new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" ") },
            { new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" "),
                    new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" ") },
            { new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" "),
                    new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" ") },
            { new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" "),
                    new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" ") },
            { new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" "),
                    new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" "), new ToggleButton(" ") } };
    TextField textField = new TextField();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                toggle[i][j].setOnAction(event -> {
                    this.favoriteOnAction(event);
                });
                gridPane.add(toggle[i][j], i, j);
            }
        }

        BorderPane pane = new BorderPane();
        pane.setCenter(gridPane);
        pane.setBottom(textField);
        Scene scene = new Scene(pane, 560, 400);
        stage.setScene(scene);
        stage.show();
    }

    public void favoriteOnAction(ActionEvent event) {
        ToggleButton favorite = (ToggleButton) event.getSource();

        if (favorite.isSelected()) {
            favorite.setStyle("-fx-base: #FF5555");
        } else {
            favorite.setStyle("-fx-base: #f2f2f2");
        }

        int c = 1;
        int[] count = { 0, 0, 0, 0, 0, 0, 0, 0 };
        for (int i = 0; i < 8; i++) {
            c = 1;
            for (int j = 7; j >= 0; j--) {
                if (toggle[j][i].isSelected()) {
                    count[i] += c;
                }
                c *= 2;
            }
        }

        textField.setText("{0x" + Integer.toHexString(count[0]) + ",0x" + Integer.toHexString(count[1]) + ",0x"
                + Integer.toHexString(count[2]) + ",0x" + Integer.toHexString(count[3]) + ",0x"
                + Integer.toHexString(count[4]) + ",0x" + Integer.toHexString(count[5]) + ",0x"
                + Integer.toHexString(count[6]) + ",0x" + Integer.toHexString(count[7]) + "},");
    }
}