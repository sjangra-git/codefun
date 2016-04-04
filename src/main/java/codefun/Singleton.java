package codefun;

public class Singleton
{

    private static Singleton INSTANCE = new Singleton();
    
    public static Singleton getInstance()
    {
        return INSTANCE;
    }
}
