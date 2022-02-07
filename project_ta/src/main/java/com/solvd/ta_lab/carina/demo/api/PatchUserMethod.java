package com.solvd.ta_lab.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;

@RequestTemplatePath(path = "api/users/patch/rs.json")
@ResponseTemplatePath(path = "api/users/patch/rs.json")
@Endpoint(methodType = HttpMethodType.PATCH, url = "${api_url}/api/users/2")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PatchUserMethod extends AbstractApiMethodV2 {
    public PatchUserMethod() {
        super("api/users/patch/rs.json", "api/users/patch/rs.json", "api/users/patch/user.properties");
        replaceUrlPlaceholder("api_url", R.CONFIG.get("api_url"));

    }
    
}
