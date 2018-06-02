package controllers.sights.performanceas;

import controllers.sights.AdvancedItem;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
@Data
public class PerformanceasItemController extends AdvancedItem {

    public PerformanceasItemController() {
        super();
        getTextArea().getStyleClass().addAll( "text-performance-as", "transparent-fill");
        getRootAnchorPane().setMinSize(200,60);
        getRootAnchorPane().setPrefSize(400,50);
        getRootAnchorPane().setMaxSize(400,50);
        setTextFieldPadding(2,2,2,2);
    }

}
