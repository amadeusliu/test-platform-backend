package cn.edu.tju.service;

import cn.edu.tju.domain.UploadInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface FileService {
    boolean upload(MultipartFile file) throws Exception;
    int addUploadInfo(UploadInfo uploadInfo);
    byte[] getBytes(String fileName);
    List<Map<String, Object>> getFileList();
    Map<String, Object> getFileInstruction(String fileName);
    boolean deleteFile(String fileName) throws Exception;

}
