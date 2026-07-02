interface Document {

    void open();
}

class WordDocument implements Document {

    @Override
    public void open() {
        System.out.println("Word document created.");
    }
}

class PdfDocument implements Document {

    @Override
    public void open() {
        System.out.println("PDF document created.");
    }
}

class ExcelDocument implements Document {

    @Override
    public void open() {
        System.out.println("Excel document created.");
    }
}

class DocumentFactory {

    public static Document getDocument(String type) {

        if (type.equalsIgnoreCase("word")) {
            return new WordDocument();
        } else if (type.equalsIgnoreCase("pdf")) {
            return new PdfDocument();
        } else if (type.equalsIgnoreCase("excel")) {
            return new ExcelDocument();
        }

        return null;
    }
}

public class FactoryMethod {

    public static void main(String[] args) {

        Document word = DocumentFactory.getDocument("word");
        Document pdf = DocumentFactory.getDocument("pdf");
        Document excel = DocumentFactory.getDocument("excel");

        word.open();
        pdf.open();
        excel.open();
    }
}