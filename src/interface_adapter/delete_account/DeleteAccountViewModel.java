package interface_adapter.delete_account;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DeleteAccountViewModel extends ViewModel {
    private DeleteAccountState state = new DeleteAccountState();
    public DeleteAccountViewModel() { super("delete account"); }
    public void setState(DeleteAccountState state) {
        this.state = state;
    }
    public DeleteAccountState getState() { return this.state; }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state );
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
