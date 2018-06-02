package controllers.sights.performanceas;


import controllers.sights.TranslationController;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class PerformanceasController extends TranslationController {

    public PerformanceasController(String vBoxCssClass){
        super(vBoxCssClass);
        PerformanceasItemController item = new PerformanceasItemController();
        item.getTextArea().appendText("performance as...");

        getRoot().getChildren().add(item.getRootAnchorPane());
    }
}
