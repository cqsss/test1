package com.cqszw.demo.Mapper;

import com.cqszw.demo.Bean.Paper;
import com.cqszw.demo.Bean.Upload_Record;
import com.cqszw.demo.Bean.User_Upload;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cqs
 * @date 2020/5/28
 */
@Repository
public interface UPUMapper {
    @Select("select * from user_ul where username = #{username} order by uploadtime desc")
    public List<User_Upload> getulbyuser(@Param("username") String username);
    @Select("select * from paper where id in(select paper_id from user_ul where username=#{username})")
    public List<Paper> getpaperbyuser(@Param("username") String username);
    @Select("SELECT type,topic,author,keyword,uploadtime\n" +
            "FROM paper,user_ul\n" +
            "where paper.id=user_ul.paper_id and username=#{username}")
    public List<Upload_Record> getUploadRecords(@Param("username")String username);
    @Insert("insert into user_ul(username,paper_id,uploadtime) values(#{username},#{paper_id},#{uploadtime})")
    public int insertUPU(@Param("username")String username,@Param("paper_id")int paper_id,@Param("uploadtime")String uploadtime);
}
