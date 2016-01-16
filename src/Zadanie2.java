
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Zadanie2 extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenuItem itemExit;
    private JTextField tParam1, tParam2, tResult;
    private JLabel lParam1, lParam2, lOperation, lResult, lEquals;
    private JButton bSolve;
    private ButtonGroup buttonGroup;
    private JRadioButton rbAdd, rbSub, rbMulti, rbDiv;

    public Zadanie2() {
        setBounds(500, 100, 800, 800);
        setTitle("Zadanie2");
        setLayout(null);
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuFile = new JMenu("File");
        menuBar.add(menuFile);
        itemExit = new JMenuItem("Exit");
        menuFile.add(itemExit);
        itemExit.addActionListener(this);

        tParam1 = new JTextField();
        tParam1.setBounds(200, 100, 70, 40);
        add(tParam1);

        tParam2 = new JTextField();
        tParam2.setBounds(350, 100, 70, 40);
        add(tParam2);

        tResult = new JTextField();
        tResult.setBounds(485, 100, 70, 40);
        add(tResult);

        lParam1 = new JLabel("Parametr a");
        lParam1.setBounds(200, 65, 70, 40);
        add(lParam1);

        lParam2 = new JLabel("Parametr b");
        lParam2.setBounds(350, 65, 70, 40);
        add(lParam2);

        lOperation = new JLabel("+");
        lOperation.setBounds(305, 100, 70, 40);
        add(lOperation);

        lEquals = new JLabel("=");
        lEquals.setBounds(450, 100, 70, 40);
        add(lEquals);

        lResult = new JLabel("Wynik");
        lResult.setBounds(500, 65, 70, 40);
        add(lResult);

        bSolve = new JButton("Oblicz");
        bSolve.setBounds(600, 100, 70, 40);
        add(bSolve);
        bSolve.addActionListener(this);

        buttonGroup = new ButtonGroup();
        rbAdd = new JRadioButton("+", true);
        rbAdd.setBounds(300, 150, 70, 20);
        buttonGroup.add(rbAdd);
        add(rbAdd);
        rbAdd.addActionListener(this);

        rbSub = new JRadioButton("-", false);
        rbSub.setBounds(300, 170, 70, 20);
        buttonGroup.add(rbSub);
        add(rbSub);
        rbSub.addActionListener(this);

        rbMulti = new JRadioButton("*", false);
        rbMulti.setBounds(300, 190, 70, 20);
        buttonGroup.add(rbMulti);
        add(rbMulti);
        rbMulti.addActionListener(this);

        rbDiv = new JRadioButton("/", false);
        rbDiv.setBounds(300, 210, 70, 20);
        buttonGroup.add(rbDiv);
        add(rbDiv);
        rbDiv.addActionListener(this);

    }

    public static void main(String[] args) {
        Zadanie2 okno = new Zadanie2();
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == itemExit) {
            dispose();
        } else if (source == rbAdd) {
            lOperation.setText("+");
        } else if (source == rbSub) {
            lOperation.setText("-");
        } else if (source == rbMulti) {
            lOperation.setText("*");
        } else if (source == rbDiv) {
            lOperation.setText("/");
        } else if (source == bSolve) {
            try {
                double a = Double.parseDouble(tParam1.getText());
                double b = Double.parseDouble(tParam2.getText());
                if (lOperation.getText().equals("+")) {
                    tResult.setText(Double.toString(a + b));
                } else if (lOperation.getText().equals("-")) {
                    tResult.setText(Double.toString(a - b));
                } else if (lOperation.getText().equals("*")) {
                    tResult.setText(Double.toString(a * b));
                } else {
                    tResult.setText(Double.toString(a / b));
                }
            } catch (Exception ee) {
                tResult.setText("Błąd");
            }

        }

    }

}
