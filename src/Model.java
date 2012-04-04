import java.util.Observable;

public class Model extends Observable {
    
    String currentView = MainFrame.INSERT;

    public String getCurrentView() {
        return currentView;
    }

    public void setCurrentView(String currentView) {
        this.currentView = currentView;
        setChanged();
        notifyObservers("1");
        clearChanged();
        
        System.out.println("Did notify");
    }
    
}
