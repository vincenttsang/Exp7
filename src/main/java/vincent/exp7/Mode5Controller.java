package vincent.exp7;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.OutputStream;
import java.io.PrintStream;

interface Meat5 {
    void showMeat();

    enum TYPE {
        BEEF, PORK, CHICKEN
    }
}

public class Mode5Controller {
    @FXML
    TextArea console;

    public Mode5Controller() {
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
        System.out.println("开始测试抽象工厂...");
        AbstractFactory factory1 = new WensFactory();
        AbstractFactory factory2 = new TianBangFactory();
        AbstractFactory factory3 = new AoNongFactory();
        Meat5 meat1 = factory1.produceMeat(Meat5.TYPE.CHICKEN);
        Meat5 meat2 = factory1.produceMeat(Meat5.TYPE.PORK);
        Meat5 meat3 = factory2.produceMeat(Meat5.TYPE.BEEF);
        Meat5 meat4 = factory2.produceMeat(Meat5.TYPE.PORK);
        Meat5 meat5 = factory3.produceMeat(Meat5.TYPE.CHICKEN);
        Meat5 meat6 = factory3.produceMeat(Meat5.TYPE.BEEF);
        meat1.showMeat();
        meat2.showMeat();
        meat3.showMeat();
        meat4.showMeat();
        meat5.showMeat();
        meat6.showMeat();
    }

    @FXML
    public void clearConsole(ActionEvent actionEvent) {
        console.clear();
    }
}

abstract class AbstractFactory {
    AbstractFactory() {
        System.out.println(this + ": 已创建工厂");
    }

    public abstract Meat5 produceMeat(Meat5.TYPE type);
}

class AoNongFactory extends AbstractFactory {
    @Override
    public Meat5 produceMeat(Meat5.TYPE type) {
        switch (type) {
            case BEEF -> {
                return new Beef();
            }
            case PORK -> {
                return new Pork();
            }
            case CHICKEN -> {
                return new Chicken();
            }
            default -> {
                return null;
            }
        }
    }
}

class TianBangFactory extends AbstractFactory {
    @Override
    public Meat5 produceMeat(Meat5.TYPE type) {
        switch (type) {
            case BEEF -> {
                return new Beef();
            }
            case PORK -> {
                return new Pork();
            }
            case CHICKEN -> {
                return new Chicken();
            }
            default -> {
                return null;
            }
        }
    }
}

class WensFactory extends AbstractFactory {
    @Override
    public Meat5 produceMeat(Meat5.TYPE type) {
        switch (type) {
            case BEEF -> {
                return new Beef();
            }
            case PORK -> {
                return new Pork();
            }
            case CHICKEN -> {
                return new Chicken();
            }
            default -> {
                return null;
            }
        }
    }
}

class Beef implements Meat5 {
    @Override
    public void showMeat() {
        System.out.printf("%s: %s\n", this, "牛肉");
    }
}

class Chicken implements Meat5 {
    @Override
    public void showMeat() {
        System.out.printf("%s: %s\n", this, "鸡肉");
    }
}

class Pork implements Meat5 {
    @Override
    public void showMeat() {
        System.out.printf("%s: %s\n", this, "猪肉");
    }
}
