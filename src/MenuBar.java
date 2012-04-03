import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

// construct the menuBar and add the actionlisteners
@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {

    private JMenu menu;
    private JMenuItem menuItem;

    public MenuBar() {
        menu = new JMenu("Library");
        add(menu);

        menuItem = new JMenuItem("Overview");
        menuItem.addActionListener(new MenuButtonResponder());
        menu.add(menuItem);

        menuItem = new JMenuItem("Reset Collection");
        menuItem.addActionListener(new MenuButtonResponder());
        menu.add(menuItem);

        menu = new JMenu("Book Holding");
        add(menu);

        menuItem = new JMenuItem("Add Book");
        menuItem.addActionListener(new MenuButtonResponder());
        menu.add(menuItem);
        menuItem = new JMenuItem("Remove Book");
        menuItem.addActionListener(new MenuButtonResponder());
        menu.add(menuItem);

        menu = new JMenu("Video Holding");
        add(menu);

        menuItem = new JMenuItem("Add Video");
        menuItem.addActionListener(new MenuButtonResponder());
        menu.add(menuItem);
        menuItem = new JMenuItem("Remove Video");
        menuItem.addActionListener(new MenuButtonResponder());
        menu.add(menuItem);

    }
}
