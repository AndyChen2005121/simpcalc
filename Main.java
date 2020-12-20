import javax.swing.*;
import java.awt.*;

/* SimpCalc - Java GUI Math Toolbox for junior high students. */



public class Main {

    private JFrame mainframe = new JFrame();
    private JButton pythagoras = new JButton(), digit2root = new JButton(), quadratic = new JButton();
    public Main() {
        mainframe.setLayout(new GridLayout());
        mainframe.setVisible(true);
        mainframe.setTitle("SimpCalc v0.3.1");
        mainframe.setResizable(false);
        mainframe.setLocationRelativeTo(null);
        mainframe.setSize(new Dimension(400, 180));

        pythagoras.setText("求勾股数");
        pythagoras.addActionListener(new AL_pythagoras());
        digit2root.setText("小数转为根号表示");
        digit2root.addActionListener(new AL_digit2root());
        quadratic.setText("求解一元二次方程");
        quadratic.addActionListener(new AL_quadratic());
        mainframe.add(pythagoras);
        mainframe.add(digit2root);
        mainframe.add(quadratic);
        mainframe.pack();
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Main();
    }

}
