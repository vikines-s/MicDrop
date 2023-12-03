package interface_adapter.logout;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LogOutViewModel extends ViewModel {

    private LogOutState state = new LogOutState();
    public LogOutViewModel() {
        super("log out");
    }
    public void setState(LogOutState state) {
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public LogOutState getState() {
        return this.state;
    }
}
