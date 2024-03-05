package com.example.produktapi.model;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductModelTests {

    private Product product;

    @BeforeEach
    void setup(){
        product = new Product("Test Title", 99.99, "Test Category", "This is a test description","image.jpg");
    }

    @Test
    @DisplayName("Testing Title get-method")
    void getTitleTest() {
        Assertions.assertEquals("Test Title", product.getTitle());
    }

    @Test
    @DisplayName("Testing Title set-method with correct value")
    void setTitleCorrectValue(){
        product.setTitle("New value");
        Assertions.assertEquals("New value", product.getTitle());
    }

    @Test
    @DisplayName("Testing Title set-method with special characters")
    void setTitleWithSpecialCharacters(){
        product.setTitle("!#¤%=?@£$€");
        Assertions.assertEquals("!#¤%=?@£$€", product.getTitle());
    }

    @Test
    @DisplayName("Testing Title set-method with empty string")
    void setTitleWithEmptyString(){
        product.setTitle("");
        Assertions.assertEquals("", product.getTitle());
    }

    @Test
    @DisplayName("Testing Title set-method with long string")
    void setTitleWithLongString(){
        product.setTitle("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua");
        Assertions.assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", product.getTitle());
    }

    @Test
    @DisplayName("Testing Title set-method with null")
    void setTitleWithNull(){
        product.setTitle(null);
        Assertions.assertNull(product.getTitle());
    }

    // Adding a test method just for testing imports and packages
    @Test
    @DisplayName("Testing")
    void testMethod(){
        Assertions.assertTrue(true);
    }

}
