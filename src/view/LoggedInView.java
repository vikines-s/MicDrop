package view;

import interface_adapter.delete_account.DeleteAccountController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logout.LogOutController;
import interface_adapter.matches.MatchesController;

public class LoggedInView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "logged in";
    private final LoggedInViewModel loggedInViewModel;
    private final DeleteAccountController deleteAccountController;
    private final MatchesController matchesController;
    private final LogOutController logOutController;
    private final JButton matchesButton;
    private final JButton logOutButton;
    private final JButton deleteAccountButton;
    JLabel username;
    JLabel topTracks;
    JLabel topArtists;
    JLabel topGenres;

    public LoggedInView(DeleteAccountController deleteAccountController, MatchesController matchesController,
                        LogOutController logOutController, LoggedInViewModel loggedInViewModel) {
        this.deleteAccountController = deleteAccountController;
        this.matchesController = matchesController;
        this.logOutController = logOutController;
        this.loggedInViewModel = loggedInViewModel;
        loggedInViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(LoggedInViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel usernameInfo = new JLabel("Currently logged in: ");
        username = new JLabel();
        topTracks = new JLabel();
        topArtists = new JLabel();
        topGenres = new JLabel();

        JPanel buttons = new JPanel();
        matchesButton = new JButton(loggedInViewModel.MATCHES_BUTTON_LABEL);
        buttons.add(matchesButton);
        logOutButton = new JButton(loggedInViewModel.LOG_OUT_BUTTON_LABEL);
        buttons.add(logOutButton);
        deleteAccountButton = new JButton(loggedInViewModel.DELETE_ACCOUNT_BUTTON_LABEL);
        buttons.add(deleteAccountButton);

        matchesButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(matchesButton)) {
                            matchesController.execute(username.getText());
                        }
                    }
                }
        );
        logOutButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(logOutButton)) {
                            logOutController.execute(username.getText());
                        }
                    }
                }
        );
        deleteAccountButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(deleteAccountButton)) {
                            deleteAccountController.execute(username.getText());
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(username);
        this.add(topTracks);
        this.add(topArtists);
        this.add(topGenres);
        this.add(buttons);
    }
    public void actionPerformed(ActionEvent e) {System.out.println("Click " + e.getActionCommand());}
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof LoggedInState) {
            LoggedInState state = (LoggedInState) evt.getNewValue();
            username.setText(state.getUsername());
            topTracks.setText("Top Tracks: " + state.getTopTracks());
            topArtists.setText("top Artists: " + state.getTopArtists());
            topGenres.setText("Top Genres: " + state.getTopGenres());
        }
    }
}
