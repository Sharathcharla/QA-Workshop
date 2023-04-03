package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class IMDBTop {
    WebDriver driver;
    String url = "https://www.imdb.com/chart/top";
    public IMDBTop(WebDriver driver) {
        this.driver =  driver;
    }
    public void navigateToIMDBsSite() {
        if (!driver.getCurrentUrl().equals(this.url)) {
            driver.get(this.url);
        }
    }
    public void PrintTopRatedMovies() throws InterruptedException{
        WebElement[] movies = driver.findElements(By.xpath("//td[@class='titleColumn']"))
                .toArray(new WebElement[0]);
        System.out.println("Total movies found: " + movies.length);

        // Find the highest rated movie
        WebElement highest_rated_title = driver.findElement(By.xpath("(//td[@class='titleColumn']/a)[1]"));
        WebElement highest_rated_rating = driver.findElement(By.xpath("(//td[@class='ratingColumn imdbRating']/strong)[1]"));
        System.out.println(highest_rated_title.getText() + " with a rating of " + highest_rated_rating.getText());
        WebElement sort = driver.findElement(By.id("lister-sort-by-options"));
        Select sorting = new Select(sort);
        sorting.selectByVisibleText("Release Date");
        WebElement latest_movie_title = driver.findElement(By.xpath("(//td[@class='titleColumn']/a)[1]"));
        System.out.println("Latest movie: " + latest_movie_title.getText());
        //span[contains(@class, 'lister-sort-reverse') and contains(@class, 'ascending') and @data-sort='rk:desc']

        WebElement oldest_movie_title = driver.findElement(By.xpath("(//td[@class='titleColumn']/a)[last()]"));
        System.out.println("Oldest movie: " + oldest_movie_title.getText());

    }
}
