package dsf.online_class.controller;

import dsf.online_class.model.entity.Video;
import dsf.online_class.model.entity.VideoBanner;
import dsf.online_class.service.VideoService;
import dsf.online_class.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;


    @RequestMapping(value = "listvideo")

    public JsonData listVideo(){
        List<Video> lstVideo = videoService.listVideo();
        return JsonData.buildSuccess(lstVideo);
    }

    @RequestMapping(value = "listvideobanner")
    public JsonData listVideoBanner(){

        List<VideoBanner> lstVideoBanner = videoService.listVideoBanner();

        return JsonData.buildSuccess(lstVideoBanner);
    }
    @RequestMapping(value = "findVideoById")
    public JsonData findVideoById(int video_id){
        Video video = videoService.findDetailById(video_id);
        return JsonData.buildSuccess(video);
    }
}
