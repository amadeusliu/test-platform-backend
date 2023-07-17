package cn.edu.tju.utils;

import cn.edu.tju.domain.ResponseData;

public class ResponseBuilderUtil {
    public static ResponseData buildSuccessResponse(Object data){
        ResponseData responseData = new ResponseData().newBuilder()
                .buildCode(200).buildData(data).build();
        return responseData;
    }

    public static ResponseData buildFailResponse(Object data){
        ResponseData responseData = new ResponseData().newBuilder()
                .buildCode(500).buildData(data).build();
        return responseData;
    }
}
