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

        if (itemText.equals("Reset Collection")) {
            data.setCurrentView(5);
        } else if (itemText.equals("Add Book")) {
            data.setCurrentView(2);
        } else if (itemText.equals("Overview")) {
            data.setCurrentView(1);
        } else if (itemText.equals("Remove Book")) {
            data.setCurrentView(4);
        } else if (itemText.equals("Add Video")) {
            data.setCurrentView(3);
        } else if (itemText.equals("Remove Video")) {
            data.setCurrentView(4);
        } else if (itemText.equals("home.png")) {
            data.setCurrentView(1);
        } else if (itemText.equals("bookadd.png")) {
            data.setCurrentView(2);
        } else if (itemText.equals("booktake.png")) {
            data.setCurrentView(4);
        } else if (itemText.equals("videoadd.png")) {
            data.setCurrentView(3);
        } else if (itemText.equals("videotake.png")) {
            data.setCurrentView(4);
        }
    }

}
