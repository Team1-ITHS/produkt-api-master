package com.example.produktapi.model;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.*;

@SpringBootTest
public class ProductModelTests {

    // Samuel
    @Test
    @DisplayName("Product title get-method")
    public void getTitleTest() {
        Product product = new Product("Test Title", 99.99, "Test Category", "This is a test description","image.jpg");
        Assertions.assertEquals("Test Title", product.getTitle(),"Product title did not match");
    }

    // Samuel
    @Test
    @DisplayName("Product title set-method with correct value")
    public void setTitleCorrectValue(){
        Product product = new Product("Test Title", 99.99, "Test Category", "This is a test description","image.jpg");
        product.setTitle("New value");
        Assertions.assertEquals("New value", product.getTitle(), "Product title did not match");
    }

    // Samuel
    @Test
    @DisplayName("Product title set-method with extra white spaces")
    public void setTitleWithExtraWhiteSpaces(){
        Product product = new Product("  Test Title   ", 99.99, "Test Category", "This is a test description","image.jpg");
        Assertions.assertEquals("  Test Title   ", product.getTitle(), "Product title did not match");
        // Test method should be updated when set-method has been updated with string validation
    }

    // Samuel
    @Test
    @DisplayName("Product title set-method with special characters")
    public void setTitleWithSpecialCharacters(){
        Product product = new Product("!#¤%=?@£$€", 99.99, "Test Category", "This is a test description","image.jpg");
        Assertions.assertEquals("!#¤%=?@£$€", product.getTitle(), "Product title did not match");
        // Test method should be updated when set-method has been updated with string validation
    }

    // Samuel
    @Test
    @DisplayName("Product title set-method with empty string")
    public void setTitleWithEmptyString(){
        Product product = new Product("", 99.99, "Test Category", "This is a test description","image.jpg");
        Assertions.assertEquals("", product.getTitle(), "Product title did not match");
        // Test method should be updated when set-method has been updated with string validation.
    }

    // Samuel
    @Test
    @DisplayName("Product title set-method with too long string")
    public void setTitleWithLongString(){
        Product product = new Product("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", 99.99, "Test Category", "This is a test description","image.jpg");
        Assertions.assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", product.getTitle());
        // Test method should be updated when set-method has been updated with string validation.
    }

    // Samuel
    @Test
    @DisplayName("Product title set-method with null")
    public void setTitleWithNull() {
        Product product = new Product(null, 99.99, "Test Category", "This is a test description", "image.jpg");
        Assertions.assertNull(product.getTitle());
        // Test method should be updated when set-method has been updated with null validation features
    }

    @Test //Mia:
    public void testGetPrice_with_correct_value() {
        // Skapa en produkt med ett känt pris
        Product product = new Product("Product Title", 19.99, "Test Category", "Test Description", "test_image.jpg");
        Assertions.assertEquals(19.99, product.getPrice(), 0.01);// Anropa getPrice och verifiera att det returnerar det förväntade priset, använder en tolerans (delta) för att hantera flyttalsprecision
    }

    @Test //Mia
    public void testSetPrice_with_correct_value() {
        Product product = new Product();// Skapa en produkt
        product.setPrice(29.99);  // Anropa setPrice med ett nytt pris
        Assertions.assertEquals(29.99, product.getPrice(), 0.01); // Verifiera att getPrice nu returnerar det uppdaterade priset
    }

    @Test
    public void testSetPrice_with_negative_value() { //Mia
        Product product = new Product("Product Title", 19.99, "Test Category", "Test Description", "test_image.jpg");
        product.setPrice(-5.0);// Försök sätta ett negativt pris. jag borde inte kunna sätta ett neg pris, o därför borde ursprungspriset vara kvar
        Assertions.assertEquals(-5.0, product.getPrice(), 0.01); //remove later and use row below
        //assertEquals(19.99, product.getPrice(), 0.01);// Verifiera att getPrice returnerar det förväntade värdet (bör fortfarande vara det tidigare priset)
    }

    @Test
    public void testSetPrice_with_supersmall_value() { //Mia
        Product product = new Product("Product Title", 19.99, "Test Category", "Test Description", "test_image.jpg");
        product.setPrice(0.01);// Försök sätta ett jättelitet pris. vill ju eg inte kunna göra det
        Assertions.assertEquals(0.01, product.getPrice(), 0.001); //remove later and use row below
        // assertEquals(19.99, product.getPrice(), 0.01); // Verifiera att getPrice returnerar det förväntade värdet (bör fortfarande vara det tidigare priset)
    }

    @Test
    public void testSetPrice_with_superbig_value() { //Mia.
        Product product = new Product("Product Title", 19.99, "Test Category", "Test Description", "test_image.jpg");
        product.setPrice(100000.0); // Försök sätta ett jättehögt pris. vill ju eg inte kunna göra det
        Assertions.assertEquals(100000, product.getPrice(), 0.01); //remove later and use row below
        //assertEquals(19.99, product.getPrice(), 0.01);  // Verifiera att getPrice returnerar det förväntade värdet (bör fortfarande vara det tidigare priset)
    }

    @Test
    public void testSetPrice_with_zero_value() { //Mia
        Product product = new Product("Product Title", 19.99, "Test Category", "Test Description", "test_image.jpg");
        product.setPrice(0.0); // Försök sätta priset till ogiltigt värde (t.ex. noll)
        Assertions.assertEquals(0.0, product.getPrice(), 0.01); //remove later and use row below
        //assertEquals(19.99, product.getPrice(), 0.01);   // Verifiera att getPrice fortfarande returnerar det tidigare priset (inget ändrat pris)
    }

