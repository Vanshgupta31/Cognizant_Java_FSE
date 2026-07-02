public class SingletonPattern {

    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.displayMessage();

        if (logger1 == logger2) {
            System.out.println("Only one Logger object has been created.");
        } else {
            System.out.println("More than one Logger object exists.");
        }
    }
}