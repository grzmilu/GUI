
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Zadanie4 extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu menuFile, menuAbout;
    private JMenuItem itemOpen, itemSave, itemExit,itemAboutProgram;
    private JTextField tNumber;
    private JLabel lNumber, lCheck, lPesel;
    private JButton bCheck, bSave;
    private JTextArea taPesel;
    private String filePath = "";

    public Zadanie4() {

        setBounds(500, 100, 800, 800);
        setTitle("Zadanie4");
        setLayout(null);
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuAbout = new JMenu("About");
        menuBar.add(menuAbout);
        
        itemAboutProgram = new JMenuItem("About program");
        menuAbout.add(itemAboutProgram);
        itemAboutProgram.addActionListener(this);
        
        itemOpen = new JMenuItem("Open");
        menuFile.add(itemOpen);
        itemOpen.addActionListener(this);

        itemSave = new JMenuItem("Save as");
        menuFile.add(itemSave);
        itemSave.addActionListener(this);

        menuFile.addSeparator();
        itemExit = new JMenuItem("Exit");
        menuFile.add(itemExit);
        itemExit.addActionListener(this);

        lNumber = new JLabel("Podaj numer pesel");
        lNumber.setBounds(100, 100, 200, 20);
        add(lNumber);

        tNumber = new JTextField();
        tNumber.setBounds(100, 120, 100, 30);
        add(tNumber);
        tNumber.addActionListener(this);

        bCheck = new JButton("Check");
        bCheck.setBounds(210, 120, 70, 30);
        add(bCheck);
        bCheck.addActionListener(this);

        lCheck = new JLabel("NR PESEL jest");
        lCheck.setBounds(100, 170, 200, 30);
        add(lCheck);

        taPesel = new JTextArea(20, 15);
        taPesel.setEditable(false);
        
        add(taPesel);

        JScrollPane scroll = new JScrollPane(taPesel);
        scroll.setBounds(450, 100, 200, 300);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroll);

        lPesel = new JLabel("Poprawne numery PESEL:");
        lPesel.setBounds(450, 70, 200, 40);
        add(lPesel);

        bSave = new JButton("Zapisz do pliku");
        bSave.setBounds(475, 420, 150, 50);
        add(bSave);
        bSave.addActionListener(this);
    }

    public boolean check() {
        String num = tNumber.getText();
        if (num.length() != 11) {
            return false;
        }
        int sum = 0;
        int[] weight = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        for (int i = 0; i < 10; i++) {
            sum = sum + Integer.parseInt(num.substring(i, i + 1)) * weight[i];
        }
        return sum % 10 == 10 - Integer.parseInt(num.substring(10));
    }

    public void saveFile() {
        try {
            FileWriter file = new FileWriter(filePath);
            file.write(taPesel.getText());
            file.close();

        } catch (Exception e) {
        }
    }

    public void openFile() {
        taPesel.setText("");
        try {
            BufferedReader file = new BufferedReader(new FileReader(filePath));
            String line = file.readLine();
            while (line != null) {
                if (taPesel.getText().equals("")) {
                    taPesel.setText(taPesel.getText() + line);
                } else {
                    taPesel.setText(taPesel.getText() + "\n" + line);
                }

                line = file.readLine();
            }
            file.close();
        } catch (Exception e) {
        }
    }

    public void getSavePath() {
        JFileChooser fc = new JFileChooser();
        if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File plik = fc.getSelectedFile();
            filePath = plik.getPath();
            saveFile();
        }
    }

    public void getOpenPath() {
        JFileChooser fc = new JFileChooser();
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File plik = fc.getSelectedFile();
            filePath = plik.getAbsolutePath();
            openFile();
        }

    }

    public static void main(String[] args) {
        Zadanie4 okno = new Zadanie4();
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == itemExit) {
            dispose();
        } else if (source == itemAboutProgram) {
            JOptionPane.showMessageDialog(this, "Program sprawdza poprawność numeru PESEL algorytmem Luhn'a, może również zapisywać/odczytać plik.\nPaweł Grzmil");
        } else if (source == itemOpen) {
            getOpenPath();
        } else if (source == itemSave) {
            getSavePath();
        } else if (source == bCheck || source == tNumber) {

            if (check()) {
                lCheck.setText("NR PESEL jest poprawny");
                if (taPesel.getText().equals("")) {
                    taPesel.setText(tNumber.getText());
                } else {
                    taPesel.setText(taPesel.getText() + "\n" + tNumber.getText());
                }

            } else {
                lCheck.setText("NR PESEL jest niepoprawny");
            }
        } else if (source == bSave) {
            if (filePath.equals("")) {
                getSavePath();
            } else {
                saveFile();
            }
        }
    }

}
