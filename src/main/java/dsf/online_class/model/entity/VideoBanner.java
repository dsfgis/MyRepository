package dsf.online_class.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * CREATE TABLE `video_banner` (
 *   `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
 *   `url` varchar(256) DEFAULT NULL COMMENT '跳转地址',
 *   `img` varchar(256) DEFAULT NULL COMMENT '图片地址',
 *   `create_time` datetime DEFAULT NULL,
 *   `weight` int(11) DEFAULT NULL COMMENT '数字越小排越前',
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
 */
public class VideoBanner {
    private int id;
    private String url;
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    private int weight;
    private  String img;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
