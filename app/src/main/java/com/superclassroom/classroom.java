package com.superclassroom;

/**
 * Created by Timber on 2017/11/3.
 */

public class classroom {
    private String name;
    private String time;
    private String stage;
    public String getName()
    {
        return name;
    }
    public String getTime()
    {
        return time;
    }
    public String getStage()
    {
        return stage;
    }
    public classroom(String name, String time, String stage) {
        super();
        this.name = name;
        this.time = time;
        this.stage = stage;
    }


}
