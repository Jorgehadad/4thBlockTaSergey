package com.solvd.ta_lab.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;

@RequestTemplatePath(path = "api/users/post/rq.json")
@ResponseTemplatePath(path = "api/users/post/rs.json")
@Endpoint(methodType = HttpMethodType.POST, url = "${api_url}/api/users")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostUserMethod extends AbstractApiMethodV2 {
    public PostUserMethod() {
        //super("api/users/_post/rq.json", "api/users/_post/rs.json", "api/users/user.properties");
        //replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        super("api/users/post/rq.json", "api/users/post/rs.json", "api/users/post/user.properties");
        replaceUrlPlaceholder("api_url", R.CONFIG.get("api_url"));
    }
}
