package interface_adapter.get_auth_code;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GetAuthCodeViewModel extends ViewModel {

    private GetAuthCodeState state = new GetAuthCodeState();

    public GetAuthCodeViewModel() {
        super("get_auth_code");
    }
    public GetAuthCodeState getState() {
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
