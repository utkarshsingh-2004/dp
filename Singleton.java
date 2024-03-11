//Lazy initialization defers the creation of the singleton instance until it's actually needed, improving //efficiency by avoiding unnecessary instantiation until requested.
class DemoSingleThread {
public static void main(String[] args) {
    System.out.println("If you see the same value, hen singleton was resued " + "\n" + "If yu see the different values, then 2 Singleton were created " +"\n\n" + "RESULT: " + "\n");
    Singleton singleton = Singleton.getInstance("Yeah Got It !!!!");
    Singleton anotherSingleton = Singleton.getInstance("Something wet Wrong.");
    System.out.println(singleton.value);
    System.out.println(anotherSingleton.value);
}
}
final class Singleton {
    private static Singleton instance;
    public String value;
    private Singleton(String value){
        try{
            Thread.sleep(1000);
        }
        // catch(InterruptedException ex){
        //     ex.printStackTrace();
        // }
        catch(Exception e){}
        this.value = value;
    }
    public static Singleton getInstance(String value){
        if(instance == null){instance = new Singleton(value);}
        return instance;
    }
}