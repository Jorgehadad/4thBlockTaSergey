package com.solvd.ta_lab.carina.demo.api.comments;

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

@RequestTemplatePath(path = "api/comments/patch/rq.json")
@ResponseTemplatePath(path = "api/comments/patch/rs.json")
@Endpoint(methodType = HttpMethodType.PATCH, url = "${comments_url}/posts/1")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PatchCommentMethod extends AbstractApiMethodV2 {
    public PatchCommentMethod() {
        super("api/comments/patch/rs.json", "api/comments/patch/rs.json", "api/comments/comments.properties");
        replaceUrlPlaceholder("comments_url", R.CONFIG.get("comments_url"));

    }
    
}
