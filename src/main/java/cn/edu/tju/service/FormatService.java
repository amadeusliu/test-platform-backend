package cn.edu.tju.service;

import cn.edu.tju.domain.ResponseData;
import org.springframework.web.bind.annotation.PathVariable;

public interface FormatService {
    String getMd5(String str);
    String getBase64(String str);
}
