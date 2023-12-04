package view;

import interface_adapter.back.BackController;
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
    private final MatchesViewModel matchesViewModel;
    private final BackController backController;
    JLabel matchType;
    JLabel matchesString;

    public MatchesView(MatchesViewModel matchesViewModel, BackController backController) {
        this.matchesViewModel  = matchesViewModel;
        this.backController = backController;
        matchesViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(matchesViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        matchType = new JLabel();

        matchesString = new JLabel();

        JButton back = new JButton(matchesViewModel.BACK_BUTTON_LABEL);

        back.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(back)) {
                            backController.execute();
                        }
            }
        }
        );


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(matchType);
        this.add(matchesString);
        this.add(back);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof MatchesState) {
            MatchesState state = matchesViewModel.getState();
            if (state.getError() == null) {
                matchType.setText(state.getMatchType());
                matchesString.setText(state.getMatches());
            }
        }
    }
}
