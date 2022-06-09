package lesson4;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class Chat extends JFrame{
    JTextArea text = new JTextArea();
    JPanel jp1 = new JPanel(new GridLayout());
    JPanel jp2 = new JPanel(new GridLayout());
    JScrollPane jsp = new JScrollPane(text);
    JTextField jtf = new JTextField();
    JButton jb = new JButton("SEND");


    JMenuBar mainMenu = new JMenuBar();
    JMenu mFile = new JMenu("File");
    JMenu mHelp = new JMenu("Help");

    PrintWriter pw = new PrintWriter(new FileWriter("1.txt"));

    Chat() throws IOException {
        super("client chat");
        setSize(600, 800);
        setMinimumSize(new Dimension(150, 200));
        text.setEditable(false);
        text.setLineWrap(true);
        jb.addActionListener(e -> sendMessage());
        jtf.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) sendMessage();
            }
        });

        jp1.add(jsp);
        jp2.add(jtf);
        jp2.add(jb);

        add(jp1);
        add("South", jp2);

        setJMenuBar(mainMenu);
        mainMenu.add(mFile);
        mainMenu.add(mHelp);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void sendMessage() {
        String out = jtf.getText();
        text.append("User: " + out + "\n");
        pw.append("User: " + out + "\n");
        pw.flush();
        jtf.setText("");
        jtf.grabFocus();
    }



}