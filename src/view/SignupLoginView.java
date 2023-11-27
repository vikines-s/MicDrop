package view;


import interface_adapter.delete_account.DeleteAccountState;
import interface_adapter.delete_account.DeleteAccountViewModel;
import interface_adapter.signup_login.SignupLoginViewModel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
public class SignupLoginView extends JPanel implements ActionListener, PropertyChangeListener{
    public final String viewName = "signup login";
    private final SignupLoginViewModel signupLoginViewModel;
    private final SignupController signupController;
    private final LoginController loginController;
    private final DeleteAccountViewModel deleteAccountViewModel;
    private final JButton signUpButton;
    private final JButton logInButton;


    public SignupLoginView(SignupLoginViewModel signupLoginViewModel,
                           SignupController signupController,
                           LoginController loginController,
                           DeleteAccountViewModel deleteAccountViewModel) {
        this.signupLoginViewModel = signupLoginViewModel;
        this.signupController = signupController;
        this.loginController = loginController;
        this.deleteAccountViewModel = deleteAccountViewModel;
        signupLoginViewModel.addPropertyChangeListener(this);
        deleteAccountViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(SignupLoginViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        signUpButton = new JButton(SignupLoginViewModel.SIGNUP_BUTTON_LABEL);
        buttons.add(signUpButton);
        logInButton = new JButton(SignupLoginViewModel.LOGIN_BUTTON_LABEL);
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
        }
    }
}





