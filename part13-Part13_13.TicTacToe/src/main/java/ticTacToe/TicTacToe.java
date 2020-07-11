/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;


/**
 *
 * @author juan
 */
public class TicTacToe {
    
    private int[] rows;
    private int[] columns;
    private int[] diagonals;
    private int player;
    private int plays;
    
    public TicTacToe(){
        this.rows = new int[3];
        this.columns = new int[3];
        this.diagonals = new int[2];
        this.player = 1;
        this.plays = 0;
    }
    
    public void nextTurn(){
        if(this.player == 1){
           this.player = -1; 
        }else{
            this.player = 1;
        }
    }
      
    public void move(int x,int y){
        this.rows[x]+= this.player;
        this.columns[y] += this.player;
        if(x==y){
            this.diagonals[0] += this.player;
            if(x==1){
                this.diagonals[1] += this.player;
            }
        }
        if(y-x==2 || x-y == 2){
            this.diagonals[1] += this.player;
        }
        this.plays++;
        nextTurn();
    }
    
    public boolean win(){
        for(int i=0; i<3; i++){
            if(this.rows[i]==3 || this.rows[i]==-3 || 
                    this.columns[i]==3 || this.columns[i]==-3){
                return true;
            }
        }
        
        for(int i=0; i<2; i++){
            if(this.diagonals[i]==3 ||this.diagonals[i]== -3 ){
                return true;
            }
        }
        return false;   
    }
    
    public int getPlayer(){
        return this.player;
    }
    
    public int getPlays(){
        return this.plays;
    }
}
