import java.util.ArrayList;
import java.io.Console;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class UpdateStatements extends JPanel {
    
    JTextArea input;
    JTextArea output;
    JTextField operation;
    
    public UpdateStatements() {
        
    	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        input = new JTextArea();
        output = new JTextArea();
        
        input.setToolTipText("<html>Drop your tab delemited excel data here in the form of:<br/>TableName<br/>column1  column2   column3<br/>*(if ID)   *(if ID)   (nothing if not id)<br/>data1  data2   data3<br/>data1_1  data2_1 data3_1<html>");
        
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
                    String[] columns = split[1].split("\t",-1);
                    String[] isindex = split[2].split("\t",-1);
                    ArrayList<String> items = new ArrayList<String>();
                    for (int i = 3; i < split.length; i++) {
                        String[] data = split[i].split("\t",-1);
                        items.add("UPDATE " + table + " set "+buildUpdate(columns,isindex,data)+" WHERE "+buildWhere(columns,isindex,data)+";");
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
        p.add(new JLabel("<html><div style=\"text-align: center;\"><h2>Update Statements</h2><p>Input<p></div></html>"));
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
    
    private String buildUpdate(String[] columns, String[] isindex, String[] data){
    	ArrayList<String> built_items = new ArrayList<String>();
    	for(int i = 0; i < columns.length; i++){
    		if(!isindex[i].equals("*")){
    			built_items.add(" `"+columns[i]+"` = '"+data[i].replace("'", "\\'")+"' ");
    		}
    	}
    	return Util.Join(built_items, " , ");
    }
    
    private String buildWhere(String[] columns, String[] isindex, String[] data){
    	ArrayList<String> built_items = new ArrayList<String>();
    	for(int i = 0; i < columns.length; i++){
    		if(isindex[i].equals("*")){
    			built_items.add(" `"+columns[i]+"` = '"+data[i].replace("'", "\\'")+"' ");
    		}
    	}
    	return Util.Join(built_items, " , ");
    }
}
