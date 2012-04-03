import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class InsertStatements extends JPanel {
    
    JTextArea input;
    JTextArea output;
    
    public InsertStatements() {
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        input = new JTextArea();
        output = new JTextArea();
        
        JScrollPane scroll1 = new JScrollPane(input);
        scroll1.setPreferredSize(new Dimension(250, 250));
        
        JScrollPane scroll2 = new JScrollPane(output);
        scroll2.setPreferredSize(new Dimension(250, 250));
        
        JButton responder = new JButton("Translate");
        responder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String in = input.getText();
                String[] split = in.split("\n");
                if(split.length > 2) {
                    output.setText("");
                    String table = "`" + split[0].replace("\t", "") + "`";
                    String columns = "`" + split[1].replaceAll("\t", "`,`") + "`";
                    for (int i = 2; i < split.length; i++) {
                        String data = "'";
                        data += split[i].replace("'", "\\'").replace("\t", "','");
                        data += "'";
                        output.setText(output.getText() + "INSERT INTO " + table + " (" + columns + ") VALUES (" + data + ");\n");
                    }
                }
            }
        });
        
        JPanel p = new JPanel();
        p.add(new JLabel("Input"));
        add(p);
        add(scroll1);
        JPanel p2 = new JPanel();
        p2.add(responder);
        add(p2);
        JPanel p3 = new JPanel();
        p3.add(new JLabel("Output"));
        add(p3);
        add(scroll2);
    }
}
