package controllers.sights;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.Document;
import org.fxmisc.richtext.StyleClassedTextArea;
import org.fxmisc.richtext.model.StyledDocument;
import org.javatuples.Triplet;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

import static controllers.sights.BaseItemType.*;

@Getter
@Setter
@Component
@Scope("prototype")
public class BaseItem {

    private long id;
    private String text;
    private String sightCollectionId;
    private String translatorId;
    public BaseItemType type;
    public Codec codec;

    public BaseItem(){
        id = -1;
        text = "";
        sightCollectionId = "";
        translatorId = "";
        type = NONE;
        codec = new Codec();
    }

    public class Codec {

        public Document encode(StyleClassedTextArea textArea){

            AtomicInteger start = new AtomicInteger(0);
            AtomicInteger end = new AtomicInteger(0);

            ObservableList<Triplet<Integer,Integer,Collection<String>>> formatIndex = FXCollections.observableArrayList();

            StyledDocument<Collection<String>, String, Collection<String>> doc = textArea.getDocument();
            doc.getStyleSpans(0,doc.length()).forEach((p) -> {
                Triplet<Integer, Integer, Collection<String>> i =
                        Triplet.with(
                                start.addAndGet(p.getLength())-p.getLength(),
                                end.addAndGet(p.getLength()),
                                p.getStyle());


                formatIndex.add(i);
            });

            ObservableList<Document> styles = FXCollections.observableArrayList();
            formatIndex.forEach((t) -> {
                Document style = new Document();
                style.append("start", t.getValue0())
                        .append("end", t.getValue1())
                        .append("style", t.getValue2());
                styles.add(style);
            });

            Document formatDocument = new Document();
            formatDocument
                    .append("length", doc.length())
                    .append("styles",styles);

            return formatDocument;
        }

        public void decode(){

        }
    }

}
