package HomePage;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {

@Getter
WebDriver driver;

By logo = By.xpath("//a[@class='gtm-market-logo']");
By mobile = By.xpath("//p[normalize-space()='Mobiles']");
By slect_Location = By.xpath("//button[normalize-space()='Select Location']");
By Dhaka = By.xpath("//button[normalize-space()='Dhaka']");
By Mirpur = By.xpath("//button[normalize-space()='Mirpur']");
By topProduct = By.xpath("(//li[@class='top-ads-container--1Jeoq gtm-top-ad'])[1]");
By ProductDetails = By.xpath("//span[normalize-space()='For sale by']");
By Search = By.xpath("//input[@type='search']");
By MobilesSearch = By.xpath("//ol");
By Previous = By.xpath("(//div[@class='action-button--1O8tU'])[1]");
By Next = By.xpath("//div[normalize-space()='Next']");
By all_ads = By.xpath("//a[normalize-space()='All ads']");
By language = By.xpath("//button[contains(text(),'বাংলা')]");
By chat = By.xpath("//a[@aria-label='Chat']");
By login= By.xpath("//a[@aria-label='Login']");
By post_ad= By.xpath("//button[normalize-space()='POST FREE AD']");
By location= By.xpath("//span[normalize-space()='All of Bangladesh']");
By search = By.xpath("//input[@type='search']");
By search_icon = By.xpath("//button[@type='submit']");





public Homepage(WebDriver driver){
    this.driver = driver ;
}

public WebElement getSearchIcon(){
    return driver.findElement(logo);
}
public WebElement getMobile(){
    return driver.findElement(mobile);
}
public WebElement selectLocation(){
        return driver.findElement(slect_Location);
}
public WebElement Dhaka(){
        return driver.findElement(Dhaka);
}
public WebElement Mirpur(){
        return driver.findElement(Mirpur);
}
public WebElement topProduct(){
        return driver.findElement(topProduct);
}
    public WebElement ProductDetails(){
        return driver.findElement(ProductDetails);
    }
public WebElement Search(){

    return driver.findElement(Search);

}
public WebElement MobilesSearch(){

    return driver.findElement(MobilesSearch);

    }
public WebElement Previous(){

    return driver.findElement(Previous);

    }
public WebElement Next(){

    return driver.findElement(Next);

    }

public WebElement all_ads (){

    return driver.findElement(all_ads);
}

public WebElement language(){
    return driver.findElement(language);

}

public WebElement chat(){
    return driver.findElement(chat);

}

public WebElement login(){

    return driver.findElement(login);
}

public WebElement post_ad(){

    return driver.findElement(post_ad);
}

public WebElement location(){

    return driver.findElement(location);

}

public WebElement search(){
    return driver.findElement(search);
}

public WebElement search_icon(){
    return driver.findElement(search_icon);
}








}
