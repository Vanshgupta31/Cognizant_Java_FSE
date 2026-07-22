interface img {
    void display();
}

class RealImage implements img {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadserver();
    }

    public void loadserver() {
        System.out.println(
                "Loading image from remote server: "
                        + filename);

    }

    public void display() {
        System.out.println(
                "Displaying image: "
                        + filename);
    }
}

class proxy implements img {
    private RealImage im;

    private String filename;

    public proxy(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (im == null) {
            im = new RealImage(filename);
        }

        im.display();
    }
}

public class ProxyPattern {
    public static void main(String[] args) {
        img im = new proxy("img.jpg");

        System.out.println("img object Created");

        im.display();

        System.out.println();

        im.display();
    }
}