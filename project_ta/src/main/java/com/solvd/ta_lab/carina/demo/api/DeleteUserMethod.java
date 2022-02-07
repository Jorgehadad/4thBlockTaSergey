package com.solvd.ta_lab.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(methodType = HttpMethodType.DELETE,
        url = "api/users/{user_id}")
public class DeleteUserMethod extends AbstractApiMethodV2 {

    public DeleteUserMethod() {
        super("api/users/_delete/rq.json", "api/users/_delete/rs.json", "api/users/user.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
