package view;


import interface_adapter.delete_account.DeleteAccountState;
import interface_adapter.delete_account.DeleteAccountViewModel;
import interface_adapter.login.LogInState;
import interface_adapter.signup.SignUpViewModel;
import interface_adapter.signup.SignUpController;
import interface_adapter.login.LogInController;
import interface_adapter.login.LogInViewModel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
public class SignupLoginView extends JPanel implements ActionListener, PropertyChangeListener{
    public final String viewName = "signup login";
    private final SignUpViewModel signUpViewModel;
    private final LogInViewModel logInViewModel;
    private final SignUpController signupController;
    private final LogInController loginController;
    private final DeleteAccountViewModel deleteAccountViewModel;
    private final JButton signUpButton;
    private final JButton logInButton;


    public SignupLoginView(SignUpViewModel signUpViewModel, LogInViewModel logInViewModel,
                           SignUpController signupController,
                           LogInController loginController,
                           DeleteAccountViewModel deleteAccountViewModel) {
        this.signUpViewModel = signUpViewModel;
        this.logInViewModel = logInViewModel;
        this.signupController = signupController;
        this.loginController = loginController;
        this.deleteAccountViewModel = deleteAccountViewModel;
        signUpViewModel.addPropertyChangeListener(this);
        logInViewModel.addPropertyChangeListener(this);
        deleteAccountViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(SignUpViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        signUpButton = new JButton(SignUpViewModel.SIGNUP_BUTTON_LABEL);
        buttons.add(signUpButton);
        logInButton = new JButton(SignUpViewModel.LOGIN_BUTTON_LABEL);
        buttons.add(logInButton);

        signUpButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(signUpButton)){
                            signupController.execute();
                        }
                    }
                }
        );
        logInButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(logInButton)){
                            loginController.execute();
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(buttons);
    }
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof DeleteAccountState) {
            DeleteAccountState state = (DeleteAccountState) evt.getNewValue();
            JOptionPane.showMessageDialog(this, "Deleted user: " + state.getUser());
        } else if (evt.getNewValue() instanceof LogInState) {
            LogInState state = (LogInState) evt.getNewValue();
            JOptionPane.showMessageDialog(this, state.getUsernameError());
        }
    }
}





