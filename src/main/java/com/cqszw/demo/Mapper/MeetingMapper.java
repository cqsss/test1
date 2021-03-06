package com.cqszw.demo.Mapper;

import com.cqszw.demo.Bean.Meeting;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetingMapper {
    @Select("select * from meeting where name=#{name} and checked=1")
    List<Meeting> getbyname(@Param("name") String name);
    @Select("select * from meeting where date=#{date} and checked=1")
    List<Meeting> getbydate(@Param("date") String date);
    @Select("select * from meeting where type=#{type} and checked=1")
    List<Meeting> getbytype(@Param("type") String type);
    @Select("select * from meeting where checked=1 order by date desc ")
    List<Meeting> getAll();
    @Select("select * from meeting where checked=0 order by date desc ")
    List<Meeting> getUnchecked();
    @Select("select * from meeting where checked=1 and (name like CONCAT(CONCAT('%', #{keyword}), '%') " +
            "or location like CONCAT(CONCAT('%', #{keyword}), '%') or date like CONCAT(CONCAT('%', #{keyword}), '%'))")
    List<Meeting> search(@Param("keyword") String keyword);
    @Select("select * from meeting where type=#{type} and checked=1 and (name like CONCAT(CONCAT('%', #{keyword}), '%') " +
            "or location like CONCAT(CONCAT('%', #{keyword}), '%') or date like CONCAT(CONCAT('%', #{keyword}), '%'))")
    List<Meeting> searchandtype(@Param("type") String type, @Param("keyword") String keyword);
    @Insert("insert into meeting(name,type,location,date,url) values(#{name},#{type},#{location},#{date},#{url})")
    public  int insertMeeting(Meeting meeting);
    @Insert("insert into meeting(name,type,location,date,url,checked) values(#{name},#{type},#{location},#{date},#{url},#{checked})")
    public  int visitorMeeting(Meeting meeting);
    @Select("select * from meeting where checked=1 and name=#{name} and location=#{location} and date=#{date}")
    Meeting getMeeting(@Param("name") String name,@Param("location") String location,@Param("date") String date);
    @Select("select * from meeting where id=#{id}")
    Meeting getById(@Param("id") int id);
    @Select("select * from meeting where name=#{name} and location=#{location} and date=#{date}")
    Meeting getMeetingAll(@Param("name") String name,@Param("location") String location,@Param("date") String date);
    @Update("update meeting set name=#{name},location=#{location},date=#{date},url=#{url} where name=#{old_name} and location=#{old_location} and date=#{old_date}")
    public int updateMeeting(@Param("name") String name,@Param("location") String location,
                             @Param("date") String date,@Param("url") String url,
                             @Param("old_name") String old_name,@Param("old_location") String old_location,
                             @Param("old_date") String old_date);
    @Delete("delete from meeting where name=#{name} and location=#{location} and date=#{date}")
    public  int deleteMeeting(@Param("name") String name,@Param("location") String location,@Param("date") String date);
    @Delete("delete from meeting where id=#{id}")
    public  int deleteById(@Param("id") int id);
    @Update("update meeting set checked=2 where id=#{id}")
    public  int confuseMeeting(@Param("id") int id);
    @Update("update meeting set checked=1 where id=#{id}")
    public  int passcheck(@Param("id") int id);
    @Update("update meeting set checked=0 where id=#{id}")
    public  int clear(@Param("id") int id);
}
