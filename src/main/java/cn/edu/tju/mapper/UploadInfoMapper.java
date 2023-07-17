package cn.edu.tju.mapper;

import cn.edu.tju.domain.UploadInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface UploadInfoMapper {
    @Insert("insert into upload_info(file_name,description,instruction) values(#{fileName},#{description},#{instruction})")
    int addUploadInfo(UploadInfo uploadInfo);

    @Select("select id sort,file_name fileName,description,instruction from upload_info")
    List<Map<String, Object>> getFileList();

    @Select("select * from upload_info where file_name=#{fileName} limit 1")
    Map<String, Object> getFileInstruction(String fileName);

    @Delete("delete from upload_info where file_name = #{fileName}")
    int deleteFile(String fileName);

}
