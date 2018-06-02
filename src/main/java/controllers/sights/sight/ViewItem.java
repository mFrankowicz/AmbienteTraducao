package controllers.sights.sight;

import controllers.sights.AdvancedItem;
import controllers.sights.SimpleItem;

public class ViewItem extends AdvancedItem {

    public ViewItem() {
        super();
        getTextArea().getStyleClass().addAll( "view-item");
        getRootAnchorPane().setMinSize(200,30);
        getRootAnchorPane().setPrefSize(300,30);
        getRootAnchorPane().setMaxSize(300,100);
        setTextFieldPadding(2,2,2,2);
    }
}
