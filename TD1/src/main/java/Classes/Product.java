package Classes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

@Getter
@AllArgsConstructor
@ToString
public class Product {
    int id;
    String name;
    double price;
    Instant creationDateTime;
    Category category;

    public String getCategoryName() {
        return category.getName();
    }
}
