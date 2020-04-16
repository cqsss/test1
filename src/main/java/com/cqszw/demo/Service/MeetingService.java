package com.cqszw.demo.Service;

import com.cqszw.demo.Bean.Meeting;
import com.cqszw.demo.Mapper.MeetingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingService {
    @Autowired
    private MeetingMapper meetingMapper;

    public  List<Meeting> getMeetingByName(String name) {
        return meetingMapper.getbyname(name);
    }
    public  int insertMeeting(Meeting meeting){ return meetingMapper.insertMeeting(meeting);}
    public List<Meeting> getAll(){return  meetingMapper.getAll();}
    public  Meeting getMeeting(String name,String location,String date){return meetingMapper.getMeeting(name, location, date);}
}
