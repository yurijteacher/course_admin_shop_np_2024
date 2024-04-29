package ua.com.kneu.course_admin_shop_np_2024.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    // https://javarush.com/ua/groups/posts/uk.2007.legkiy-parsing-html-za-dopomogoju-soup
    // https://jsoup.org

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        Document document;

        try {
            document = Jsoup.connect("https://rozetka.com.ua/ua/notebooks/c80004/producer=apple/")
                    .userAgent("Chrome/4.0.249.0 Safari/532.5")
                    .referrer("http://www.google.com.ua")
                    .get();

            Elements elements = document.select("[class='goods-tile__inner']");

            for (Element e : elements) {

                String name = "";
                String description = "";
                String price = "";

                name = e.select("[class='goods-tile__title']").text();
                description = e.select("[class='goods-tile__availability goods-tile__availability--available ng-star-inserted']").text();
                String description2 = e.select("[class='goods-tile__availability goods-tile__availability--unavailable ng-star-inserted']").text();
                price = e.select("[class='goods-tile__price-value']").text();

                price = price.replaceAll("[^0-9\\.]+", "");


                Pattern pattern = Pattern.compile("\\([A-Z0-9/]+\\)");
                Matcher matcher = pattern.matcher(name);

//                products.add(new Product(name, (description == null) ? description2 : description, Double.valueOf(price)));

                products.add(new Product(matcher.find() ? matcher.group(0).replaceAll("\\(|\\)","") : "",  name +"," + ((description == null) ? description2 : description), Double.valueOf(price)));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Product product : products) {
            System.out.println(product + "\n");
        }

        new CopyToFile().print(products);

    }


}
