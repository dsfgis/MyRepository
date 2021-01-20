package dsf.online_class.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class VideoOrder {
    @JsonProperty("video_id")
    private Integer videoId;
    @JsonProperty("total_fee")
    private Integer totalFree;
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("out_trade_no")
    private String outTradeNo;
    private Integer state;
    private Integer id;
    @JsonProperty("video_title")
    private String videoTitle;
    @JsonProperty("video_img")
    private String videoImg;
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss",timezone = "GMT+8")
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
