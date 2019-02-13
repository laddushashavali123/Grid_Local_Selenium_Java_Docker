package tests.mailservice;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Mailnesia {
    private String baseURL = "http://mailnesia.com";
    private String mailboxURL;
    private int timeOut = 5;

    public Mailnesia(String mailBoxName){
        this.mailboxURL = baseURL + "/mailbox/" + mailBoxName;
        deleteAllEmail(mailboxURL);
    }

    public Mailnesia(String mailBoxName, int timeOutInSecond){
        this.timeOut = timeOutInSecond;
        this.mailboxURL = baseURL + "/mailbox/" + mailBoxName;
        deleteAllEmail(mailboxURL);
    }


    public String getActivateLink(){
        String activationLink;

        String messageURL = baseURL + getMessageUrl() + "?noheadernofooter=ajax";
        Document messageHTML = getDataFromUrl(messageURL);

        Elements link = messageHTML.select(".mesage a");
        activationLink = link.attr("href");

        return activationLink;
    }

    private String getMessageUrl(){
        String str = null;
        for (int i=0; i <= timeOut; i++){
            Document doc = getDataFromUrl(mailboxURL);
            Elements elements = doc.select("a[title='Open email']");
            for (Element element : elements){
                if (element.text().contains("Optunli System")){
                    str = element.attr("href");
                    break;
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return str;
    }


    private Document getDataFromUrl(String url){
        RequestSpecification request = RestAssured.with();
        request.given().contentType(ContentType.HTML);

        System.out.println("\n Get data from: " + url);
        Response response = request.get(url);
        String html = response.body().asString();

        return Jsoup.parse(html);
    }

    public void deleteAllEmail(String url){
        Response response = RestAssured
                .given()
                    .contentType(ContentType.URLENC)
                    .body("delete=1")
                .when()
                    .post(url);

        System.out.println("Response status " + response.statusCode());
        System.out.println(Jsoup.parse(response.body().asString()));
    }
}


