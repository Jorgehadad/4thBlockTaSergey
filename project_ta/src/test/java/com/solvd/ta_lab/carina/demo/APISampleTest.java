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
import com.solvd.ta_lab.carina.demo.api.*;

/**
 * This sample shows how create REST API tests.
 *
 * @author qpsdemo
 */
public class APISampleTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    //@Test()
    public void testUserPost() {
        PostUserMethod postUserMethod = new PostUserMethod();
        //postUserMethod.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        postUserMethod.addProperty("job", "worker");
        Response response = postUserMethod.callAPIExpectSuccess();
        postUserMethod.validateResponse();
        //postUserMethod.validateResponseAgainstSchema(DEFAULT);
        //System.out.println(response.asString());
        //System.out.println(postUserMethod.getProperties().get("job"));

        System.out.println("ID: " + JsonPath.read(response.asString(), "$.id")); 
    }
    
    //@Test()
    public void testUserPostMissingName() {
        PostUserMethod postUserMethod = new PostUserMethod();
        //postUserMethod.removeProperty("name");
        postUserMethod.callAPIExpectSuccess();
        postUserMethod.validateResponse();

        //System.out.println(postUserMethod.getProperties().get("job"));
    }

    @Test()
    public void testUserGet() {
        GetUserMethods getUserMethods = new GetUserMethods();
        getUserMethods.callAPIExpectSuccess();
        getUserMethods.validateResponse();
        //getUserMethods.validateResponseAgainstSchema(DEFAULT);
        //System.out.println(getUserMethods.getResponse().asString());
    }

    //PATCH
    @Test()
    public void testUserPatch() {
        PostUserMethod postUserMethod = new PostUserMethod();
        Response response = postUserMethod.callAPIExpectSuccess();
        postUserMethod.validateResponse();
        //postUserMethod.validateResponseAgainstSchema(DEFAULT);
        //System.out.println(postUserMethod.getResponse().asString());

        String id = JsonPath.read(response.asString(), "$.id");
        System.out.println("ID: " + id);

        PatchUserMethod patchUserMethod = new PatchUserMethod();
        patchUserMethod.addProperty("id", id);
        patchUserMethod.addProperty("job", "worker");
        patchUserMethod.callAPIExpectSuccess();
        patchUserMethod.validateResponse();
        //patchUserMethod.validateResponseAgainstSchema(DEFAULT);
        //System.out.println(patchUserMethod.getResponse().asString());
    }

/*
    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testCreateUser() throws Exception {
        LOGGER.info("test");
        setCases("4555,54545");
        PostUserMethod api = new PostUserMethod();
        api.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        api.callAPI();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testCreateUserMissingSomeFields() throws Exception {
        PostUserMethod api = new PostUserMethod();
        api.getProperties().remove("name");
        api.getProperties().remove("username");
        api.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        api.callAPI();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetUsers() {
        GetUserMethods getUsersMethods = new GetUserMethods();
        getUsersMethods.expectResponseStatus(HttpResponseStatusType.OK_200);
        getUsersMethods.callAPI();
        getUsersMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getUsersMethods.validateResponseAgainstSchema("api/users/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P1)
    public void testDeleteUsers() {
        DeleteUserMethod deleteUserMethod = new DeleteUserMethod();
        deleteUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteUserMethod.callAPI();
        deleteUserMethod.validateResponse();
    }
*/
}
