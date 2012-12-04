import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

// construct the menuBar and add the actionlisteners
@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {

    private JMenu menu;
    private JMenuItem menuItem;

    public MenuBar() {
        menu = new JMenu("EXCEL to SQL types");
        add(menu);

        menuItem = new JMenuItem("INSERT");
        menuItem.addActionListener(new MenuButtonResponder());
        menu.add(menuItem);

        menuItem = new JMenuItem("UPDATE");
        menuItem.addActionListener(new MenuButtonResponder());
        menu.add(menuItem);
        
        menuItem = new JMenuItem("DELETE");
        menuItem.addActionListener(new MenuButtonResponder());
        menu.add(menuItem);
        
        menu = new JMenu("Text Based (Hash)");
        add(menu);

        menuItem = new JMenuItem("Hash");
        menuItem.addActionListener(new MenuButtonResponder());
        menu.add(menuItem);

    }
}
