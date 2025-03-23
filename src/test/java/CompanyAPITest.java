import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.example.ResponseCompany;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CompanyAPITest extends BaseTest{

    @Test
    public void testCompanyAPIValue20(){
        int qty =20;
        Response response = given().when().
                get("companies?_quantity="+qty).
                then()
                .statusCode(200).
                extract().response();
        System.out.println(response.getBody().asString());
        ResponseCompany responseCompany = response.as(ResponseCompany.class);
        Assert.assertEquals(responseCompany.getData().size(),qty);
        System.out.println("[PASSED] Qty :"+qty+" | Response Qty:"+responseCompany.getData().size());
    }

    @Test
    public void testCompanyAPIValue5(){
        int qty =5;
        Response response = given().when().
                get("companies?_quantity="+qty).
                then()
                .statusCode(200).
                extract().response();
        System.out.println(response.getBody().asString());
        ResponseCompany responseCompany = response.as(ResponseCompany.class);
        Assert.assertEquals(responseCompany.getData().size(),qty);
        System.out.println("[PASSED] Qty :"+qty+" | Response Qty:"+responseCompany.getData().size());
    }

    @Test
    public void testCompanyAPIValue1(){
        int qty =1;
        Response response = given().when().
                get("companies?_quantity="+qty).
                then()
                .statusCode(200).
                extract().response();
        System.out.println(response.getBody().asString());
        ResponseCompany responseCompany = response.as(ResponseCompany.class);
        Assert.assertEquals(responseCompany.getData().size(),qty);
        System.out.println("[PASSED] Qty :"+qty+" | Response Qty:"+responseCompany.getData().size());
    }

    @Test
    public void testCompanyID(){
        Response response = given().when().
                get("companies").
                then()
                .statusCode(200).
                assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response-schema.json")).
                extract().response();
        System.out.println(response.getBody().asString());
        ResponseCompany responseCompany = response.as(ResponseCompany.class);
        System.out.println("[PASSED] Response has followed the schema");
        for(int i=0;i<responseCompany.getData().size();i++){
            Assert.assertNotEquals(responseCompany.getData().get(i).getId(),null);
            System.out.println("[PASSED] ID :"+responseCompany.getData().get(i).getId());
        }
    }
}
