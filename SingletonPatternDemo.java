//Singleton pattern ensures that a class has only one instance and provides a global point of access //to that instance, usually instantiated eagerly for immediate use.
class SingleObject{
    private static SingleObject instance = new SingleObject();
    private SingleObject(){}
    public static SingleObject getInstance(){
        return instance;
    }
    public void showMessage(){
        System.out.println("Hello world");
    }
}public class SingletonPatternDemo {
    public static void main(String[] args) {
        SingleObject object = SingleObject.getInstance();
        object.showMessage();
    }
}