package controllers.sights.theory;

import controllers.sights.AdvancedItem;
import controllers.sights.SimpleItem;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class TheoryItemController extends AdvancedItem {

    public TheoryItemController(){
        super();
        getTextArea().getStyleClass().addAll( "text-theory");
        getRootAnchorPane().setMinSize(200,60);
        getRootAnchorPane().setPrefSize(200,150);
        getRootAnchorPane().setMaxSize(200,300);
        setTextFieldPadding(2,2,2,2);
    }
}
