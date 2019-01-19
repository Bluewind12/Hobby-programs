import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import java.io.File;
import java.util.List;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class TextCount extends Application {
    boolean cntFrag = false;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("文字数：0文字");
        TextArea label = new TextArea("");
        label.textProperty().addListener((obs, old, niu) -> {
            String data = label.getText().replace(" ", "");
            data = data.replace("\t", "");
            data = data.replace("\n", "");
            data = data.replace("　", "");
            String value = "文字数：" + data.length() + "文字";
            stage.setTitle(value);
        });
        label.setWrapText(true);

        label.setOnMouseClicked(e -> {
            String data = label.getSelectedText();
            data = data.replace("\t", "");
            data = data.replace("\n", "");
            data = data.replace("　", "");
            String value = "選択範囲文字数：" + data.length() + "文字";
            stage.setTitle(value);
        });

        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("ファイル");
        MenuItem open = new MenuItem("開く");
        MenuItem save = new MenuItem("保存");

        open.addEventHandler(ActionEvent.ACTION, e -> {
            openFile(stage, label);
        });

        save.addEventHandler(ActionEvent.ACTION, e -> {
            saveFile(stage, label);
        });
        menuFile.getItems().addAll(open, save);
        menuBar.getMenus().addAll(menuFile);
        BorderPane pane = new BorderPane();
        pane.setCenter(label);
        pane.setTop(menuBar);
        Scene scene = new Scene(pane, 560, 400);
        scene.setOnKeyPressed(e -> press(e, stage, label));
        scene.setOnKeyReleased(e -> release(e));
        stage.setScene(scene);
        stage.show();
    }

    void press(KeyEvent event, Stage stage, TextArea label) {
        if (event.getCode() == KeyCode.CONTROL) {
            cntFrag = true;
        }
        if (event.getCode() == KeyCode.S && cntFrag) {
            saveFile(stage, label);
        }
        if (event.getCode() == KeyCode.O && cntFrag) {
            openFile(stage, label);
        }
    }

    void release(KeyEvent event) {
        if (event.getCode() == KeyCode.CONTROL) {
            cntFrag = false;
        }
    }

    void openFile(Stage stage, TextArea label) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("展開ファイル選択");
        fileChooser.setInitialDirectory(new File("../"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("テキストファイル", "*.txt"));
        File file = fileChooser.showOpenDialog(stage);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String buff;
            String str = "";
            while ((buff = br.readLine()) != null) {
                if (str != "") {
                    str += "\n";
                }
                str += buff;
                str += "";
            }
            label.setText(str);
            br.close();
        } catch (Exception ex) {
        }
        String data = label.getText().replace(" ", "");
        data = data.replace("\t", "");
        data = data.replace("\n", "");
        data = data.replace("　", "");
        String value = "文字数：" + data.length() + "文字";
        stage.setTitle(value);
    }

    void saveFile(Stage stage, TextArea label) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("保存先ファイル選択");
        fileChooser.setInitialDirectory(new File("../"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("テキストファイル", "*.txt"));
        File file = fileChooser.showOpenDialog(stage);
        try {
            FileWriter filewriter = new FileWriter(file);
            filewriter.write(label.getText().toString());
            filewriter.close();
        } catch (Exception ex) {
        }
    }
}