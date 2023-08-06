package com.juaracoding;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TugasWeekTiga {
    public static void main(String[] args) {
        String webdriver = "webdriver.chrome.driver";
        String patch = "C:\\myTools\\chromedriver.exe";
        System.setProperty(webdriver, patch);
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://shop.demoqa.com/my-account");
        System.out.println("Open Browser, Open URL");
        driver.findElement(By.id("username")).sendKeys("ktino");//memasukkan username
        driver.findElement(By.id("password")).sendKeys("syalalala");//memasukkan password
        driver.findElement(By.cssSelector("button[name='login']")).click();//mengcklick tombol login
        String name= driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/div/p[1]/strong[1]")).getText();//mendapatkan teks username
        driver.findElement(By.cssSelector("a[class='custom-logo-link'] img[alt='ToolsQA Demo Site']")).click();//mengclick logo shoptool
        js.executeScript("window.scrollBy(0,1600)");
        driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[4]/div/div[1]/div/div/div/div[2]/div[2]/div[1]/div/h3/a")).click();//untuk klik barang dengan nama tokyo talkies
        js.executeScript("window.scrollBy(0,1000)");
        driver.findElement(By.cssSelector("button[class='single_add_to_cart_button button alt wp-element-button']\n")).click();//untuk klik tombol add to chart
        String keranjang =driver.findElement(By.cssSelector("div[role='alert']")).getText();//untuk mendapatkan teks barang sudah berhasil ditambahkan
        System.out.println(keranjang);
        if (name.equals("ktino")) {
            System.out.println("berhasil login account dengan username ktino");
        } else {
            System.out.println("salah account saya bukan itu");
        }
        if (keranjang.contains("has been added to your cart.")) {
            System.out.println("barang berhasil ditambahkan ke keranjang");
        } else {
            System.out.println("gagal");
        }
        delay();
        driver.quit();
        System.out.println("Quit Browser");
    }
    public static void delay() {
        try {
            Thread.sleep(10000);//delay 3 detik sebelum lanjut ke coding selanjutnya
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
