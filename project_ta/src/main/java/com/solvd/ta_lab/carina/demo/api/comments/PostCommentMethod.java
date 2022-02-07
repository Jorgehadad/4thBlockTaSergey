package com.solvd.ta_lab.carina.demo.api.comments;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;

@RequestTemplatePath(path = "api/comments/post/rq.json")
@ResponseTemplatePath(path = "api/comments/post/rs.json")
@Endpoint(methodType = HttpMethodType.POST, url = "${comments_url}/posts")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostCommentMethod extends AbstractApiMethodV2 {
    public PostCommentMethod() {
        super("api/comments/post/rq.json", "api/comments/post/rs.json", "api/comments/post/comments.properties");
        replaceUrlPlaceholder("comments_url", R.CONFIG.get("comments_url"));
    }
}
