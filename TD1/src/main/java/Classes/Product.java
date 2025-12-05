package Classes;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class Product {
    int id;
    String name;
    Instant creationDateTime;
    Category category;

    public String getCategoryName() {
        return category.getName();
    }
}
