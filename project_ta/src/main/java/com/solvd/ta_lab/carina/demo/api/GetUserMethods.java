package com.solvd.ta_lab.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;
import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;

@ResponseTemplatePath(path = "api/users/get/rs.json")
@Endpoint(methodType = HttpMethodType.GET, url = "${api_url}/api/users/2")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetUserMethods extends AbstractApiMethodV2 {
    public GetUserMethods() {
        super(null, "api/users/get/rs.json", new Properties());
        replaceUrlPlaceholder("api_url", R.CONFIG.get("api_url"));

    }
}
