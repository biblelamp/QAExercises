package calc;

/**
 * Java. Final task: homework
 *
 * @author Sergey Iryupin
 * @version 0.2 dated Nov 26, 2017
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import tools.Utilities;

class App extends JFrame implements ActionListener {

    final String TITLE_OF_PROGRAM = "Calculator: only division";
    final Rectangle SIZE = new Rectangle(300, 120);
    JTextField firstNum, secondNum, resultNum;
    Utilities util;

    public static void main( String[] args ) {
        new App();
    }

    App() {
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(SIZE);
        // create all components
        firstNum = new JTextField();
        secondNum = new JTextField();
        resultNum = new JTextField();
        resultNum.setEditable(false);
        JButton calc = new JButton(" = ");
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
        util = new Utilities();
    }

    /**
     * Listener of events from message field and enter button
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        resultNum.setText(
            util.calculate(firstNum.getText(), secondNum.getText()));
    }
}