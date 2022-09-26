
/**This file is used to define a GameState class and implement some method
to set the board and move the tiles on the board.
Name: Huaner Wang  Email: huw005@ucsd.edu

*/

import java.util.Random;

/*This class is used to set the board, move the tiles and get the Score

*/
public class GameState{
  private Random rng;
  private int[][] board;
  private int score;

  Random rand=new Random();
  // REQUIRED - put this in your GameState.java
  public String toString () {
      StringBuilder outputString = new StringBuilder();
      outputString.append(String.format("Score: %d\n", getScore()));
      for (int row = 0; row < getBoard().length; row++) {
          for (int column = 0; column < getBoard()[0].length; column++) {
              outputString.append(getBoard()[row][column] == 0 ? "    -" :
                  String.format("%5d", getBoard()[row][column]));
          }
          outputString.append("\n");
      }
      return outputString.toString();
  }
  /*constructor that create new object*/
public GameState (int numRows, int numCols){
  this.board=new int[numRows][numCols];
  this.score=0;
}
/*get the board we set with numbers*/
public int[][] getBoard (){
  int[][] newboard=new int[board.length][board[0].length];
  for(int row=0; row<board.length; row++){
    for(int col=0; col<board[row].length; col++){
      newboard[row][col]=this.board[row][col];
    }
  }return newboard;
}
/*set the board with numbers*/
public void setBoard (int[][] newBoard){
  if(newBoard==null){
    return;
  }
  this.board=new int[newBoard.length][newBoard[0].length];
  for(int row=0; row<newBoard.length;row++){
    for(int col=0; col<newBoard[0].length;col++){
      this.board[row][col]=newBoard[row][col];
    }
  }

}
/*get the score*/
public int getScore (){
  return this.score;
}
/*set score with new score*/
public void setScore (int newScore){
  this.score=newScore;
}
/*return a radom number within the input range*/
protected int rollRNG (int bound){
  return rand.nextInt(bound);
}
/*return 2 with 70% and 4 with 30%*/
protected int randomTile(){
boolean value = rand.nextInt(100) < Config.TWO_PROB;
if(value==true){
  return 2;
}else{
  return 4;
   }
}
/*count tile that equals to zero on the board*/
protected int countEmptyTiles (){
  int count=0;
  for(int row=0;row<this.board.length;row++){
    for(int col=0;col<this.board[row].length; col++){
      if (this.board[row][col]==0){
        count++;
      }
    }
  }return count;
}
/*add a new tile on the board when it's possible*/
protected int addTile (){
  if(countEmptyTiles()==0){
    return 0;
  }
  int boardlength=this.board.length;
  int boardwidth=this.board[0].length;
  int roll1=rollRNG(boardlength);
  int roll2=rollRNG(boardwidth);

  while(this.board[roll1][roll2]!=0){
     roll1=rollRNG(boardlength);
     roll2=rollRNG(boardwidth);
      }
      this.board[roll1][roll2]=randomTile();
      return this.board[roll1][roll2];



}
/*rotate the board rotateCounterClockwise once*/
protected void rotateCounterClockwise (){
  int[][] copy=new int[this.board.length][this.board[0].length];
  for(int row=0; row<this.board.length;row++){
    for(int col=0; col<this.board[row].length;col++){
      copy[row][col]=this.board[row][col];
      }
  }
  for(int row=0; row<this.board.length;row++){
    for(int col=0; col<this.board[row].length;col++){
      this.board[row][col]=copy[col][this.board[0].length-1-row];
      }
  }
}
/*check if the tile can slide down*/
protected boolean canSlideDown (){

  for(int column=0;column<this.board[0].length;column++){
    for(int row=0;row<this.board.length-1;row++){
      if(this.board[row][column]!=0){
        if(this.board[row][column]==this.board[row+1][column]||this.board[row+1][column]==0){
          return true;
        }
      }
    }

  }return false;

}
/*check if the tile can move anymore*/
public boolean isGameOver (){
boolean gameover=true;
if(canSlideDown()){
  gameover=false;
 return gameover;
}
rotateCounterClockwise();
if(canSlideDown()){
  gameover=false;
 return gameover;
}
if(this.canSlideDown()){
  gameover=false;
 return gameover;
}
this.rotateCounterClockwise();
if(this.canSlideDown()){
  gameover=false;
 return gameover;
}
return gameover;
}

/*slide the tile down and coun the score*/
protected boolean slideDown(){
 boolean flag=false;
  for(int col=0;col<board[0].length;col++){
      int scale=board.length-1;
      for(int row=board.length-2; row>=0;row--){
        if(canSlideDown()){
        int moveposition=row;//switch column to the top and row to the bottom
        if(board[row][col]!=0){
          int index=row+1;
         while(index<=board.length-1){
            if(board[index][col]==0){
             moveposition=index;
             }
           index+=1;
         }
         if(moveposition!=row){
           board[moveposition][col]=board[row][col];
           board[row][col]=0;

         }
         int belowitem=moveposition+1;

         if(belowitem<=scale){

            // System.out.println("y-1 "+board[moveposition][j]);
             //System.out.println("y "+board[y][col]);
             if(board[moveposition][col]==board[belowitem][col]){

             board[belowitem][col]*=2;
             board[moveposition][col]=0;
             scale=moveposition;
             System.out.println(score);
            // System.out.println("moveposition"+moveposition);
            // System.out.println("scale"+scale);
             score+=board[belowitem][col];

           }

         }

       }
       flag=true;
}
       }
     }System.out.println("return is "+flag);
      return flag;

    }


/*move the tile in different direction*/
public boolean move (Direction dir){

  if(dir==null){
    return false;
  }
  if(dir.getRotationCount()==0){

       slideDown();
       addTile();
       return true;//down
     }else if(dir.getRotationCount()==1){
//left
      rotateCounterClockwise();
      slideDown();
      rotateCounterClockwise();
      rotateCounterClockwise();
      rotateCounterClockwise();
      addTile();
      return true;
    }else if(dir.getRotationCount()==2){

       rotateCounterClockwise();
       rotateCounterClockwise();
       slideDown();
       rotateCounterClockwise();
       rotateCounterClockwise();
       addTile();
       return true;
     }else if(dir.getRotationCount()==3){
//right
       rotateCounterClockwise();
       rotateCounterClockwise();
       rotateCounterClockwise();
       slideDown();
       rotateCounterClockwise();
       addTile();
       return true;
}else{
    return false;
}


  //return false;
}


public static void main(String[] args){
  GameState gm=new GameState(4,4);
  int[][] hh=new int[][]{
    {4,0,0,0},
    {4,0,0,0},
    {8,0,0,0},
    {8,0,0,0}
  };
  gm.setBoard(hh);
boolean x=gm.slideDown();
//System.out.print(x);
  for(int i=0;i<gm.board.length;i++){

    for(int j=0;j<gm.board[i].length;j++){
      System.out.print(gm.board[i][j]);
    //  System.out.print(x);
    }System.out.println("\n");
  }
}
}
