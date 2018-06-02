package controllers.sights;

import controllers.sights.performanceas.PerformanceasController;
import controllers.sights.sight.SightController;
import controllers.sights.theory.TheoryController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Scope("prototype")
@Data
public class SightsController {
    private HBox mainHBox;

    private HBox hBox;

    private SightController sightOne;

    private AnchorPane sightMenuAnchorPane;

    private MenuButton menuButton;

    private MenuItem addPerformanceAs = new MenuItem("Performance As...");
    private MenuItem addView = new MenuItem("nn View");
    private MenuItem addViewItem = new MenuItem("nn View Item");
    private MenuItem addTheory = new MenuItem("Theory");
    private MenuItem addLiterature = new MenuItem("Literature");

    public SightsController(int sightId) {
        mainHBox = new HBox();
        mainHBox.getStyleClass().add("sight-hbox");

        hBox = new HBox();

        PerformanceasController performanceas = new PerformanceasController("vbox-performance-as");
        sightOne = new SightController("vbox-sights");
        SightController sightTwo = new SightController("vbox-sights");
        TheoryController theory = new TheoryController("vbox-theory");

        hBox.getChildren().add(performanceas.getRoot());
        hBox.getChildren().add(sightOne.getHBox());
        hBox.getChildren().add(sightTwo.getHBox());
        hBox.getChildren().add(theory.getRoot());

        sightMenuAnchorPane = new AnchorPane();
        sightMenuAnchorPane.setPrefSize(110, 200);

        Label label = new Label();
        label.setText("sight " + sightId);

        sightMenuAnchorPane.getChildren().add(label);
        AnchorPane.setTopAnchor(label, 5.0);
        AnchorPane.setLeftAnchor(label, 5.0);

        menuButton = new MenuButton("Add");
        menuButton.getItems().addAll(addPerformanceAs,
                addView,
                addViewItem,
                addTheory,
                addLiterature);


        sightMenuAnchorPane.getChildren().add(menuButton);
        AnchorPane.setTopAnchor(menuButton,30.0);
        AnchorPane.setLeftAnchor(menuButton, 5.0);

        mainHBox.getChildren().add(sightMenuAnchorPane);
        mainHBox.getChildren().add(hBox);


        MenuItem addItem = new MenuItem();
        addItem.setText("add item");
        addItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                callAddSightItem();
            }
        });

    }

    private void callAddSightItem() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/addSightItemController.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            AddSightItemController addSightItemController = fxmlLoader.getController();
            addSightItemController.saveMenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    AdvancedItem advancedItem = new AdvancedItem();
                    advancedItem.getTextArea().append(addSightItemController.textArea.getDocument());
                    sightOne.getItemsController().addItemToList(advancedItem.getRootAnchorPane());
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
}
