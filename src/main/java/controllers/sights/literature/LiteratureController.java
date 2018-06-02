package controllers.sights.literature;

import controllers.sights.TranslationController;
import javafx.scene.layout.HBox;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class LiteratureController extends TranslationController {

    public LiteratureController(String vBoxCssClass) {
        super(vBoxCssClass);
        LiteratureItemController item = new LiteratureItemController();
        item.getTextArea().appendText("literature list");

        getRoot().getChildren().add(item.getRootAnchorPane());
    }
}
