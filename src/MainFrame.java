import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame implements Observer {
    
    public static final String INSERT = "1";
    public static final String UPDATE = "2";
    public static final String DELETE = "3";
    
    InsertStatements is;
    UpdateStatements us;
    DeleteStatements ds;
    JPanel cl;
    
    public MainFrame() {
        
        setSize(800,600);
        
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        BorderLayout b = new BorderLayout();
        setLayout(b);
        
        // Create the CardLayout to switch the views
        cl = new JPanel(new CardLayout());
        
        // add it into a center JPanel
        add(cl,BorderLayout.CENTER);
        
        // Add some views to the cardLayout
        is = new InsertStatements();
        us = new UpdateStatements();
        ds = new DeleteStatements();
        cl.add(is, INSERT);
        cl.add(us, UPDATE);
        cl.add(ds, DELETE);
        // add the menu bar at the top
        MenuBar menu = new MenuBar();
        add(menu, BorderLayout.NORTH);
        
        Registry.getModel().addObserver(this);
        
        setVisible(true);
    }

    public void update(Observable model, Object data) {
        if(data.equals("1")) {
            CardLayout tmp = (CardLayout)(cl.getLayout());
            tmp.show(cl, Registry.getModel().getCurrentView());
        }
    }
    
    
    
}
