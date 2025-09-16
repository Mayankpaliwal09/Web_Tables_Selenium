package com.mayankPaliwal.Selenium_Webtables;

import io.qameta.allure.Description;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Sel_Web_table_1 {

    @Test(groups = "QA")
    @Description("Test Case Description")
    public void test_web_table_login(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/webtable.html");
        driver.manage().window().maximize();

        // xpath ->  //table[@id="customers"]/tbody/tr[5]/td[2]    --> this is for cols


        //xpath - //table[@id="customers"]/tbody/tr[
        // i
        // ]/td[
        // j
        // ]


        String first_part = "//table[@id=\"customers\"]/tbody/tr[";
        String second_part = "]/td[";
        String third_part = "]";


        int rows = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr")).size();
        int cols = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td")).size();


        for(int i = 2 ; i <= rows; i++){

            for(int j = 1 ; j<= cols;j++){

                String dynamic_path = first_part+i+second_part+j+third_part;
//                System.out.println(dynamic_path);

                String data = driver.findElement(By.xpath(dynamic_path)).getText();
//                System.out.println(data);

                if(data.contains("Helen Bennett")){
                    String path = dynamic_path+"/following-sibling::td";
                    String text = driver.findElement(By.xpath(path)).getText();
//                    System.out.println(text);

                    System.out.println("------");
                    System.out.println("Helen Bennett is In - " + text);
                }


            }
        }



        driver.quit();

    }
}
