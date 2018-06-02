package controllers.sights.sight;

import controllers.sights.AdvancedItem;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class ItemsController {

    private FlowPane flowPane;
    private ObservableList<Node> items = FXCollections.observableArrayList();

    public ItemsController(){
        flowPane = new FlowPane();
        flowPane.setOrientation(Orientation.VERTICAL);
        flowPane.setHgap(5);
        flowPane.setVgap(5);
        flowPane.setPadding(new Insets(5,5,5,5));

        DirectionItem directionItem = new DirectionItem();
        TextItem textItem = new TextItem();
        ArtistCollectiveList artistCollectiveList = new ArtistCollectiveList();

        textItem.getTextArea().appendText("text item");
        directionItem.getTextArea().appendText("Direction \n (test)");
        artistCollectiveList.getTextArea().appendText("Artists collective list");

        items.addAll(textItem.getRootAnchorPane(),
                directionItem.getRootAnchorPane(),
                artistCollectiveList.getRootAnchorPane());

        flowPane.getChildren().add(directionItem.getRootAnchorPane());
        flowPane.getChildren().add(textItem.getRootAnchorPane());
        flowPane.getChildren().add(artistCollectiveList.getRootAnchorPane());
    }

    public void addItemToList(Node node){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                flowPane.getChildren().add(node);
                items.add(node);
            }
        });

    }

    public void updateItemList(){

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                flowPane.getChildren().clear();
                flowPane.getChildren().addAll(items);
            }
        });

    }
}