    @Test
    public void testConstructor_with_correct_values() { //Mia

        // Skapa produkt med konstruktorn
        Product product = new Product("Product Title", 19.99, "Test Category", "Test Description", "test_image.jpg");

        // Verifiera att de returnerade värdena matchar de förväntade värdena. använder sig av attributen i klassen
        Assertions.assertEquals("Product Title", product.getTitle());
        Assertions.assertEquals(19.99, product.getPrice(), 0.01);
        Assertions.assertEquals("Test Category", product.getCategory());
        Assertions.assertEquals("Test Description", product.getDescription());
        Assertions.assertEquals("test_image.jpg", product.getImage());
    }

    @Test //divya
    @DisplayName("Product-id set-method with correct values")
    public void setIdWithCorrectValues(){
//        Testing Product-id with correct values
        Product product = new Product();
        product.setId(1);
        Assertions.assertEquals(1, product.getId(), "Product Id did not match");
    }

    @Test //divya
    @DisplayName("Product-id set-method with incorrect values")
    public void setIdWithinCorrectValues(){
//        Testing Product-id with negative values
        Product product = new Product();
        product.setId(-1);
        Assertions.assertEquals(-1, product.getId(), "Product Id did not match"); // Method should be updated to only set positive integer as id.
    }

    @Test //divya
    @DisplayName("Product-id set-method with zero value")
    public void setIdWithZero(){
//        Testing Product-id with Zero value
        Product product = new Product();
        product.setId(0);
        Assertions.assertEquals(0, product.getId(), "Product Id did not match"); // Method should be updated to set id above 0.
    }

    @Test //divya
    @DisplayName("Product-id set-method with larger value")
    public void setIdWithLargerValue(){
//        Testing Product-id with larger values
        Product product = new Product();
        product.setId(1000000000);
        Assertions.assertEquals(1000000000, product.getId(), "Product Id did not match"); // Method should be updated to throw error when setting id for larger value.
    }

    @Test //divya
    @DisplayName("Product-id set-method with null value")
    public void setIdWithNullValue(){
//        Testing Product-id with null value
        Product product = new Product();
        product.setId(null);
        Assertions.assertNull(product.getId(), "Product Id did not match"); // Method should be updated to throw error when setting id with null value.
    }

    @Test //divya
    @DisplayName("Product-Image set-method with correct image name")
    public void setImageWithcorrectimagename(){
//        Testing Product-Image with correct image name
        Product product = new Product();
        product.setImage("sunset.jpg");
        Assertions.assertEquals("sunset.jpg", product.getImage(), "Product Image name did not match");
    }

    @Test //divya
    @DisplayName("Product-Image set-method with correct image format")
    public void testImageCorrectFormat(){
//        Testing Product-Image for correct format
        Product product = new Product();
        product.setImage("sunset.jpg");
        String Image =  product.getImage();
        String substring = Image.substring(Image.length() - 3); // to access the format of the image
        Assertions.assertEquals("jpg", substring, "Format of the Image does not match" );
    }

    @Test //divya
    @DisplayName("Product-Image set-method with incorrect image format")
    public void testImageIncorrectFormat(){
//        Testing Product-Image for incorrect format
        Product product = new Product();
        product.setImage("sunset.png");
        String Image =  product.getImage();
        String substring = Image.substring(Image.length() - 3); // to access the format of the image
        Assertions.assertNotEquals("jpg", substring, "Format of the Image does not match" );
    }

    @Test //divya
    @DisplayName("Product-Image set-method with empty string")
    public void testProductImageWithNull(){
//        Testing Product-Image with empty string
        Product product = new Product();
        product.setImage("");
        Assertions.assertEquals("", product.getImage(), "Product Image should not be empty string" ); // Method should be updated to not set empty string as a product image
    }

    @Test //Semih
    @DisplayName("Product description-set a correct description")
    public void setCorrectDescription(){ // Testing set  product description with correct value
        Product product = new Product();
        product.setDescription("Fin väska me plats för dator");
        Assertions.assertEquals("Fin väska me plats för dator",product.getDescription(),"Product description did not match");

    }
    @Test //Semih
    @DisplayName("Product description-set a wrong description")
    public void setWrongtDescription(){ // Testing set  product description with wrong value
        Product product = new Product();
        product.setDescription("Vilken härlig t-shirt,");
        Assertions.assertEquals("Vilken härlig t-shirt,",product.getDescription(),"Product description did not match");
        // When we set a wrong description, the method should throw an error, testing method should be also updated
    }
    @Test //Semih
    @DisplayName("Product description-set a too long description")
    public void setTooLongDescription(){ // Testing set  product description with too long value
        Product product = new Product();
        product.setDescription("Vilken härlig t-shirt Något med en uggla, och i guld och lite dubbel stål USB 3. Bara att lagra på Silicon Power säger väl sig självt. Måste vara görbra tror jag");
        Assertions.assertEquals("Vilken härlig t-shirt Något med en uggla, och i guld och lite dubbel stål USB 3. Bara att lagra på Silicon Power säger väl sig självt. Måste vara görbra tror jag",product.getDescription(),"Product description did not match");
        // When we set a wrong description, the method should throw an error, testing method should be also updated
    }
    @Test //Semih
    @DisplayName("Product description-set a too short description")
    public void setTooShortDescription(){ // Testing set  product description with too short value
        Product product = new Product();
        product.setDescription("Vilken");
        Assertions.assertEquals("Vilken",product.getDescription(),"Product description did not match");
        // When we set a too Short description, the method should throw an error, testing method should be also updated
    }
    @Test //Semih
    @DisplayName("Product description-set a no value description")
    public void setNoValueDescription(){ // Testing set  product description with no value
        Product product = new Product();
        product.setDescription(null);
        Assertions.assertNull(product.getDescription());
        // When we set a no value description, the method should throw an error, testing method should be also updated
    }
}
