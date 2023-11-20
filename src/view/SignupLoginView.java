package view;


import interface_adapter.delete_account.DeleteAccountController;
import interface_adapter.delete_account.DeleteAccountViewModel;
import interface_adapter.signup_login.SignUpLogInController;
import interface_adapter.signup_login.SignUpLogInViewModel;


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
    private final JButton signUpLogInButton;


    public SignupLoginView(SignupLoginViewModel signupLoginViewModel,
                           SignupLoginController signupLoginController) {
        this.signupLoginViewModel = signupLoginViewModel;
        this.signupLoginController = signupLoginController;


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
    }
}





