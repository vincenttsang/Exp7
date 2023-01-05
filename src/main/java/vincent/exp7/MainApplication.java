package vincent.exp7;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class MainApplication extends Application {
    public static void quitApplication() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("退出");
        alert.setHeaderText("您是否要退出程序");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Platform.exit();
        }
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("软件体系结构综合性实验");
        stage.setScene(scene);
        stage.setOnCloseRequest(event -> {
            event.consume();
            quitApplication();
        });
        stage.show();
    }
}