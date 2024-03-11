abstract class Game {  
      
    abstract void initialize();  
    abstract void start();  
    abstract void end();  
   
    public final void play(){  

       initialize();  

       start();  
         
       end();  
    }  
}


class Cricket extends Game {  
    @Override  
      void initialize() {  
         System.out.println("Cricket Game Initialized! Start playing.");  
      }  
    @Override  
      void start() {  
         System.out.println("Game Started. Welcome to in the Cricket game!");  
      }  
   @Override  
      void end() {  
         System.out.println("Game Finished!");  
      }  
}

class Football extends Game {  
      
    @Override  
       void initialize() {  
          System.out.println("Football Game Initialized! Start playing.");  
       }  
  
    @Override  
       void start() {  
          System.out.println("Game Started. Welcome to in the Football game!");  
       }  
         
    @Override  
       void end() {  
          System.out.println("Game Finished!");  
       }  
}


public class TemplatePatternDemo {
  public static void main(String[] args)  {
    Game game = new Cricket();
    game.play();
    System.out.println();
    game = new Football();
    game.play();
  }
}