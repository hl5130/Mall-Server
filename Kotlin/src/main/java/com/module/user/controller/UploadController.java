package com.module.user.controller;

import com.module.user.domain.BaseResp;
import com.qiniu.util.Auth;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(produces = {"application/json; charset=UTF-8"}, value = {"/common"})
public class UploadController extends BaseController {
    @RequestMapping(value = {"/getUploadToken"}, method = {RequestMethod.POST})
    @ResponseBody
    public BaseResp<String> getUploadToken() {
        String accessKey = "OxJIx89R1pgyP7rkmc6U3mHxsXrPiRXxfpu5JP8j";
        String secretKey = "i2uvVCDiUdZzKy3cI6QVgWHKHedgJ7GPU17dfu-v";
        String bucket = "aiworld-imge";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        System.out.println(upToken);

        BaseResp resp = new BaseResp();
        resp.setStatus(0);
        resp.setMessage("");
        resp.setData(upToken);

        return resp;
    }
}

