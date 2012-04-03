import java.awt.BorderLayout;

import javax.swing.JFrame;


public class MainFrame extends JFrame {
    
    InsertStatements is;
    
    public MainFrame() {
        
        setSize(800,800);
        
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        BorderLayout b = new BorderLayout();
        setLayout(b);
        
        is = new InsertStatements();
        //b.addLayoutComponent(is, BorderLayout.CENTER);
        add(is, BorderLayout.CENTER);
        
        setVisible(true);
    }
    
}
