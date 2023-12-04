package interface_adapter.matches;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MatchesViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Your matches based on:";
    public static final String BACK_BUTTON_LABEL = "Back to My Profile";
    private MatchesState state = new MatchesState();
    public MatchesViewModel() {
        super("matches");
    }
    public void setState(MatchesState state) {
        this.state = state;
    }
    public MatchesState getState() {
        return this.state;
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
}
