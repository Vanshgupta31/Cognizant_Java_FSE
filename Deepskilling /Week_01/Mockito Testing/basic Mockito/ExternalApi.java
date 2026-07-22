public class ExternalApi {

    public String getData() {
        return "Real Data";
    }

    public String getUser(int id) {
        return "Real User";
    }

    public void getUser() {
        System.out.println("Real User...");
    }

    public void connect() {
        System.out.println("Connected");
    }

    public void disconnect() {
        System.out.println("Disconnected");
    }
}
