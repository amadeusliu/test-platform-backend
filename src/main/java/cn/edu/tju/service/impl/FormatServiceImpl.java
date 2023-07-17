package cn.edu.tju.service.impl;

import cn.edu.tju.service.FormatService;
import com.google.common.hash.Hashing;
import com.google.common.io.BaseEncoding;
import org.springframework.stereotype.Service;

@Service
public class FormatServiceImpl implements FormatService {
    @Override
    public String getMd5(String str) {
        String encodedString = Hashing.md5().hashBytes(str.getBytes()).toString();

        return encodedString;
    }

    @Override
    public String getBase64(String str) {
        String encodedString = BaseEncoding.base64().encode(str.getBytes());

        return encodedString;
    }
}
