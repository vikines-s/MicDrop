package view;

import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.matches.MatchesState;
import interface_adapter.matches.MatchesViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MatchesView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "matches";
    private final LoggedInViewModel loggedInViewModel;
    private final MatchesViewModel matchesViewModel;

    public MatchesView(LoggedInViewModel loggedInViewModel, MatchesViewModel matchesViewModel) {
        this.loggedInViewModel = loggedInViewModel;
        this.matchesViewModel  = matchesViewModel;
        matchesViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(matchesViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        jlabel

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof MatchesState) {

        }
    }
}
