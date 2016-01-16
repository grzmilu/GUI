
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Zadanie1 extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenuItem itemExit;
    private JButton bShowName;
    private JLabel lShowName, lChangeName;
    private String name = "";
    private JTextField tGetName;

    public Zadanie1() {

        setBounds(500, 100, 800, 800);
        setTitle("Zadanie1");
        setLayout(null);
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuFile = new JMenu("File");
        menuBar.add(menuFile);
        itemExit = new JMenuItem("Exit");
        menuFile.add(itemExit);
        itemExit.addActionListener(this);

        name = JOptionPane.showInputDialog("Podaj imie");

        bShowName = new JButton("Pokaz powitanie");
        bShowName.setBounds(150, 100, 150, 50);
        add(bShowName);
        bShowName.addActionListener(this);

        lShowName = new JLabel();
        lShowName.setBounds(150, 150, 150, 50);
        add(lShowName);

        lChangeName = new JLabel("Zmien imie");
        lChangeName.setBounds(350, 100, 100, 50);
        add(lChangeName);

        tGetName = new JTextField();
        tGetName.setBounds(450, 115, 150, 20);
        tGetName.setToolTipText("Tutaj wpisz");
        add(tGetName);
        tGetName.addActionListener(this);

    }

    public static void main(String[] args) {
        Zadanie1 okno = new Zadanie1();
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == itemExit) {
            dispose();
        } else if (source == bShowName) {
            if (name == null || name.equals("")&&tGetName.getText().equals("")) {
                lShowName.setText("Witaj nieznajomy");
            } else {
                if (!tGetName.getText().equals("")) {
                    name=tGetName.getText();
                }
                lShowName.setText("Witaj " + name);
            }
        } else if (source == tGetName) {
            name = tGetName.getText();
        }
    }

}
