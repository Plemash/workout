import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ParserHtml {
    private String saveDir = "C:/Skillbox/11/FilesAndNetwork/HTML_Parser/images/";


    public void getUrlImage(String html) throws IOException {
        Document document = Jsoup.parse(new URL(html), 3000);
        Elements img = document.select("img");
        String urlImage = "";
        String nameImage;
        int indexName;
        for (Element el : img) {
            urlImage = el.absUrl("src");
            indexName = urlImage.lastIndexOf("/");
            nameImage = urlImage.substring(indexName).replaceAll("/", "");
            if (fileType(urlImage)) {
                System.out.println("Сохранили картинку с именем: "
                        + nameImage);
                saveImages(urlImage, nameImage);
            } else {
                System.out.println("Файл по ссылке не картинка!");
            }
        }
    }

    private void saveImages(String url, String nameImage) {
        try {
            InputStream inputStream = new URL(url).openStream();
            Files.copy(inputStream, Paths.get(saveDir + nameImage)
                    , StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + " Файл не скачан");
        }
    }

    private boolean fileType(String url) {
        int indexType = url.lastIndexOf(".");
        String nameType = url.substring(indexType);
        return nameType.equals(".jpeg") || nameType.equals(".jpg") || nameType.equals(".webp");
    }
}


