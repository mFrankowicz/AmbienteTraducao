package controllers.sights;

/*
import core.Controller;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.input.ScrollEvent;
*/

import helper.ConfigurationHelper;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.Data;
import org.fxmisc.richtext.StyleClassedTextArea;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Data
@Component
@Scope("prototype")
public class AdvancedItem extends BaseItem {

    private AnchorPane rootAnchorPane;
    private StyleClassedTextArea textArea;

    private Button edit;
    private Button enable;

    private ButtonBar buttonBar;
    public AdvancedItem(){

        rootAnchorPane = new AnchorPane();
        rootAnchorPane.prefWidthProperty().unbind();

        textArea = new StyleClassedTextArea();
        textArea.setWrapText(true);
        textArea.setFocusTraversable(false);
        // textArea.getStyleClass().add("text-advanced-item");
        textArea.setEditable(false);
        textArea.setDisable(true);

        MenuItem item = new MenuItem();
        item.setText("ok");

        rootAnchorPane.getChildren().add(textArea);
        ConfigurationHelper.setAnchorConstrain(textArea,2,2,2,2);

        buttonBar = new ButtonBar();
        buttonBar.setVisible(false);
        buttonBar.setButtonMinWidth(10);

        edit = new Button();
        edit.setText("e");
        edit.setPadding(new Insets(1,1,1,1));

        enable = new Button();
        enable.setText("n.t");
        enable.setPadding(new Insets(1,1,1,1));

        buttonBar.getButtons().add(edit);
        buttonBar.getButtons().add(enable);

        rootAnchorPane.getChildren().add(buttonBar);
        AnchorPane.setBottomAnchor(buttonBar,2.0);
        AnchorPane.setLeftAnchor(buttonBar,2.0);

        rootAnchorPane.heightProperty().add(textArea.getHeight());
        rootAnchorPane.widthProperty().add(textArea.getWidth());

        edit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                editAdvancedItem();
            }
        });

        rootAnchorPane.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        rootAnchorPane.setPrefHeight(rootAnchorPane.getHeight() + 25);
                        AnchorPane.setBottomAnchor(textArea,25.0);
                        buttonBar.setVisible(true);

                    }
                });
            }
        });

        rootAnchorPane.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        rootAnchorPane.setPrefHeight(rootAnchorPane.getHeight() - 25);
                        AnchorPane.setBottomAnchor(textArea,2.0);
                        buttonBar.setVisible(false);
                    }
                });
            }
        });
    }

    private void editAdvancedItem(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/addSightItemController.fxml"));
                    Parent root = (Parent) fxmlLoader.load();
                    AddSightItemController addSightItemController = fxmlLoader.getController();
                    addSightItemController.saveMenuItem.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            AdvancedItem advancedItem = new AdvancedItem();
                            advancedItem.getTextArea().append(addSightItemController.textArea.getDocument());
                            textArea.clear();
                            textArea.append(advancedItem.getTextArea().getDocument());
                        }
                    });
                    Scene scene = new Scene(root, 450, 400);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void setTextFieldPadding(double top, double right, double bottom, double left){
        textArea.setPadding(new Insets(top,right,bottom,left));
    }
}
