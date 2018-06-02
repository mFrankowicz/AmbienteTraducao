package controllers.sights.theory;

import controllers.sights.TranslationController;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class TheoryController extends TranslationController {

    public TheoryController(String vBoxCssClass){
        super(vBoxCssClass);
        TheoryItemController item = new TheoryItemController();
        item.getTextArea().appendText("performance as...");

        getRoot().getChildren().add(item.getRootAnchorPane());

    }
}
