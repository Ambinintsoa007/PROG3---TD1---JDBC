import Classes.*;
import org.junit.jupiter.api.Test;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

public class DataRetrieverTest {

    DBConnection dbConnect = new DBConnection();
    DataRetriever dataRetriever = new DataRetriever(dbConnect);

    @Test
    void testA_getAllCategories() throws Exception {
        assertNotNull(dataRetriever.getAllCategories());
    }

    @Test
    void testB1_getProductList_1_10() throws Exception {
        assertNotNull(dataRetriever.getProductList(1, 10));
    }

    @Test
    void testB2_getProductList_1_5() throws Exception {
        assertNotNull(dataRetriever.getProductList(1, 5));
    }

    @Test
    void testB3_getProductList_1_3() throws Exception {
        assertNotNull(dataRetriever.getProductList(1, 3));
    }

    @Test
    void testB4_getProductList_2_2() throws Exception {
        assertNotNull(dataRetriever.getProductList(2, 2));
    }

    @Test
    void testC1_productName_Dell() throws Exception {
        assertNotNull(dataRetriever.getProductsByCriteria("Dell", null, null, null));
    }

    @Test
    void testC2_category_info() throws Exception {
        assertNotNull(dataRetriever.getProductsByCriteria(null, "info", null, null));
    }

    @Test
    void testC3_product_iPhone_category_mobile() throws Exception {
        assertNotNull(dataRetriever.getProductsByCriteria("iPhone", "mobile", null, null));
    }

    @Test
    void testC4_date_2024_02_to_03() throws Exception {
        assertNotNull(dataRetriever.getProductsByCriteria(
                null, null,
                Instant.parse("2024-02-01T00:00:00Z"),
                Instant.parse("2024-03-01T00:00:00Z")
        ));
    }

    @Test
    void testC5_product_Samsung_category_bureau() throws Exception {
        assertNotNull(dataRetriever.getProductsByCriteria("Samsung", "bureau", null, null));
    }

    @Test
    void testC6_product_Sony_category_informatique() throws Exception {
        assertNotNull(dataRetriever.getProductsByCriteria("Sony", "informatique", null, null));
    }

    @Test
    void testC7_category_audio_dateRange() throws Exception {
        assertNotNull(dataRetriever.getProductsByCriteria(
                null, "audio",
                Instant.parse("2024-01-01T00:00:00Z"),
                Instant.parse("2024-12-01T00:00:00Z")
        ));
    }

    @Test
    void testC8_noCriteria() throws Exception {
        assertNotNull(dataRetriever.getProductsByCriteria(null, null, null, null));
    }

    @Test
    void testD1_nameDell_page1_size3() throws Exception {
        assertNotNull(dataRetriever.getProductsByCriteria("Dell", null, null, null, 1, 3));
    }

    @Test
    void testD2_categoryInfo_page2_size2() throws Exception {
        assertNotNull(dataRetriever.getProductsByCriteria(null, "info", null, null, 2, 2));
    }

    @Test
    void testD3_dateRange_page1_size5() throws Exception {
        assertNotNull(dataRetriever.getProductsByCriteria(
                null, null,
                Instant.parse("2024-01-01T00:00:00Z"),
                Instant.parse("2024-12-31T00:00:00Z"),
                1, 5
        ));
    }
}
