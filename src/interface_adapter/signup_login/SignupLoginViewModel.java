package interface_adapter.signup_login;

import java.beans.PropertyChangeListener;

import interface_adapter.ViewModel;

public class SignupLoginViewModel extends ViewModel{
    public static final String TITLE_LABEL = "Welcome to MicDrop!";
    public static final String SIGNUP_BUTTON_LABEL = "Sign Up!";
    public static final String LOGIN_BUTTON_LABEL = "Log In!";
    public SignupLoginViewModel(){ super("signup login"); }


    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
