package controllers.sights.sight;

import controllers.sights.AdvancedItem;
import controllers.sights.BaseItemType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@Scope("prototype")
@Data
public class DirectionItem extends AdvancedItem {


    public DirectionItem() {
        super();
        getTextArea().setMinSize(0,0);
        getTextArea().getStyleClass().addAll("text-directions", "orange-fill");
        getRootAnchorPane().setMinSize(200,70);
        getRootAnchorPane().setPrefSize(200,70);
        getRootAnchorPane().setMaxSize(200,120);
        setTextFieldPadding(10,20,10,20);

    }

}
