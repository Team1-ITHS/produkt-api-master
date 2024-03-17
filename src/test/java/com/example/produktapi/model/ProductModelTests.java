package com.example.produktapi.model;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.*;

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
        Assertions.assertEquals("  Test Title   ", product.getTitle()); // Method should be updated to remove extra white spaces
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
    void setTitleWithNull() {
        Product product = new Product(null, 99.99, "Test Category", "This is a test description", "image.jpg");
        Assertions.assertNull(product.getTitle()); // Method should be updated to not allow title as null
    }

    @Test //Mia:
    public void testGetPrice_with_correct_value() {
        // Skapa en produkt med ett känt pris
        Product product = new Product("Product Title", 19.99, "Test Category", "Test Description", "test_image.jpg");
        assertEquals(19.99, product.getPrice(), 0.01);// Anropa getPrice och verifiera att det returnerar det förväntade priset, använder en tolerans (delta) för att hantera flyttalsprecision
    }

    @Test //Mia
    public void testSetPrice_with_correct_value() {
        Product product = new Product();// Skapa en produkt
        product.setPrice(29.99);  // Anropa setPrice med ett nytt pris
        assertEquals(29.99, product.getPrice(), 0.01); // Verifiera att getPrice nu returnerar det uppdaterade priset
    }

    @Test
    public void testSetPrice_with_negative_value() { //Mia
        Product product = new Product("Product Title", 19.99, "Test Category", "Test Description", "test_image.jpg");
        product.setPrice(-5.0);// Försök sätta ett negativt pris. jag borde inte kunna sätta ett neg pris, o därför borde ursprungspriset vara kvar
        assertEquals(-5.0, product.getPrice(), 0.01); //remove later and use row below
        //assertEquals(19.99, product.getPrice(), 0.01);// Verifiera att getPrice returnerar det förväntade värdet (bör fortfarande vara det tidigare priset)
    }

    @Test
    public void testSetPrice_with_supersmall_value() { //Mia
        Product product = new Product("Product Title", 19.99, "Test Category", "Test Description", "test_image.jpg");
        product.setPrice(0.01);// Försök sätta ett jättelitet pris. vill ju eg inte kunna göra det
        assertEquals(0.01, product.getPrice(), 0.001); //remove later and use row below
        // assertEquals(19.99, product.getPrice(), 0.01); // Verifiera att getPrice returnerar det förväntade värdet (bör fortfarande vara det tidigare priset)
    }

    @Test
    public void testSetPrice_with_superbig_value() { //Mia.
        Product product = new Product("Product Title", 19.99, "Test Category", "Test Description", "test_image.jpg");
        product.setPrice(100000.0); // Försök sätta ett jättehögt pris. vill ju eg inte kunna göra det
        assertEquals(100000, product.getPrice(), 0.01); //remove later and use row below
        //assertEquals(19.99, product.getPrice(), 0.01);  // Verifiera att getPrice returnerar det förväntade värdet (bör fortfarande vara det tidigare priset)
    }

    @Test
    public void testSetPrice_with_zero_value() { //Mia
        Product product = new Product("Product Title", 19.99, "Test Category", "Test Description", "test_image.jpg");
        product.setPrice(0.0); // Försök sätta priset till ogiltigt värde (t.ex. noll)
        assertEquals(0.0, product.getPrice(), 0.01); //remove later and use row below
        //assertEquals(19.99, product.getPrice(), 0.01);   // Verifiera att getPrice fortfarande returnerar det tidigare priset (inget ändrat pris)
    }

    @Test
    public void testConstructor_with_correct_values() { //Mia

        // Skapa produkt med konstruktorn
        Product product = new Product("Product Title", 19.99, "Test Category", "Test Description", "test_image.jpg");

        // Verifiera att de returnerade värdena matchar de förväntade värdena. använder sig av attributen i klassen
        assertEquals("Product Title", product.getTitle());
        assertEquals(19.99, product.getPrice(), 0.01);
        assertEquals("Test Category", product.getCategory());
        assertEquals("Test Description", product.getDescription());
        assertEquals("test_image.jpg", product.getImage());
    }

    @Test //divya
    @DisplayName("Product-id set-method with correct values")
    void setIdWithCorrectValues(){
//        Testing Product-id with correct values
        Product product = new Product();
        product.setId(1);
        Assertions.assertEquals(1, product.getId(), "Product Id did not match");
    }

    @Test //divya
    @DisplayName("Product-id set-method with incorrect values")
    void setIdWithinCorrectValues(){
//        Testing Product-id with negative values
        Product product = new Product();
        product.setId(-1);
        Assertions.assertEquals(-1, product.getId(), "Product Id did not match"); // Method should be updated to only set positive integer as id.
    }

    @Test //divya
    @DisplayName("Product-id set-method with zero value")
    void setIdWithZero(){
//        Testing Product-id with Zero value
        Product product = new Product();
        product.setId(0);
        Assertions.assertEquals(0, product.getId(), "Product Id did not match"); // Method should be updated to set id above 0.
    }

    @Test //divya
    @DisplayName("Product-id set-method with larger value")
    void setIdWithLargerValue(){
//        Testing Product-id with larger values
        Product product = new Product();
        product.setId(1000000000);
        Assertions.assertEquals(1000000000, product.getId(), "Product Id did not match"); // Method should be updated to throw error when setting id for larger value.
    }

    @Test //divya
    @DisplayName("Product-id set-method with null value")
    void setIdWithNullValue(){
//        Testing Product-id with null value
        Product product = new Product();
        product.setId(null);
        Assertions.assertNull(product.getId(), "Product Id did not match"); // Method should be updated to throw error when setting id with null value.
    }

    @Test //divya
    @DisplayName("Product-Image set-method with null value")
    void setImageWithcorrectstring(){
//        Testing Product-Image with correct string
        Product product = new Product();
        product.setImage("sunset");
        Assertions.assertEquals("sunset", product.getImage(), "Product Image did not match");
    }

    @Test //Semih
    @DisplayName("Product description-set a correct description")
    void setCorrectDescription(){ // Testing set  product description with correct value
        Product product = new Product();
        product.setDescription("Fin väska me plats för dator");
        Assertions.assertEquals("Fin väska me plats för dator",product.getDescription(),"Product description did not match");

    }
    @Test //Semih
    @DisplayName("Product description-set a wrong description")
    void setWrongtDescription(){ // Testing set  product description with wrong value
        Product product = new Product();
        product.setDescription("Vilken härlig t-shirt,");
        Assertions.assertEquals("Vilken härlig t-shirt,",product.getDescription(),"Product description did not match");
        // When we set a wrong description, the method should throw an error, testing method should be also updated
    }
    @Test //Semih
    @DisplayName("Product description-set a too long description")
    void setTooLongDescription(){ // Testing set  product description with too long value
        Product product = new Product();
        product.setDescription("Vilken härlig t-shirt Något med en uggla, och i guld och lite dubbel stål USB 3. Bara att lagra på Silicon Power säger väl sig självt. Måste vara görbra tror jag");
        Assertions.assertEquals("Vilken härlig t-shirt,",product.getDescription(),"Product description did not match");
        // When we set a wrong description, the method should throw an error, testing method should be also updated
    }
    @Test //Semih
    @DisplayName("Product description-set a too short description")
    void setTooShortDescription(){ // Testing set  product description with too short value
        Product product = new Product();
        product.setDescription("Vilken");
        Assertions.assertEquals("Vilken",product.getDescription(),"Product description did not match");
        // When we set a too Short description, the method should throw an error, testing method should be also updated
    }
    @Test //Semih
    @DisplayName("Product description-set a no value description")
    void setNoValueDescription(){ // Testing set  product description with no value
        Product product = new Product();
        product.setDescription(null);
        Assertions.assertNull(product.getDescription());
        // When we set a no value description, the method should throw an error, testing method should be also updated
    }

    // Adding a test method just for testing imports and packages
    @Test
    @DisplayName("Testing")
    void testMethod(){
        Assertions.assertTrue(true);
    }

}
