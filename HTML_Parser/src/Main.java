import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String html = " https://lenta.ru";
        ParserHtml parserHtml = new ParserHtml();
        parserHtml.getUrlImage(html);

    }
}
