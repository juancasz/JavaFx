package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.util.Arrays;


public class TextStatisticsApplication extends Application{

    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        TextArea text = new TextArea();
        Label letters = new Label("Letters: 0");
        Label words = new Label("Words: 0");
        Label longest = new Label("The longest word is:");
        
        text.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int nwords = parts.length;
            String nlongest = Arrays.stream(parts)
                .sorted((s1, s2) -> s2.length() - s1.length())
                .findFirst()
                .get();

            // set values of text elements
            letters.setText("Letters: "+characters);
            words.setText("Words: "+nwords);
            longest.setText("The longest word is: "+nlongest);
        });
        
        HBox labels = new HBox();
        labels.setSpacing(10);
        labels.getChildren().add(letters);
        labels.getChildren().add(words);
        labels.getChildren().add(longest);    
        
        layout.setCenter(text);
        layout.setBottom(labels);
        
        window.setScene(new Scene(layout));
        window.show();
    }
    
    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}
