package cn.edu.tju.service.impl;

import cn.edu.tju.domain.UploadInfo;
import cn.edu.tju.mapper.UploadInfoMapper;
import cn.edu.tju.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@Service
public class FileServiceImpl implements FileService {
    private Logger logger = LoggerFactory.getLogger(FileService.class);
    @Value("${fileDirectory}")
    private String fileBaseDir;

    @Autowired
    private UploadInfoMapper uploadInfoMapper;

    @Override
    @Transactional
    public boolean deleteFile(String fileName) throws Exception{
        uploadInfoMapper.deleteFile(fileName);
        String path = fileBaseDir + fileName;
        Files.delete(Path.of(path));
        return true;
    }

    @Override
    public byte[] getBytes(String fileName) {
        try{
            String path = fileBaseDir + fileName;
            byte[] bytes = Files.readAllBytes(Path.of(path));
            return bytes;
        }catch (Exception ex){
            logger.error(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Map<String, Object>> getFileList() {
        return uploadInfoMapper.getFileList();
    }

    @Override
    public Map<String, Object> getFileInstruction(String fileName) {
        return uploadInfoMapper.getFileInstruction(fileName);
    }

    @Override
    public boolean upload(MultipartFile file) throws Exception{
        try {
            String fileName=file.getOriginalFilename();
            //拼接完整的文件保存路径
            String fileFullPath=fileBaseDir + fileName;
            //删除现有的同名文件（如果有）。如果直接调用delete方法，会抛异常
            Files.deleteIfExists(Paths.get(fileFullPath));
            //保存文件
            file.transferTo(new File(fileFullPath));
            return true;
        } catch (Exception ex){
            logger.error(ex.getMessage());
            return false;
        }
    }

    @Override
    public int addUploadInfo(UploadInfo uploadInfo) {
        int result = uploadInfoMapper.addUploadInfo(uploadInfo);
        return result;
    }
}
