package view;


import interface_adapter.delete_account.DeleteAccountState;
import interface_adapter.delete_account.DeleteAccountViewModel;
import interface_adapter.login.LogInState;
import interface_adapter.get_auth_code.GetAuthCodeController;
import interface_adapter.get_auth_code.GetAuthCodeState;
import interface_adapter.get_auth_code.GetAuthCodeViewModel;
import interface_adapter.login.LogInController;
import interface_adapter.logout.LogOutState;
import interface_adapter.logout.LogOutViewModel;
import interface_adapter.signup.SignUpController;
import interface_adapter.signup.SignUpState;
import interface_adapter.signup.SignUpViewModel;
import interface_adapter.signup.SignUpController;
import interface_adapter.login.LogInController;
import interface_adapter.login.LogInViewModel;


import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

public class SignupLoginView extends JPanel implements ActionListener, PropertyChangeListener{
    public final String viewName = "signup login";
    private final SignUpViewModel signUpViewModel;
    private final LogInViewModel logInViewModel;
    private final SignUpController signupController;
    private final LogInController logInController;
    private final GetAuthCodeController getAuthCodeController;
    private final GetAuthCodeViewModel getAuthCodeViewModel;
    private final DeleteAccountViewModel deleteAccountViewModel;
    private final LogOutViewModel logOutViewModel;
    private final JTextField usernameInputField = new JTextField(15);
    private final JTextField authorizationCodeInputField = new JTextField(15);
    private final JButton getAuthCodeButton;
    private final JButton signUpButton;
    private final JButton logInButton;


    public SignupLoginView(SignUpViewModel signUpViewModel,LogInViewModel logInViewModel,
                           SignUpController signupController,
                           LogInController logInController,
                           GetAuthCodeViewModel getAuthCodeViewModel,
                           GetAuthCodeController getAuthCodeController,
                           DeleteAccountViewModel deleteAccountViewModel,
                           LogOutViewModel logOutViewModel) {
        this.signUpViewModel = signUpViewModel;
        this.logInViewModel = logInViewModel;
        this.signupController = signupController;
        this.logInController = logInController;
        this.getAuthCodeViewModel = getAuthCodeViewModel;
        this.getAuthCodeController = getAuthCodeController;
        this.deleteAccountViewModel = deleteAccountViewModel;
        this.logOutViewModel = logOutViewModel;
        signUpViewModel.addPropertyChangeListener(this);
        logInViewModel.addPropertyChangeListener(this);
        deleteAccountViewModel.addPropertyChangeListener(this);
        getAuthCodeViewModel.addPropertyChangeListener(this);
        logOutViewModel.addPropertyChangeListener(this);

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
                            LogInState currentState = logInViewModel.getState();
                            signupController.execute("username", currentState.getAuthCode()); // TODO: ADD USERNAME
                        }
                    }
                }
        );
        //TODO: create a signuplogin view state and use values of field for login and signup controller
        logInButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(logInButton)){
                            LogInState currentState = logInViewModel.getState();
                            logInController.execute(currentState.getUsername(), currentState.getAuthCode());
                        }
                    }
                }
        );
        getAuthCodeButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(getAuthCodeButton)) {
                            getAuthCodeController.execute();
                        }
                    }
                }
        );
        usernameInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                LogInState currentState = logInViewModel.getState();
                String text = usernameInputField.getText() + e.getKeyChar();
                currentState.setUsername(text);
                logInViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        authorizationCodeInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                LogInState currentState = logInViewModel.getState();
                String text = authorizationCodeInputField.getText() + e.getKeyChar();
                currentState.setAuthCode(text);
                logInViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

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
        } else if (evt.getNewValue() instanceof LogInState) {
            LogInState state = (LogInState) evt.getNewValue();
            JOptionPane.showMessageDialog(this, state.getUsernameError());
        } else if (evt.getNewValue() instanceof SignUpState) {
            SignUpState state = (SignUpState) evt.getNewValue();
            JOptionPane.showMessageDialog(this, state.getUsernameError());
        } else if (evt.getNewValue() instanceof LogOutState) {
            LogOutState state = (LogOutState) evt.getNewValue();
            JOptionPane.showMessageDialog(this, "You have successfully logged out " + state.getUsername() + "!");
        }else if (evt.getNewValue() instanceof GetAuthCodeState state) {
            Font font = new Font("Tahoma", Font.PLAIN, 24);
            StringBuffer style = new StringBuffer("font-family:" + font.getFamily() + ";");
            style.append("font-weight:" + (font.isBold() ? "bold" : "normal") + ";");
            style.append("font-size:" + font.getSize() + "pt;");
            String uriString = state.getAuthorizationCodeUri().toString();
            JEditorPane ep = new JEditorPane("text/html", "<html><body style=\"" + style + "\">" //
                    + "Click on <a href=\""+ uriString +"\">this link</a> to authorize" //
                    + "</body></html>");
            ep.addHyperlinkListener(new HyperlinkListener()
            {
                @Override
                public void hyperlinkUpdate(HyperlinkEvent e)
                {
                    if (e.getEventType().equals(HyperlinkEvent.EventType.ACTIVATED)) {
                        try {
                            Desktop.getDesktop().browse(e.getURL().toURI()); // roll your own link launcher or use Desktop if J6+
                        } catch (IOException | URISyntaxException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            });

            ep.setEditable(false);
            JOptionPane.showMessageDialog(this, ep);
        }
    }
}





