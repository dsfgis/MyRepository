package dsf.online_class.model.entity;

import java.util.Date;

public class VideoOrder {
    private Integer videoId;
    private Integer totalFree;
    private Integer userId;
    private String outTradeNo;
    private Integer state;
    private Integer id;
    private String videoTitle;
    private String videoImg;
    private Date createTime;

    @Override
    public String toString() {
        return "VideoOrder{" +
                "videoId=" + videoId +
                ", totalFree=" + totalFree +
                ", userId=" + userId +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", state=" + state +
                ", id=" + id +
                ", videoTitle='" + videoTitle + '\'' +
                ", videoImg='" + videoImg + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getTotalFree() {
        return totalFree;
    }

    public void setTotalFree(Integer totalFree) {
        this.totalFree = totalFree;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoImg() {
        return videoImg;
    }

    public void setVideoImg(String videoImg) {
        this.videoImg = videoImg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
