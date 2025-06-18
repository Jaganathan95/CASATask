package Framework;

import org.openqa.selenium.By;

public class PageObject extends Base{
public void PasteToken(String token)
{
	driver.findElement(By.xpath("//div[@data-testid='decoder__jwtEditor']//button[text()='Clear']")).click();
	driver.findElement(By.xpath("//div[@data-testid='decoder__jwtEditor']//textarea")).sendKeys(token);
}
}
