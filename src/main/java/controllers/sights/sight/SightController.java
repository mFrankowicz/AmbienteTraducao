package controllers.sights.sight;

import controllers.sights.TranslationController;
import javafx.scene.layout.HBox;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class SightController extends TranslationController {

    private HBox hBox;

    private ItemsController itemsController;

    public SightController(String vBoxCssClass){
        super(vBoxCssClass);
        hBox = new HBox();
        hBox.getStyleClass().add("hbox-sights");

        ViewItem viewItem= new ViewItem();
        itemsController = new ItemsController();

        viewItem.getTextArea().appendText("VIEW 1");

        getRoot().getChildren().add(viewItem.getRootAnchorPane());

        hBox.getChildren().add(getRoot());
        hBox.getChildren().add(itemsController.getFlowPane());
    }
}
