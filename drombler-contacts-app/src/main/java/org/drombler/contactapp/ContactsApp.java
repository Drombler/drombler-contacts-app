package org.drombler.contactapp;

import org.drombler.contactapp.views.AddContactPresenter;
import org.drombler.contactapp.views.AddContactView;
import org.drombler.contactapp.views.PrimaryView;
import org.drombler.contactapp.views.SecondaryView;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ContactsApp extends MobileApplication {

    public static final String PRIMARY_VIEW = HOME_VIEW;
    public static final String SECONDARY_VIEW = "Secondary View";
    public static final String ADD_CONTACT_VIEW = "Add Contact View";

    @Override
    public void init() {
        addViewFactory(PRIMARY_VIEW, () -> (View) new PrimaryView().getView());
        addViewFactory(SECONDARY_VIEW, () -> (View) new SecondaryView().getView());
        addViewFactory(ADD_CONTACT_VIEW, () -> (View) new AddContactView().getView());

        DrawerManager.buildDrawer(this);
    }

    @Override
    public void postInit(Scene scene) {
        Swatch.BLUE.assignTo(scene);

        scene.getStylesheets().add(ContactsApp.class.getResource("style.css").toExternalForm());
        ((Stage) scene.getWindow()).getIcons().add(new Image(ContactsApp.class.getResourceAsStream("/icon.png")));
    }
}
