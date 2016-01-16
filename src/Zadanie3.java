
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Zadanie3 extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenuItem itemExit;
    private JButton bButtom;
    static Random r = new Random();

    public Zadanie3() {

        setBounds(500, 100, 800, 800);
        setTitle("Zadanie3");
        setLayout(null);
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuFile = new JMenu("File");
        menuBar.add(menuFile);
        itemExit = new JMenuItem("Exit");
        menuFile.add(itemExit);
        itemExit.addActionListener(this);

        bButtom = new JButton("Wyjdz");
        bButtom.setBounds(300, 50, 80, 40);
        add(bButtom);
        bButtom.addActionListener(this);
        bButtom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                bButtom.setBounds(r.nextInt(700), r.nextInt(700), 80, 40);
            }
        });
    }

    public static void main(String[] args) {
        Zadanie3 okno = new Zadanie3();
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == itemExit) {
            dispose();
        } else if (source == bButtom) {
            dispose();
        }
    }

}
