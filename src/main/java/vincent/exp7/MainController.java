package vincent.exp7;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    protected void onExitButtonClick() {
        MainApplication.quitApplication();
    }

    @FXML
    public void onMode1ButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("mode_1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
        stage.setTitle("单例模式");
        stage.show();
    }

    @FXML
    public void onMode2ButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("mode_2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
        stage.setTitle("多例模式");
        stage.show();
    }

    @FXML
    public void onMode3ButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("mode_3.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
        stage.setTitle("简单工厂");
        stage.show();
    }

    @FXML
    public void onMode4ButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("mode_4.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
        stage.setTitle("工厂模式");
        stage.show();
    }

    @FXML
    public void onMode5ButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("mode_5.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
        stage.setTitle("抽象工厂");
        stage.show();
    }

    @FXML
    public void onMode6ButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("mode_6.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
        stage.setTitle("类适配器");
        stage.show();
    }

    @FXML
    public void onMode7ButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("mode_7.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
        stage.setTitle("对象适配器");
        stage.show();
    }

    @FXML
    public void onMode8ButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("mode_8.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
        stage.setTitle("组合模式");
        stage.show();
    }
}