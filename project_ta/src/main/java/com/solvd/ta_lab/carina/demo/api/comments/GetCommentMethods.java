package com.solvd.ta_lab.carina.demo.api.comments;

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

//@ResponseTemplatePath(path = "api/comments/get/rs.json")
@ResponseTemplatePath(path = "api/comments/get/rs.schema.json")
@Endpoint(methodType = HttpMethodType.GET, url = "${comments_url}/comments/1")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetCommentMethods extends AbstractApiMethodV2 {
    public GetCommentMethods() {
        super(null, "api/comments/get/rs.json", new Properties());
        replaceUrlPlaceholder("comments_url", R.CONFIG.get("comments_url"));

    }
}
