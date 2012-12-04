import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

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
        
        input.setToolTipText("<html>Drop your tab delemited excel data here in the form of:<br/>TableName<br/>column1   column2 column3<br/>data1  data2   data3<br/>data1_1  data2_1 data3_1<html>");
        
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
                    String table = "`" + split[0].replace("\t", "") + "`";
                    String columns = "`" + split[1].replaceAll("\t", "`,`") + "`";
                    ArrayList<String> items = new ArrayList<String>();
                    for (int i = 2; i < split.length; i++) {
                        String data = "'";
                        data += split[i].replace("'", "\\'").replace("\t", "','");
                        data += "'";
                        items.add("INSERT INTO " + table + " (" + columns + ") VALUES (" + data + ");");
                    }
                    output.setText(Util.Join(items,"\n"));
                } else {
                    input.setBackground(new Color(255, 0, 0));
                }
            }
        });
        input.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent arg0) {
                input.setBackground(new Color(255,255,255));
            }
            public void focusLost(FocusEvent arg0) {   
            } 
        });
        
        JPanel p = new JPanel();
        p.add(new JLabel("<html><div style=\"text-align: center;\"><h2>Insert Statements</h2><p>Input<p></div></html>"));
        add(p);
        add(scroll1);
        JPanel p2 = new JPanel();
        p2.add(responder);
        add(p2);
        JPanel p3 = new JPanel();
        p3.add(new JLabel("<html><div style=\"text-align: center;\"><p>Output</p></div></html>"));
        add(p3);
        add(scroll2);
    }
}
