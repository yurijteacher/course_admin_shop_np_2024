package ua.com.kneu.course_admin_shop_np_2024.parser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CopyToFile {

    public void print(List<Product> products){

        try {
            FileWriter writer = new FileWriter("file.txt", false);

            for (Product product : products) {
                writer.write(product.toString() + "\n");
            }
            writer.flush();
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
