package vincent.exp7;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.OutputStream;
import java.io.PrintStream;

public class Mode4Controller {
    @FXML
    TextArea console;

    public Mode4Controller() {
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
        System.out.println("开始测试工厂模式...");
        PorkMeatFactory porkMeatFactory = new PorkMeatFactory();
        BeefMeatFactory beefMeatFactory = new BeefMeatFactory();
        ChickenMeatFactory chickenMeatFactory = new ChickenMeatFactory();
        Meat meat1 = porkMeatFactory.producePork();
        System.out.printf("%s: %s\n", meat1, meat1.getType());
        Meat meat2 = beefMeatFactory.produceBeef();
        System.out.printf("%s: %s\n", meat2, meat2.getType());
        Meat meat3 = chickenMeatFactory.produceChicken();
        System.out.printf("%s: %s\n", meat3, meat3.getType());

    }

    @FXML
    public void clearConsole(ActionEvent actionEvent) {
        console.clear();
    }
}

class BeefMeatFactory {
    BeefMeatFactory() {
        System.out.println("新建牛肉生产厂");
    }

    public Meat produceBeef() {
        Meat meat = new Meat(Meat.TYPE.BEEF);
        System.out.println("生产了牛肉");
        return meat;
    }
}

class ChickenMeatFactory {
    ChickenMeatFactory() {
        System.out.println("新建鸡肉生产厂");
    }

    public Meat produceChicken() {
        Meat meat = new Meat(Meat.TYPE.CHICKEN);
        System.out.println("生产了鸡肉");
        return meat;
    }
}

class PorkMeatFactory {
    PorkMeatFactory() {
        System.out.println("新建猪肉生产厂");
    }

    public Meat producePork() {
        Meat meat = new Meat(Meat.TYPE.PORK);
        System.out.println("生产了猪肉");
        return meat;
    }
}