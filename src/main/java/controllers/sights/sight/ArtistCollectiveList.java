package controllers.sights.sight;

import controllers.sights.AdvancedItem;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class ArtistCollectiveList extends AdvancedItem {

    public ArtistCollectiveList(){
        super();
        getTextArea().getStyleClass().addAll( "artist-collective-list", "text-artist-collective-list", "transparent-fill");
        getRootAnchorPane().setMinSize(200,100);
        getRootAnchorPane().setPrefSize(200,400);
        getRootAnchorPane().setMaxSize(200,500);
        setTextFieldPadding(2,2,2,2);
    }
}
