package vincent.exp7;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Mode2Controller {
    @FXML
    TextArea console;

    public Mode2Controller() {
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
                String text = String.valueOf((char) b);

                Platform.runLater(() -> {
                    console.appendText(text);
                });
            }

            @Override
            public void write(byte[] b, int off, int len) {
                String s = new String(b, off, len);
                Platform.runLater(() -> console.appendText(s));
            }
        }, true));
        System.setErr(System.out);
    }

    @FXML
    public void start(ActionEvent actionEvent) {
        Multiton multiton = new Multiton();
        multiton.init();
        System.out.println("开始测试多例模式...");
        for (int i = 0; i < 5; i++) {
            System.out.printf("这是第%d个实例: %s\n", i + 1, multiton.getInstance(i));
        }
    }

    @FXML
    public void clearConsole(ActionEvent actionEvent) {
        console.clear();
    }
}

class Multiton {
    // 定义该类被创建的总数量
    private final int maxCount = 5;
    private final List<Multiton> instanceList = new ArrayList<>();

    public void init() {
        for (int i = 0; i < maxCount; i++) {
            Multiton multiton = new Multiton();
            instanceList.add(multiton);
        }
    }

    public Multiton getInstance(int i) {
        return instanceList.get(i);
    }
}
