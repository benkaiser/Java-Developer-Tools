import java.util.ArrayList;
import java.io.Console;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.security.MessageDigest;
import java.math.BigInteger;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class HashConverter extends JPanel {
    
    JTextArea input;
    JTextArea output;
    JTextField operation;
    JRadioButton sha1button;
    JRadioButton md5button;

    public HashConverter() {
        
    	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Hash Algorithm Type buttons

        ButtonGroup buttons = new ButtonGroup();

        md5button = new JRadioButton("MD5");
        buttons.add(md5button);
        sha1button = new JRadioButton("sha1");
        buttons.add(sha1button);

        // input output initialisation
        
        input = new JTextArea();
        output = new JTextArea();

        JScrollPane scroll1 = new JScrollPane(input);
        scroll1.setPreferredSize(new Dimension(250, 250));
        
        JScrollPane scroll2 = new JScrollPane(output);
        scroll2.setPreferredSize(new Dimension(250, 250));
        
        JButton responder = new JButton("Translate");
        responder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String result = "...";
                if(md5button.isSelected() == true){
                    try{
                        MessageDigest m = MessageDigest.getInstance("MD5");
                        result = Util.byteArrayToHexString(m.digest(input.getText().getBytes()));
                    } catch(Exception exception) {
                        exception.printStackTrace();
                    } 
                } else if(sha1button.isSelected() == true){
                    try{
                        MessageDigest m = MessageDigest.getInstance("SHA-1");
                        result = Util.byteArrayToHexString(m.digest(input.getText().getBytes()));
                    } catch(Exception exception) {
                        exception.printStackTrace();
                    } 
                }
                output.setText(result);

            }
        });
        input.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent arg0) {
                input.setBackground(new Color(255,255,255));
            }
            public void focusLost(FocusEvent arg0) {   
            } 
        });
        
        JPanel p4 = new JPanel();
        p4.add(new JLabel("<html><div style=\"text-align: center;\"><h2>Hash Method</h2></div></html>"));
        add(p4);
        add(md5button);
        add(sha1button);
        JPanel p = new JPanel();
        p.add(new JLabel("<html><div style=\"text-align: center;\"><h2>Input string</h2></html>"));
        add(p);
        add(scroll1);
        JPanel p2 = new JPanel();
        p2.add(responder);
        add(p2);
        JPanel p3 = new JPanel();
        p3.add(new JLabel("<html><div style=\"text-align: center;\"><p>Output Hash</p></div></html>"));
        add(p3);
        add(scroll2);
    }
}
