package vincent.exp7;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

interface SortUtil {
    List sortInt(List<Integer> intList);

    List sortStudent(List<Student> studentList);
}

public class Mode6Controller {
    @FXML
    TextArea console;

    public Mode6Controller() {
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
        System.out.println("开始测试类适配器...");

        Student stu0 = new Student("b", 114514);
        Student stu1 = new Student("a", 1919);
        Student stu2 = new Student("c", 810);
        Student stu3 = new Student("d", 1919810);

        SortUtil sortUtil = new ClassAdapter();
        System.out.println(sortUtil);
        List<Student> studentList = new ArrayList<>();
        studentList.add(stu0);
        studentList.add(stu1);
        studentList.add(stu2);
        studentList.add(stu3);
        for (Student s : studentList) {
            System.out.println(s);
        }
        List<Integer> result = sortUtil.sortStudent(studentList);
        System.out.println("排序完成");
        for (int i : result) {
            System.out.println(i);
        }
    }

    @FXML
    public void clearConsole(ActionEvent actionEvent) {
        console.clear();
    }
}

class Student {
    public String name;
    public int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "本Student对象HashCode为" + this.hashCode() + ", 姓名为" + this.name + ", 学号为" + this.id;
    }
}

class SortString {
    public List sortName(List<String> nameList) {
        Collections.sort(nameList);
        return nameList;
    }
}

class ClassAdapter extends SortString implements SortUtil {

    @Override
    public List sortInt(List<Integer> intList) {
        Collections.sort(intList); //升序排序
        return intList;
    }

    @Override
    public List sortStudent(List<Student> studentList) {
        List<Integer> s = new ArrayList<>();
        for (Student stu : studentList) {
            int i = stu.name.getBytes(StandardCharsets.UTF_8)[0];
            s.add(i);
        }
        s = sortInt(s);
        return s;
    }
}