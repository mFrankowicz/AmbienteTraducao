package controllers.sights.literature;

import controllers.sights.AdvancedItem;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class LiteratureItemController extends AdvancedItem {

    public LiteratureItemController() {
        super();
        getTextArea().getStyleClass().addAll( "text-literature");
        getRootAnchorPane().setMinSize(200,60);
        getRootAnchorPane().setPrefSize(300,100);
        getRootAnchorPane().setMaxSize(300,400);
        setTextFieldPadding(2,2,2,2);
    }
}
