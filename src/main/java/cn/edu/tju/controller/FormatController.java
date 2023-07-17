package cn.edu.tju.controller;

import cn.edu.tju.domain.ResponseData;
import cn.edu.tju.service.FormatService;
import cn.edu.tju.utils.ResponseBuilderUtil;
import com.google.common.hash.Hashing;
import com.google.common.io.BaseEncoding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Base64.*;

@RestController
@CrossOrigin
@RequestMapping("format")
public class FormatController {
    @Autowired
    private FormatService formatService;



    @RequestMapping("/hi")
    public String hi(){
        LocalDate localDate = LocalDate.now();
        return localDate.toString();
    }

    @RequestMapping("/getMd5/{str}")
    public ResponseData getMd5(@PathVariable("str")String str){
        String encodedString = formatService.getMd5(str);
        System.out.println(encodedString);
        ResponseData responseData = ResponseBuilderUtil.buildSuccessResponse(encodedString);
        return responseData;
    }

    @RequestMapping("/getBase64/{str}")
    public ResponseData getBase64(@PathVariable("str")String str){
        String encodedString = formatService.getBase64(str);

        ResponseData responseData = ResponseBuilderUtil.buildSuccessResponse(encodedString);
        return responseData;

    }

    public static void main(String[] args) throws UnsupportedEncodingException {
/*        Decoder decoder = Base64.getDecoder();
        Encoder encoder = Base64.getEncoder();
        String string = "goodbye";
        byte[] bytes = string.getBytes("UTF-8");

        String encodedString = encoder.encodeToString(bytes);
        System.out.println(encodedString);
        System.out.println(new String(decoder.decode(encodedString), "UTF-8"));*/




    }
}
