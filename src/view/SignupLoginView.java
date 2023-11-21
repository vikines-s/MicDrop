package view;


import interface_adapter.delete_account.DeleteAccountController;
import interface_adapter.delete_account.DeleteAccountState;
import interface_adapter.delete_account.DeleteAccountViewModel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
public class SignupLoginView extends JPanel implements ActionListener, PropertyChangeListener{
    public final String viewName = "signup_login";
    private final SignupLoginViewModel signupLoginViewModel;
    private final SignupLoginController signupLoginController;
    private final DeleteAccountViewModel deleteAccountViewModel;
    private final DeleteAccountController deleteAccountController;
    private final JButton signUpLogInButton;


    public SignupLoginView(SignupLoginViewModel signupLoginViewModel,
                           SignupLoginController signupLoginController,
                           DeleteAccountViewModel deleteAccountViewModel,
                           DeleteAccountController deleteAccountController) {
        this.signupLoginViewModel = signupLoginViewModel;
        this.signupLoginController = signupLoginController;
        this.deleteAccountViewModel = deleteAccountViewModel;
        this.deleteAccountController = deleteAccountController;
        signupLoginViewModel.addPropertyChangeListener(this);
        deleteAccountViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(SignupLoginViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        signUpLogInButton = new JButton(SignupLoginViewModel.SIGNUP_LOGIN_BUTTON_LABEL);
        buttons.add(signUpLogInButton);

        signUpLogInButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(signUpLogInButton)){
                            signupLoginController.execute();
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(signUpLogInButton);
    }
    public void actionPerformed(ActionEvent e){

    }
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof DeleteAccountState) {
            DeleteAccountState state = (DeleteAccountState) evt.getNewValue();
            JOptionPane.showMessageDialog(this, state.getUser());
        }
    }
}





