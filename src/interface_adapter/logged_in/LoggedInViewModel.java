package interface_adapter.logged_in;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoggedInViewModel extends ViewModel{
    public static final String TITLE_LABEL = "My MicDrop Account";
    public static final String LOG_OUT_BUTTON_LABEL = "Log Out";
    public static final String TOP_TRACKS_BUTTON_LABEL = "Top Tracks";
    public static final String TOP_ARTISTS_BUTTON_LABEL = "Top Artists";
    public static final String TOP_GENRES_BUTTON_LABEL = "Top Genres";
    public static final String DELETE_ACCOUNT_BUTTON_LABEL = "Delete Account";
    private LoggedInState state = new LoggedInState();
    public LoggedInViewModel() { super("logged in"); }
    public void setState(LoggedInState state) { this.state = state; }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public LoggedInState getState() { return this.state; }
}
