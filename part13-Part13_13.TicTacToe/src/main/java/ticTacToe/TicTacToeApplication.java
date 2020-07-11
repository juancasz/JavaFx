package ticTacToe;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {
    
    @Override
    public void start(Stage window) {
        TicTacToe ticTacToe = new TicTacToe();
        
        BorderPane layout = new BorderPane();
        GridPane buttons = new GridPane();
        
        Label text = new Label("Turn: X");   
        text.setFont(new Font("Arial", 24));
        
        Button button00 = new Button();
        Button button01 = new Button();
        Button button02 = new Button();
        Button button10 = new Button();
        Button button11 = new Button();
        Button button12 = new Button();
        Button button20 = new Button();
        Button button21 = new Button();
        Button button22 = new Button();
        
        List<Button> listButtons = new ArrayList<>();
        listButtons.add(button00);
        listButtons.add(button01);
        listButtons.add(button02);
        listButtons.add(button10);
        listButtons.add(button11);
        listButtons.add(button12);
        listButtons.add(button20);
        listButtons.add(button21);
        listButtons.add(button22);
        
        int x=0;
        int y=0;
        for(Button button:listButtons){
            button.setPrefSize(50, 50);
            buttons.add(button,y,x);
            if(y==2){
                y=0;
                x++;
            }else{
                y++;
            }            
        }
        
        buttons.setVgap(30);
        buttons.setHgap(30);
        
        
        layout.setTop(text);
        layout.setCenter(buttons);
        layout.setPadding(new Insets(10,10,10,10));
        layout.setPrefSize(250, 250);
        
        Scene scene = new Scene(layout);
        
        button00.setOnAction((event)->{
            logic(button00,0,0,ticTacToe,text,listButtons);
        });
        
        button01.setOnAction((event)->{
            logic(button01,0,1,ticTacToe,text,listButtons);
        });
        
        button02.setOnAction((event)->{
            logic(button02,0,2,ticTacToe,text,listButtons);
        });
        
        button10.setOnAction((event)->{
            logic(button10,1,0,ticTacToe,text,listButtons);
        });
        
        button11.setOnAction((event)->{
            logic(button11,1,1,ticTacToe,text,listButtons);
        });
        
        button12.setOnAction((event)->{
            logic(button12,1,2,ticTacToe,text,listButtons);
        });
        
        button20.setOnAction((event)->{
            logic(button20,2,0,ticTacToe,text,listButtons);
        });
        
        button21.setOnAction((event)->{
            logic(button21,2,1,ticTacToe,text,listButtons);
        });
        
        button22.setOnAction((event)->{
            logic(button22,2,2,ticTacToe,text,listButtons);
        });
                       
        window.setScene(scene);
        window.show();
    }
    
    public void logic(Button button, int x, int y, TicTacToe ticTacToe, Label text,List<Button> buttons){
        String nextPlayer;
        if(ticTacToe.getPlayer()==1){
            button.setText("X");
            nextPlayer = "O";
        }else{
            button.setText("O");
            nextPlayer = "X";
        }
        button.setDisable(true);
        ticTacToe.move(x,y);
        if(ticTacToe.win()){
            text.setText("The end!");
            disable(buttons);
        }else{
            if(ticTacToe.getPlays() == 9){
                text.setText("Draw!");
            }else{
                text.setText("Turn: "+nextPlayer);
            }
        }
    }
    
    public void disable(List<Button> buttons){
        for(Button button:buttons){
            button.setDisable(true);
        }
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

}
