package org.drombler.contactapp.views;

import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.FloatingActionButton;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

public class AddContactPresenter {

    @FXML
    private View addContact;

    public void initialize() {
        addContact.setShowTransitionFactory(BounceInRightTransition::new);
        
        FloatingActionButton fab = new FloatingActionButton(MaterialDesignIcon.INFO.text,
                e -> System.out.println("Info"));
        fab.showOn(addContact);

        addContact.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
//                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e ->
//                        MobileApplication.getInstance().getDrawer().open()));
                appBar.getActionItems().add(new Button("Cancel")); // TODO: i18n
                appBar.setTitleText("New Contact"); // TODO: i18n
//                appBar.getActionItems().add(MaterialDesignIcon.FAVORITE.button(e ->
//                        System.out.println("Favorite")));
                appBar.getActionItems().add(new Button("Finish")); // TODO: i18n
            }
        });
    }
}
