import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame f;
    JTextField t;
    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    JButton add, sub, mul, div, eq, clr;

    double a = 0, b = 0, result = 0;
    int operator = 0;

    Calculator() {
        f = new JFrame("Calculator");

        t = new JTextField();
        t.setBounds(30, 40, 280, 40);

        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");

        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        eq = new JButton("=");
        clr = new JButton("C");

        b7.setBounds(30, 100, 50, 40);
        b8.setBounds(90, 100, 50, 40);
        b9.setBounds(150, 100, 50, 40);
        add.setBounds(210, 100, 50, 40);

        b4.setBounds(30, 150, 50, 40);
        b5.setBounds(90, 150, 50, 40);
        b6.setBounds(150, 150, 50, 40);
        sub.setBounds(210, 150, 50, 40);

        b1.setBounds(30, 200, 50, 40);
        b2.setBounds(90, 200, 50, 40);
        b3.setBounds(150, 200, 50, 40);
        mul.setBounds(210, 200, 50, 40);

        b0.setBounds(30, 250, 50, 40);
        clr.setBounds(90, 250, 50, 40);
        eq.setBounds(150, 250, 50, 40);
        div.setBounds(210, 250, 50, 40);

        JButton[] buttons = { b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, add, sub, mul, div, eq, clr };
        for (JButton b : buttons) {
            b.addActionListener(this);
            f.add(b);
        }

        f.add(t);
        f.setSize(350, 350);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b0)
            t.setText(t.getText() + "0");
        if (e.getSource() == b1)
            t.setText(t.getText() + "1");
        if (e.getSource() == b2)
            t.setText(t.getText() + "2");
        if (e.getSource() == b3)
            t.setText(t.getText() + "3");
        if (e.getSource() == b4)
            t.setText(t.getText() + "4");
        if (e.getSource() == b5)
            t.setText(t.getText() + "5");
        if (e.getSource() == b6)
            t.setText(t.getText() + "6");
        if (e.getSource() == b7)
            t.setText(t.getText() + "7");
        if (e.getSource() == b8)
            t.setText(t.getText() + "8");
        if (e.getSource() == b9)
            t.setText(t.getText() + "9");

        if (e.getSource() == add) {
            a = Double.parseDouble(t.getText());
            operator = 1;
            t.setText("");
        }

        if (e.getSource() == sub) {
            a = Double.parseDouble(t.getText());
            operator = 2;
            t.setText("");
        }

        if (e.getSource() == mul) {
            a = Double.parseDouble(t.getText());
            operator = 3;
            t.setText("");
        }

        if (e.getSource() == div) {
            a = Double.parseDouble(t.getText());
            operator = 4;
            t.setText("");
        }

        if (e.getSource() == eq) {
            b = Double.parseDouble(t.getText());

            if (operator == 1)
                result = a + b;
            if (operator == 2)
                result = a - b;
            if (operator == 3)
                result = a * b;
            if (operator == 4)
                result = a / b;

            t.setText("" + result);
        }

        if (e.getSource() == clr) {
            t.setText("");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
