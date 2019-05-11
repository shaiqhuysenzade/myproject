import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JPanel {
    private JButton numbers[] = new JButton[10];
    private Font font = new Font("SanSerif", Font.BOLD, 20);
    private JTextField output = new JTextField();
    private JButton backspace = new JButton("<"), equ = new JButton("=");
    private JButton plus = new JButton("+"), minus = new JButton("-"), multi = new JButton("*"), div = new JButton("/");

    public Panel() {

        final double[] num1 = new double[2];
        double num2 = 0;
        final String[] op = new String[1];
        setLayout(null);
        setFocusable(true);
        grabFocus();
        equ.setBounds(130, 250, 50, 50);
        equ.setFont(font);
        add(equ);
        plus.setBounds(190, 70, 50, 50);
        plus.setFont(font);
        add(plus);
        minus.setBounds(190, 130, 50, 50);
        minus.setFont(font);
        add(minus);
        multi.setBounds(190, 190, 50, 50);
        multi.setFont(font);
        add(multi);
        div.setBounds(190, 250, 50, 50);
        div.setFont(font);
        add(div);
        backspace.setBounds(10, 250, 50, 50);
        backspace.setFont(font);
        add(backspace);
        numbers[0] = new JButton("0");
        numbers[0].setBounds(70, 250, 50, 50);
        numbers[0].setFont(font);
        add(numbers[0]);
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                numbers[x * 3 + y + 1] = new JButton((x * 3 + y + 1) + "");
                numbers[x * 3 + y + 1].setBounds(x * (50 + 10) + 10, y * (50 + 10) + 70, 50, 50);
                numbers[x * 3 + y + 1].setFont(font);
                add(numbers[x * 3 + y + 1]);
            }
        }
        output.setBounds(10, 10, 230, 50);
        output.setFont(font);
        output.setEditable(false);
        add(output);
        ActionListener l = (ActionEvent e) -> {
            JButton b = (JButton) e.getSource();
            if (b.getText().equals("<")) {
                output.setText("");
            } else if (b.getText().equals("*")) {

                num1[0] = Double.parseDouble(output.getText().toString());
                output.setText("");
                op[0] = "*";

            } else if (b.getText().equals("=")) {
                num1[1] = Double.parseDouble(output.getText().toString());
                double res = 0;
                if (op[0].equals("+")) {
                    res = num1[0] + num1[1];
                }
                if (op[0].equals("*")) {
                    res = num1[0] * num1[1];
                }


                output.setText(String.valueOf(res));

            } else if (b.getText().equals("+")) {
                num1[0] = Double.parseDouble(output.getText().toString());
                output.setText("");
                op[0] = "+";

            }else if(b.getText().equals("-")){
                num1[0]=Double.parseDouble(output.getText());
            }
            else {
                output.setText(output.getText() + b.getText());
            }
        };
        for (JButton b : numbers) {
            b.addActionListener(l);

        }
        backspace.addActionListener(l);
        multi.addActionListener(l);
        equ.addActionListener(l);
        plus.addActionListener(l);
        minus.addActionListener(l);
        div.addActionListener(l);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char symbol = e.getKeyChar();

                if (!Character.isDigit(symbol))
                    return;

                output.setText(output.getText() + symbol);


            }
        });


    }


}
