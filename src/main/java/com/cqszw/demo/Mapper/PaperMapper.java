package com.cqszw.demo.Mapper;

import com.cqszw.demo.Bean.Paper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cqs
 * @date 2020/5/27
 */
@Repository
public interface PaperMapper {
    @Select("select * from paper")
    List<Paper> getAll();
    @Select("select topic from paper where id=#{id}")
    public String gettopicbyid(@Param("id") int id);
    @Select("select count(*) from paper")
    public int getnum();
    @Select("select * from paper where id=#{id}")
    public Paper getpaperbyid(@Param("id") int id);
    @Insert("insert into paper(id,topic,type,author,keyword) values(#{id},#{topic},#{type},#{author},#{keyword})")
    public int insertPaper(Paper paper);
    @Delete("delete from paper where id = #{id}")
    public int deletePaper(int id);
}
