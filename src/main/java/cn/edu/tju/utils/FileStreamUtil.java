package cn.edu.tju.utils;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.net.URLEncoder;

public class FileStreamUtil {
    public static ResponseEntity getResponseEntity(String fileName, byte[] bytes) throws Exception{
        ResponseEntity.BodyBuilder builder = ResponseEntity.ok();
        builder.contentLength(bytes.length);
        builder.contentType(MediaType.APPLICATION_OCTET_STREAM);
        String finalFileName = URLEncoder.encode(fileName, "UTF-8");
        builder.header("Content-Disposition", "attachment; filename*=UTF-8''" + fileName);
        return  builder.body(bytes);
    }
}
