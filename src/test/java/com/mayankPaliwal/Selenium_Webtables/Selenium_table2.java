package com.mayankPaliwal.Selenium_Webtables;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.List;

public class Selenium_table2 {

    @Test(groups = "QA")
    @Description("Test Case Description")
    public void test_Webtable_Dynamic() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/webtable1.html");
        driver.manage().window().maximize();

        WebElement table = driver.findElement(By.xpath("//table[@summary=\"Sample Table\"]/tbody"));

//        System.out.println(table.getText());

        List<WebElement> rows = table.findElements(By.tagName("tr"));
        System.out.println(rows.size());

        for(int i = 0; i < rows.size(); i++){
            List<WebElement> cols = table.findElements(By.tagName("td"));
            for(WebElement c : cols){
                System.out.println(c.getText());
//                System.out.println();

            }

        }

        driver.quit();

    }
    }
