package api.CukoinApi;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.*;


public class StreamApiExamples {
    final String url = "https://api.kucoin.com/api/v1/market/allTickers";

    public List<TickerData> getTickers() {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(url)
                .then().log().body()
                .extract().jsonPath()
                .getList("data.ticker", TickerData.class);
    }

    @Test
    public void checkCrypto() {

        List<TickerData> updatedTickers = new ArrayList<>(given()
                .contentType(ContentType.JSON)
                .when()
                .get(url)
                .then()
                .extract().jsonPath().getList("data.ticker", TickerData.class));

        updatedTickers.stream().forEach(element -> Assert.assertTrue(Double.parseDouble(element.getAveragePrice()) > 10));
    }

}
