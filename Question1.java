import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class Question1 {
    WebDriver driver;


    public void setup(){
        //Setuping the webdriver
        System.setProperty("webdriver.chrome.driver","/Users/cchoudhary/Downloads/chromedriver_mac64 (1)/chromedriver");
        driver =new ChromeDriver();
        //launch the website
        driver.navigate().to("https://www.saucedemo.com/");
        //Add implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void maximizeWindow(){
        //To maximize the window
        driver.manage().window().maximize();
    }
    public void enterDetails() throws InterruptedException{
        //To enter login credentials
        //For entering username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        //for entering password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(1000);
        Thread.sleep(1000);
        //For Click on submit
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }
    public void addToCart() throws InterruptedException{
        //Add item to carts
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
        scrollByCmd();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']")).click();
    }
    public void scrollByCmd(){
        //To scroll the window
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,200)");
    }
    public void checkOutProcess(){
        //To check out the process
        String parent= driver.getWindowHandle();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        // To click checkout button
        driver.findElement(By.xpath("//button[@id='checkout']")).click();

    }
    public void addInformation() throws InterruptedException{
        // add information
        //To enter name
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Chitranshi");
        //To enter lastname
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Choudhary");
        //To enter postal-code
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("456010");
        Thread.sleep(1000);
       //To click continue
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        scrollByCmd();//scrolldown the window
        //To Print total of all the items
        WebElement total=driver.findElement(By.xpath("//div[@class='summary_total_label']"));
        System.out.println("Total: "+total.getText());
        Thread.sleep(1000);
        //Finish the checkout process
        driver.findElement(By.xpath("//button[@id='finish']")).click();
        Thread.sleep(1000);
        //redirect to product  page
        driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
    }
    public void negativeCase() throws InterruptedException{
        //for negative test case
        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("locked_out_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }
    public void printErrorMessage () throws InterruptedException{
        //print error message
        Thread.sleep(9000);
        WebElement msg=driver.findElement(By.cssSelector("h3[data-test='error']"));
        System.out.println("Error message for negative testcase: ");
        System.out.println(msg.getText());
    }

    public static void main(String args[]) throws InterruptedException{
        Question1 q=new Question1();

        q.setup();
        q.maximizeWindow();
        Thread.sleep(2000);
        q.enterDetails();
        Thread.sleep(2000);
        q.addToCart();
        Thread.sleep(2000);
        q.checkOutProcess();
        Thread.sleep(2000);
        q.addInformation();
        Thread.sleep(2000);
        q.negativeCase();
        Thread.sleep(2000);
        q.printErrorMessage();

    }
}
