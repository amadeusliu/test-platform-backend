package cn.edu.tju.controller;

import cn.edu.tju.domain.ResponseData;
import cn.edu.tju.domain.UploadInfo;
import cn.edu.tju.mapper.UploadInfoMapper;
import cn.edu.tju.service.FileService;
import cn.edu.tju.utils.FileStreamUtil;
import cn.edu.tju.utils.ResponseBuilderUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    //需要前端发送的post请求的参数名为 file
    @RequestMapping("/fileUpload")
    public ResponseData fileUpload(MultipartFile file) throws Exception{
        boolean uploadResult = fileService.upload(file);
        ResponseData responseData = null;
        if(uploadResult){
            responseData = ResponseBuilderUtil.buildSuccessResponse("文件上传成功");
        } else {
            responseData = ResponseBuilderUtil.buildFailResponse("文件上传失败");
        }
        return responseData;

    }

    //
    @RequestMapping("/addFileUploadInfo")
    public ResponseData addFileUploadInfo(@RequestBody UploadInfo uploadInfo) throws Exception{
        try{
            System.out.println(uploadInfo);
            fileService.addUploadInfo(uploadInfo);
        } catch (Exception ex){
            ResponseData responseData = ResponseBuilderUtil.buildFailResponse(ex.getMessage());
            return responseData;
        }
        ResponseData responseData = ResponseBuilderUtil.buildSuccessResponse("文件信息添加成功");
        return responseData;
    }

    @RequestMapping("/getFileList")
    public ResponseData getFileList(){
        List<Map<String, Object>> fileList = fileService.getFileList();

/*        JsonArray jsonArray = new JsonArray();
        for(int i = 0; i < fileList.size(); i ++){
            int index = Integer.parseInt(String.valueOf(fileList.get(i).get("id")));
            String description = String.valueOf(fileList.get(i).get("description"));
            String instruction = String.valueOf(fileList.get(i).get("instruction"));
            String fileName = String.valueOf(fileList.get(i).get("file_name"));
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("index", i);
            jsonObject.addProperty("fileName", fileName);
            jsonObject.addProperty("description", description);
            jsonObject.addProperty("instruction", instruction);
            jsonArray.add(jsonObject);


        }*/

        for(int i = 0; i < fileList.size(); i ++){
            fileList.get(i).put("id", i + 1);
        }

        ResponseData responseData = ResponseBuilderUtil.buildSuccessResponse(fileList);
        return responseData;

    }

    @RequestMapping("/getFileInstruction/{fileName}")
    public ResponseData getFileInstruction(@PathVariable("fileName")String fileName){
        Map<String, Object> aFile = fileService.getFileInstruction(fileName);
        String instruction = String.valueOf(aFile.get("instruction"));
        ResponseData responseData = ResponseBuilderUtil.buildSuccessResponse(instruction);
        return responseData;
    }

    @RequestMapping(value="/download/json/{downLoadFileName}")
    public ResponseData downloadJson(HttpServletRequest request
            , @PathVariable("downLoadFileName")String downLoadFileName)throws Exception{

        byte[] bytes = fileService.getBytes(downLoadFileName);
        ResponseEntity<byte[]> fileByteStream = FileStreamUtil.getResponseEntity(
                downLoadFileName, bytes);

        ResponseData responseData = ResponseBuilderUtil.buildSuccessResponse(fileByteStream);

        return responseData;
    }

    @RequestMapping(value="/download/stream/{downLoadFileName}")
    public ResponseEntity<byte[]> downloadStream(HttpServletRequest request
            , @PathVariable("downLoadFileName")String downLoadFileName)throws Exception{
        byte[] bytes = fileService.getBytes(downLoadFileName);
        ResponseEntity<byte[]> fileByteStream = FileStreamUtil.getResponseEntity(
                downLoadFileName, bytes);

        return fileByteStream;
    }


    @RequestMapping(value="/delete/{fileName}")
    public ResponseData deleteFile(@PathVariable("fileName") String fileName) throws Exception {
        fileService.deleteFile(fileName);
        ResponseData responseData = ResponseBuilderUtil.buildSuccessResponse("文件删除成功");
        return responseData;
    }

}
