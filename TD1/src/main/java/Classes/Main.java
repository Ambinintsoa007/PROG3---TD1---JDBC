package Classes;

import java.time.Instant;

public class Main {
    public static void main(String[] args) throws Exception {

        DataRetriever dataRetriever = new DataRetriever(new DBConnection());

        //test getAllCategories
        System.out.println("\n=== a- getAllCategories ===");
        System.out.println(dataRetriever.getAllCategories());

        // getProductList
        System.out.println("\n=== b1) getProductList(1, 10) ===");
        System.out.println(dataRetriever.getProductList(1, 10));

        System.out.println("\n=== b2) getProductList(1, 5) ===");
        System.out.println(dataRetriever.getProductList(1, 5));

        System.out.println("\n=== b3) getProductList(1, 3) ===");
        System.out.println(dataRetriever.getProductList(1, 3));

        System.out.println("\n=== b4) getProductList(2, 2) ===");
        System.out.println(dataRetriever.getProductList(2, 2));

        //getProductsByCriteria
        System.out.println("\n=== c1- productName='Dell' ===");
        System.out.println(dataRetriever.getProductsByCriteria("Dell", null, null, null));

        System.out.println("\n=== c2- categoryName='info' ===");
        System.out.println(dataRetriever.getProductsByCriteria(null, "info", null, null));

        System.out.println("\n=== c3- productName='iPhone', categoryName='mobile' ===");
        System.out.println(dataRetriever.getProductsByCriteria("iPhone", "mobile", null, null));

        System.out.println("\n=== c4- date entre 2024-02-01 et 2024-03-01 ===");
        System.out.println(
                dataRetriever.getProductsByCriteria(
                        null, null,
                        Instant.parse("2024-02-01T00:00:00Z"),
                        Instant.parse("2024-03-01T00:00:00Z")
                )
        );

        System.out.println("\n=== c5- productName='Samsung', categoryName='bureau' ===");
        System.out.println(dataRetriever.getProductsByCriteria("Samsung", "bureau", null, null));

        System.out.println("\n=== c6- productName='Sony', categoryName='informatique' ===");
        System.out.println(dataRetriever.getProductsByCriteria("Sony", "informatique", null, null));

        System.out.println("\n=== c7- categoryName='audio', date 2024-01-01 → 2024-12-01 ===");
        System.out.println(
                dataRetriever.getProductsByCriteria(
                        null, "audio",
                        Instant.parse("2024-01-01T00:00:00Z"),
                        Instant.parse("2024-12-01T00:00:00Z")
                )
        );

        System.out.println("\n=== c8- aucun critère ===");
        System.out.println(dataRetriever.getProductsByCriteria(null, null, null, null));

        //getProductsByCriteri
        System.out.println("\n=== d1) criteria(productName='Dell'), page=1, size=3 ===");
        System.out.println(
                dataRetriever.getProductsByCriteria("Dell", null, null, null, 1, 3)
        );

        System.out.println("\n=== d2) criteria(category='info'), page=2, size=2 ===");
        System.out.println(
                dataRetriever.getProductsByCriteria(null, "info", null, null, 2, 2)
        );

        System.out.println("\n=== d3) criteria(date 2024-01-01 → 2024-12-31), page=1, size=5 ===");
        System.out.println(
                dataRetriever.getProductsByCriteria(
                        null, null,
                        Instant.parse("2024-01-01T00:00:00Z"),
                        Instant.parse("2024-12-31T00:00:00Z"),
                        1, 5
                )
        );
    }
}
