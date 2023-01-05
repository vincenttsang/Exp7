package vincent.exp7;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Mode1Controller {

    @FXML
    TextArea console;

    public Mode1Controller() {
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

    private void singleton() {
        Goalkeeper goalkeeper = Goalkeeper.getSingleton("守门员1");
        Goalkeeper otherGoalkeeper = Goalkeeper.getSingleton("守门员2");
//        测试单例的功能是否正确
        if (goalkeeper == otherGoalkeeper) {
            System.out.println("两次创建的守门员其实是一个守门员，" + goalkeeper.getName());
        } else {
            System.out.println("两次创建的守门员分别是：" + goalkeeper.getName() + "第二个守门员是" + otherGoalkeeper.getName());
        }


//       多例测试
        List<Footballer> footballers;
        footballers = Footballer.addFootballer("球员1");
        footballers = Footballer.addFootballer("球员2");
        footballers = Footballer.addFootballer("球员3");
        footballers = Footballer.addFootballer("球员4");
        footballers = Footballer.addFootballer("球员5");
        footballers = Footballer.addFootballer("球员6");
        footballers = Footballer.addFootballer("球员7");
        footballers = Footballer.addFootballer("球员8");
        footballers = Footballer.addFootballer("球员9");
        footballers = Footballer.addFootballer("球员10");
        footballers = Footballer.addFootballer("球员11");
        footballers = Footballer.addFootballer("球员12");

//       输出所有的球员，
        System.out.println("当前球员的数量是：" + footballers.size());
        for (Footballer footballer : footballers) {
            System.out.println(footballer.getName());
        }
    }

    @FXML
    public void start(ActionEvent actionEvent) {
        System.out.println("开始测试单例模式...");
        singleton();
    }

    @FXML
    public void clearConsole(ActionEvent actionEvent) {
        console.clear();
    }
}

class Footballer {
    private static final List<Footballer> footballers = new ArrayList<>();
    private static final int quantity = 10;
    private String name;

    private Footballer() {

    }

    public static List<Footballer> addFootballer(String name) {
        if (footballers.size() < quantity) {
            Footballer footballer = new Footballer();
            footballer.setName(name);
            footballers.add(footballer);
            System.out.println("添加的球员是：" + name);
        } else {
            System.out.println("已经创建了10个球员，不能再添加新的球员了：" + name);
        }
        return footballers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Goalkeeper {
    private static Goalkeeper goalkeeper;
    private String name;

    private Goalkeeper() {

    }

    public static Goalkeeper getSingleton(String name) {
        if (goalkeeper == null) {
            goalkeeper = new Goalkeeper();
            goalkeeper.setName(name);
            System.out.println("创建单例：" + name);
        } else {
            System.out.println("已经创建了守门员：" + goalkeeper.getName() + "，不能创建守门员" + name);
        }
        return goalkeeper;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}