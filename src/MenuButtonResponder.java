import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;

public class MenuButtonResponder implements ActionListener {

    private Model data = Registry.getModel();

    // this class manages when any of the menuItems or tool bar buttons are
    // clicked
    public void actionPerformed(ActionEvent arg0) {
        // determine what the menuItem text is, or the icon name (if
        // text.equals(""))

        String itemText = ((AbstractButton) arg0.getSource()).getText();
        if (itemText.equals("")) {
            itemText = ((AbstractButton) arg0.getSource()).getIcon().toString();
        }

        // determine what to do based on the text

        if (itemText.equals("INSERT")) {
            data.setCurrentView(MainFrame.INSERT);
        } else if (itemText.equals("DELETE")) {
            data.setCurrentView(MainFrame.DELETE);
        } else if (itemText.equals("UPDATE")) {
            data.setCurrentView(MainFrame.UPDATE);
        }
    }

}
