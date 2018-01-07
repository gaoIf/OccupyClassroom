package com.superclassroom;

/**
 * Created by Gif on 2018/1/2.
 */
//
public class CourseData {
    private String weektime;
    private String course1;
    private String course2;
    private String course3;
    private String course4;

    public String getWeektime() {
        return weektime;
    }

    public String getCourse1() {
        return course1;
    }

    public String getCourse2() {
        return course2;
    }

    public String getCourse3() {
        return course3;
    }

    public String getCourse4() {
        return course4;
    }
    public CourseData(String weektime,String course1,String course2,String course3,String course4)
    {
        super();
        this.weektime=weektime;
        this.course1=course1;
        this.course2=course2;
        this.course3=course3;
        this.course4=course4;
    }
}
