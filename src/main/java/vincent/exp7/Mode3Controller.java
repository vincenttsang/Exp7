package vincent.exp7;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.OutputStream;
import java.io.PrintStream;

public class Mode3Controller {
    @FXML
    TextArea console;

    public Mode3Controller() {
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
        System.out.println("开始测试简单工厂...");
        SimpleFactory factory = new SimpleFactory();
        Meat meat1 = factory.produceMeat(Meat.TYPE.BEEF);
        System.out.printf("%s: %s\n", meat1, meat1.getType());
        Meat meat2 = factory.produceMeat(Meat.TYPE.PORK);
        System.out.printf("%s: %s\n", meat2, meat2.getType());
        Meat meat3 = factory.produceMeat(Meat.TYPE.CHICKEN);
        System.out.printf("%s: %s\n", meat3, meat3.getType());
    }

    @FXML
    public void clearConsole(ActionEvent actionEvent) {
        console.clear();
    }
}

class SimpleFactory {
    SimpleFactory() {
    }

    public Meat produceMeat(Meat.TYPE type) {
        Meat meat = new Meat(type);
        System.out.println("生产了" + meat.getType().name() + "类");
        return meat;
    }
}

class Meat {
    Meat.TYPE type;

    Meat(Meat.TYPE type) {
        this.type = type;
    }

    public Meat.TYPE getType() {
        return type;
    }

    enum TYPE {
        BEEF, PORK, CHICKEN
    }
}
