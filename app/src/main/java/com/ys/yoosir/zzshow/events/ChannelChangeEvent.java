package com.ys.yoosir.zzshow.events;

/**
 * Created by 窦浩鹏 on 2020/2/28.
 */

public class ChannelChangeEvent {
    private String channelName = null;
    private boolean isChannelChanged = false;
    public ChannelChangeEvent(String channelName, boolean isChannelChanged){
        this.channelName = channelName;
        this.isChannelChanged = isChannelChanged;
    }
    public String getChannelName(){
        return channelName;
    }
    public boolean isChannelChanged(){
        return isChannelChanged;
    }
}
