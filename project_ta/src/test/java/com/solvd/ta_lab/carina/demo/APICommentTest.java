package com.solvd.ta_lab.carina.demo;

import java.lang.invoke.MethodHandles;

import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import com.jayway.jsonpath.JsonPath;
import com.qaprosoft.apitools.validation.*;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.*;
import com.qaprosoft.carina.core.foundation.utils.tag.*;
import com.solvd.ta_lab.carina.demo.api.comments.*;

/**
 * This sample shows how create REST API tests.
 *
 * @author qpsdemo
 */
public class APICommentTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    public void testCommentPost() {
        PostCommentMethod postCommentMethod = new PostCommentMethod();
        //postCommentMethod.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        postCommentMethod.addProperty("name", "George");
        Response response = postCommentMethod.callAPIExpectSuccess();
        postCommentMethod.validateResponse();
        //postCommentMethod.validateResponseAgainstSchema(DEFAULT);
        //System.out.println(response.asString());
        System.out.println(postCommentMethod.getProperties().get("name"));

        System.out.println("ID: " + JsonPath.read(response.asString(), "$.id")); 
        System.out.println("Name: " + JsonPath.read(response.asString(), "$.name"));
        System.out.println("Email: " + JsonPath.read(response.asString(), "$.email"));
        System.out.println("Body: " + JsonPath.read(response.asString(), "$.body"));

    }
    
    //@Test()
    public void testCommentPostMissingName() {
        PostCommentMethod postCommentMethod = new PostCommentMethod();
        //postCommentMethod.removeProperty("name");
        postCommentMethod.callAPIExpectSuccess();
        postCommentMethod.validateResponse();

        //System.out.println(postCommentMethod.getProperties().get("job"));
    }

    @Test()
    public void testCommentGet() {
        GetCommentMethods getCommentMethods = new GetCommentMethods();
        getCommentMethods.callAPIExpectSuccess();
        getCommentMethods.validateResponse();
        //getCommentMethods.validateResponseAgainstSchema(DEFAULT);
        System.out.println(getCommentMethods.toString());
    }

    //PATCH
    @Test()
    public void testCommentPatch() {
        PostCommentMethod postCommentMethod = new PostCommentMethod();
        //postCommentMethod.addProperty("name", "George");
        Response response = postCommentMethod.callAPIExpectSuccess();
        postCommentMethod.validateResponse();
        //postCommentMethod.validateResponseAgainstSchema(DEFAULT);
        //System.out.println(postCommentMethod.getResponse().asString());

        Integer id = JsonPath.read(response.asString(), "$.id");
        String idString = id.toString();
        System.out.println("ID: " + idString);

        PatchCommentMethod patchCommentMethod = new PatchCommentMethod();
        patchCommentMethod.addProperty("id", id);
        //patchCommentMethod.addProperty("name", "George");
        patchCommentMethod.callAPIExpectSuccess();
        patchCommentMethod.validateResponse();
        patchCommentMethod.validateResponseAgainstSchema("api/comments/patch/rs.schema.json");
        System.out.println(patchCommentMethod.toString());
    }


}
