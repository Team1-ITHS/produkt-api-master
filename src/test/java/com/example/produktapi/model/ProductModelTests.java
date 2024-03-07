package com.example.produktapi.model;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductModelTests {

    // Samuel
    @Test
    @DisplayName("Product title get-method")
    void getTitleTest() {
        Product product = new Product("Test Title", 99.99, "Test Category", "This is a test description","image.jpg");
        Assertions.assertEquals("Test Title", product.getTitle());
    }

    // Samuel
    @Test
    @DisplayName("Product title set-method with correct value")
    void setTitleCorrectValue(){
        Product product = new Product("Test Title", 99.99, "Test Category", "This is a test description","image.jpg");
        product.setTitle("New value");
        Assertions.assertEquals("New value", product.getTitle());
    }

    // Samuel
    @Test
    @DisplayName("Product title set-method with extra white spaces")
    void setTitleWithExtraWhiteSpaces(){
        Product product = new Product("  Test Title   ", 99.99, "Test Category", "This is a test description","image.jpg");
        Assertions.assertEquals("  Title   ", product.getTitle()); // Method should be updated to remove extra white spaces
    }

    // Samuel
    @Test
    @DisplayName("Product title set-method with special characters")
    void setTitleWithSpecialCharacters(){
        Product product = new Product("!#¤%=?@£$€", 99.99, "Test Category", "This is a test description","image.jpg");
        Assertions.assertEquals("!#¤%=?@£$€", product.getTitle()); // Method should be updated to only allow certain characters
    }

    // Samuel
    @Test
    @DisplayName("Product title set-method with empty string")
    void setTitleWithEmptyString(){
        Product product = new Product("", 99.99, "Test Category", "This is a test description","image.jpg");
        Assertions.assertEquals("", product.getTitle()); // Method should be updated to not allow empty string as title
    }

    // Samuel
    @Test
    @DisplayName("Product title set-method with too long string")
    void setTitleWithLongString(){
        Product product = new Product("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", 99.99, "Test Category", "This is a test description","image.jpg");
        Assertions.assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", product.getTitle()); // Method should be updated to only allow a set string length
    }

    // Samuel
    @Test
    @DisplayName("Product title set-method with null")
    void setTitleWithNull(){
        Product product = new Product(null, 99.99, "Test Category", "This is a test description","image.jpg");
        Assertions.assertNull(product.getTitle()); // Method should be updated to not allow title as null
    }

    // Adding a test method just for testing imports and packages
    @Test
    @DisplayName("Testing")
    void testMethod(){
        Assertions.assertTrue(true);
    }

}
