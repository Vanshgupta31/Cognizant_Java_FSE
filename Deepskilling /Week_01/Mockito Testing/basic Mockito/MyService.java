public class MyService {

    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }

    public String fetchUser(int id) {
        return api.getUser(id);
    }

    public void fetchUser() {
        api.getUser();
    }

    public String fetchMultipleData() {
        return api.getData();
    }

    public String fetchDataWithConnection() {

        api.connect();

        String data = api.getData();

        api.disconnect();

        return data;
    }
}
