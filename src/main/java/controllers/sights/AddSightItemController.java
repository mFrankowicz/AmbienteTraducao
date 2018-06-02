package controllers.sights;

import controllers.sights.sight.ItemsController;
import core.Controller;
import helper.ConfigurationHelper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import org.fxmisc.richtext.StyleClassedTextArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddSightItemController {

    @FXML
    AnchorPane textAreaAnchorPane;

    @FXML
    MenuItem saveMenuItem;

    ItemsController itemsController;

    StyleClassedTextArea textArea;
    public void initialize(){
        textArea = new StyleClassedTextArea();
        textArea.setWrapText(true);
        textArea.setFocusTraversable(false);
        textArea.getStyleClass().add("text-advanced-item");

        textAreaAnchorPane.getChildren().add(textArea);
        ConfigurationHelper.setAnchorConstrain(textArea,5,5,5,5);


    }
}
