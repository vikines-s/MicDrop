package view;


import interface_adapter.delete_account.DeleteAccountState;
import interface_adapter.delete_account.DeleteAccountViewModel;
import interface_adapter.get_auth_code.GetAuthCodeController;
import interface_adapter.login.LoginController;
import interface_adapter.signup.SignUpController;
import interface_adapter.signup.SignUpViewModel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
public class SignupLoginView extends JPanel implements ActionListener, PropertyChangeListener{
    public final String viewName = "signup login";
    private final SignUpViewModel signUpViewModel;
    private final SignUpController signupController;
    private final LoginController loginController;
    private final GetAuthCodeController getAuthCodeController;
    private final DeleteAccountViewModel deleteAccountViewModel;
    private final JTextField usernameInputField = new JTextField(15);
    private final JTextField authorizationCodeInputField = new JTextField(15);
    private final JButton getAuthCodeButton;
    private final JButton signUpButton;
    private final JButton logInButton;


    public SignupLoginView(SignUpViewModel signUpViewModel,
                           SignUpController signupController,
                           LoginController loginController,
                           GetAuthCodeController getAuthCodeController,
                           DeleteAccountViewModel deleteAccountViewModel) {
        this.signUpViewModel = signUpViewModel;
        this.signupController = signupController;
        this.loginController = loginController;
        this.getAuthCodeController = getAuthCodeController;
        this.deleteAccountViewModel = deleteAccountViewModel;
        signUpViewModel.addPropertyChangeListener(this);
        deleteAccountViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(SignUpViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel(SignUpViewModel.USERNAME_LABEL), usernameInputField);
        LabelTextPanel authCodeInfo = new LabelTextPanel(
                new JLabel(SignUpViewModel.GET_AUTH_LABEL), authorizationCodeInputField);

        JPanel buttons = new JPanel();
        getAuthCodeButton = new JButton(SignUpViewModel.AUTH_CODE_LABEL);
        buttons.add(getAuthCodeButton);
        signUpButton = new JButton(SignUpViewModel.SIGNUP_BUTTON_LABEL);
        buttons.add(signUpButton);
        logInButton = new JButton(SignUpViewModel.LOGIN_BUTTON_LABEL);
        buttons.add(logInButton);

        signUpButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(signUpButton)){
                            signupController.execute("username"); // TODO: ADD USERNAME
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
        this.add(usernameInfo);
        this.add(authCodeInfo);
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





