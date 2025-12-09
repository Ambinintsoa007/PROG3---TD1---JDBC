package Classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Category {
    int id;
    String name;
    int product_id;
}
