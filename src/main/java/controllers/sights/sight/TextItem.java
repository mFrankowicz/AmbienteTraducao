package controllers.sights.sight;

import controllers.sights.AdvancedItem;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class TextItem extends AdvancedItem {

    public TextItem(){
        super();
        getTextArea().getStyleClass().addAll( "text-simple-item", "transparent-fill");
        getRootAnchorPane().setMinSize(200,60);
        getRootAnchorPane().setPrefSize(300,100);
        getRootAnchorPane().setMaxSize(400,200);
        setTextFieldPadding(2,2,2,2);
    }

}
