package calc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import tools.Utilities;
/**
 * Java. Final task: homework
 *
 * @author Sergey Iryupin
 * @version 0.3 dated Nov 27, 2017
 */
class App extends JFrame implements ActionListener {

    final String TITLE_OF_PROGRAM = "Calculator: only division";
    final Rectangle SIZE = new Rectangle(300, 120);
    final String FIRST_NUMBER = "firstNum";
    final String SECOND_NUMBER = "secondNum";
    final String RESULT_NUMBER = "resultNum";
    final String BTN_CALCULATION = "calc";

    JTextField firstNum, secondNum, resultNum;
    Utilities utilities;

    public static void main( String[] args ) {
        new App();
    }

    App() {
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(SIZE);
        // create all components
        firstNum = new JTextField();
        firstNum.setName(FIRST_NUMBER);
        secondNum = new JTextField();
        secondNum.setName(SECOND_NUMBER);
        resultNum = new JTextField();
        resultNum.setName(RESULT_NUMBER);
        resultNum.setEditable(false);
        JButton calc = new JButton(" = ");
        calc.setName(BTN_CALCULATION);
        calc.addActionListener(this);
        // make panel for all JTextFields()
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(firstNum);
        panel.add(secondNum);
        panel.add(resultNum);
        // adding all elements to the window
        add(BorderLayout.CENTER, panel);
        add(BorderLayout.EAST, calc);
        //pack();
        setLocationRelativeTo(null); // to the center
        setVisible(true);
        utilities = new Utilities();
    }

    /**
     * Listener of events from message field and enter button
     */
    public void actionPerformed(ActionEvent event) {
        resultNum.setText(
            utilities.calculate(firstNum.getText(), secondNum.getText()));
    }
}