import java.awt.*;
import java.awt.event.*;

class Calculator extends Frame implements ActionListener {

    TextField display;
    Button btn0, btn1, btn2, btn3, btn4,
            btn5, btn6, btn7, btn8, btn9,
            btnAdd, btnSub, btnMul, btnDiv, btnEq, btnClr;

    Calculator() {

        display = new TextField("0");
        display.setEditable(false);

        btn0 = new Button("0");
        btn1 = new Button("1");
        btn2 = new Button("2");
        btn3 = new Button("3");
        btn4 = new Button("4");
        btn5 = new Button("5");
        btn6 = new Button("6");
        btn7 = new Button("7");
        btn8 = new Button("8");
        btn9 = new Button("9");

        btnAdd = new Button("+");
        btnSub = new Button("-");
        btnMul = new Button("*");
        btnDiv = new Button("/");
        btnEq  = new Button("=");
        btnClr = new Button("C");

        // add listeners
        Button[] buttons = { btn0, btn1, btn2, btn3, btn4, btn5, btn6,
                btn7, btn8, btn9, btnAdd, btnSub,
                btnMul, btnDiv, btnEq, btnClr };

        for (Button b : buttons)
            b.addActionListener(this);

        setLayout(new BorderLayout());

        Panel p = new Panel(new GridLayout(4, 4, 10, 10));

        p.add(btn7); p.add(btn8); p.add(btn9); p.add(btnDiv);
        p.add(btn4); p.add(btn5); p.add(btn6); p.add(btnMul);
        p.add(btn1); p.add(btn2); p.add(btn3); p.add(btnSub);
        p.add(btn0); p.add(btnClr); p.add(btnEq); p.add(btnAdd);

        add(display, BorderLayout.NORTH);
        add(p, BorderLayout.CENTER);

        setSize(300, 400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String cmd = e.getActionCommand();
        String text = display.getText();

        // Clear
        if (e.getSource() == btnClr) {
            display.setText("0");
            return;
        }

        // Numbers
        if (cmd.charAt(0) >= '0' && cmd.charAt(0) <= '9') {
            if (text.equals("0"))
                display.setText(cmd);
            else
                display.setText(text + cmd);
            return;
        }

        // Operators
        if (cmd.equals("+") || cmd.equals("-") ||
                cmd.equals("*") || cmd.equals("/")) {
            display.setText(text + cmd);
            return;
        }

        // Equals
        if (e.getSource() == btnEq) {

            double result = 0;
            String exp = display.getText();

            if (exp.contains("+")) {
                String[] parts = exp.split("\\+");
                result = Double.parseDouble(parts[0]) + Double.parseDouble(parts[1]);
            } else if (exp.contains("-")) {
                String[] parts = exp.split("-");
                result = Double.parseDouble(parts[0]) - Double.parseDouble(parts[1]);
            } else if (exp.contains("*")) {
                String[] parts = exp.split("\\*");
                result = Double.parseDouble(parts[0]) * Double.parseDouble(parts[1]);
            } else if (exp.contains("/")) {
                String[] parts = exp.split("/");
                result = Double.parseDouble(parts[0]) / Double.parseDouble(parts[1]);
            }

            display.setText(String.valueOf(result));
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}


/*
* Button click happens (runtime)
* When you click a button:
* Button detects mouse click
* Button looks at its listener list
* It finds: Calculator object

Java automatically calls:

calculator.actionPerformed(event);

* You did NOT call this method
* Java’s event system did it for you
* */