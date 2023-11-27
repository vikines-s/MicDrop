package interface_adapter.signup;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import interface_adapter.ViewModel;

public class SignUpViewModel extends ViewModel{
    public static final String TITLE_LABEL = "Welcome to MicDrop!";
    public static final String SIGNUP_BUTTON_LABEL = "Sign Up!";
    public static final String LOGIN_BUTTON_LABEL = "Log In!";

    private SignUpState state = new SignUpState();
    public SignUpViewModel(){ super("signup login"); }

    public void setState(SignUpState state) {
        this.state = state;
    }

    public SignUpState getState() {return state;}

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
