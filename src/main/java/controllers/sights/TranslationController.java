package controllers.sights;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope("prototype")
public class TranslationController {

    private VBox root;

    private ObservableList<Node> items = FXCollections.observableArrayList();

    public TranslationController(String vBoxCssClass){

        root = new VBox();
        root.getStyleClass().add(vBoxCssClass);
        root.setPadding(new Insets(10,10,10,10));
        root.setSpacing(10);

    }

    public void addItemToList(Node node){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                root.getChildren().add(node);
                items.add(node);
            }
        });

    }

    public void updateItemList(){

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                root.getChildren().clear();
                root.getChildren().addAll(items);
            }
        });

    }



}
