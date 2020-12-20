import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* AL.java - place for all ActionListeners, where calculation takes place. */

class AL_pythagoras implements ActionListener {
    private JFrame pythagoras_frame = new JFrame();
    private JLabel prompt = new JLabel("请输入两个勾股数："), res = new JLabel(" ");
    private JTextField numAField = new JTextField(3), numBField = new JTextField(3);
    private JButton computeButton1 = new JButton(), computeButton2 = new JButton();

    public void actionPerformed(ActionEvent e) {
        new setFrame(pythagoras_frame, "计算勾股数", 300, 120);
        computeButton1.setText("计算直角边");
        computeButton2.setText("计算斜边");

        class AL_pythagoras_calc1 implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                Double a, b, ans;
                try {
                    a = Double.parseDouble(numAField.getText());
                    b = Double.parseDouble(numBField.getText());
                    if (a > b) ans = Math.sqrt(a * a - b * b);
                    else ans = Math.sqrt(b * b - a * a);
                    JOptionPane.showMessageDialog(null, "直角边长: " + ans, "结果", JOptionPane.INFORMATION_MESSAGE, null);
                } catch (Exception ignored) {
                }
            }
        }
        class AL_pythagoras_calc2 implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                Double a, b;
                try {
                    a = Double.parseDouble(numAField.getText());
                    b = Double.parseDouble(numBField.getText());
                    JOptionPane.showMessageDialog(null, "斜边长: " + Math.sqrt(a * a + b * b), "结果", JOptionPane.INFORMATION_MESSAGE, null);
                } catch (Exception ignored) {
                }

            }
        }
        computeButton1.addActionListener(new AL_pythagoras_calc1());
        computeButton2.addActionListener(new AL_pythagoras_calc2());
        pythagoras_frame.add(prompt);
        pythagoras_frame.add(numAField);
        pythagoras_frame.add(numBField);
        pythagoras_frame.add(computeButton1);
        pythagoras_frame.add(computeButton2);
        pythagoras_frame.add(res);
        pythagoras_frame.pack();
    }
}

class AL_digit2root implements ActionListener {
    private JFrame digit2root_frame = new JFrame();
    private JLabel prompt = new JLabel("请输入要转为开方数的数：");
    private JTextField numField = new JTextField(3);
    private JButton computeButton = new JButton();

    public void actionPerformed(ActionEvent e) {
        new setFrame(digit2root_frame, "小数转为根号表示", 300, 60);
        computeButton.setText("转换");
        computeButton.addActionListener(new AL_digit2root_calc());
        digit2root_frame.add(prompt);
        digit2root_frame.add(numField);
        digit2root_frame.add(computeButton);

    }

    class AL_digit2root_calc implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double num, tmp, sqr;
            final double eps = 0.01;
            try {
                num = Double.parseDouble(numField.getText());
                tmp = Math.pow(num, 2);

                sqr = (long) (tmp);
                if (Math.abs(sqr - tmp) > 0.5) sqr++;
                tmp = Math.sqrt(sqr);
                if (Math.abs(num - tmp) < eps) {
                    JOptionPane.showMessageDialog(null, "转换成功. " + num + " = √" + sqr, "结果", JOptionPane.INFORMATION_MESSAGE, null);
                } else {
                    JOptionPane.showMessageDialog(null, "转换失败", "结果", JOptionPane.INFORMATION_MESSAGE, null);
                }
            } catch (Exception ignored) {
            }
        }
    }
}

class AL_quadratic implements ActionListener {
    private JFrame quadratic_frame = new JFrame();
    private JLabel prompt = new JLabel("请输入方程每项的系数： "), item1 = new JLabel("x^2"), item2 = new JLabel("x"), item3 = new JLabel("= 0");
    private JTextField numField1 = new JTextField(3), numField2 = new JTextField(3), numField3 = new JTextField(3);
    private JButton computeButton = new JButton(), switch1 = new JButton(), switch2 = new JButton();
    private Dimension switchSize = new Dimension(20, 20);

    public void actionPerformed(ActionEvent e) {
        new setFrame(quadratic_frame, "求解一元二次方程", 800, 60);
        computeButton.setText("计算");
        computeButton.addActionListener(new AL_quadratic_calc());
        switch1.setPreferredSize(switchSize);
        switch2.setPreferredSize(switchSize);
        switch1.setText("+");
        switch2.setText("+");
        switch1.addActionListener(new AL_quadratic_switch1());
        switch2.addActionListener(new AL_quadratic_switch2());
        quadratic_frame.add(prompt);
        quadratic_frame.add(numField1);
        quadratic_frame.add(item1);
        quadratic_frame.add(switch1);
        quadratic_frame.add(numField2);
        quadratic_frame.add(item2);
        quadratic_frame.add(switch2);
        quadratic_frame.add(numField3);
        quadratic_frame.add(item3);
        quadratic_frame.add(computeButton);
        quadratic_frame.pack();
    }

    class AL_quadratic_switch1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String a = switch1.getText();
            if (a.equals("+")) switch1.setText("-");
            else if (a.equals("-")) switch1.setText("+");
        }
    }

    class AL_quadratic_switch2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String b = switch2.getText();
            if (b.equals("+")) switch2.setText("-");
            if (b.equals("-")) switch2.setText("+");
        }
    }
    class AL_quadratic_calc implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Double a = Double.parseDouble(numField1.getText()), b = Double.parseDouble(numField2.getText()), c = Double.parseDouble(numField3.getText());
                if (switch1.getText().equals("-")) b = -b;
                if (switch2.getText().equals("-")) c = -c;
                double delta = Math.pow(b, 2) - 4 * a * c;
                double ans1 = ((-b) + Math.sqrt(delta)) / 2 * a;
                if (delta > 0) {
                    double ans2 = ((-b) - Math.sqrt(delta)) / 2 * a;
                    JOptionPane.showMessageDialog(null, "x1 = " + ans1 + ", x2 = " + ans2, "结果", JOptionPane.INFORMATION_MESSAGE, null);
                } else if (delta == 0) {
                    JOptionPane.showMessageDialog(null, "x = " + ans1, "结果", JOptionPane.INFORMATION_MESSAGE, null);
                } else {
                    JOptionPane.showMessageDialog(null, "无解", "结果", JOptionPane.INFORMATION_MESSAGE, null);
                }
            } catch (Exception ignored) {
            }
        }
    }
}