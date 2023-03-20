package google.dirve.domain;

import google.dirve.VideoProcessingApplication;
import google.dirve.domain.VideoProcessd;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Video_table")
@Data
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fileid;

    private String url;

    @PostPersist
    public void onPostPersist() {
        VideoProcessd videoProcessd = new VideoProcessd(this);
        videoProcessd.publishAfterCommit();
    }

    public static VideoRepository repository() {
        VideoRepository videoRepository = VideoProcessingApplication.applicationContext.getBean(
            VideoRepository.class
        );
        return videoRepository;
    }

    public static void processingVideo(FileUploaded fileUploaded) {
        /** Example 1:  new item 
        Video video = new Video();
        repository().save(video);

        VideoProcessd videoProcessd = new VideoProcessd(video);
        videoProcessd.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(fileUploaded.get???()).ifPresent(video->{
            
            video // do something
            repository().save(video);

            VideoProcessd videoProcessd = new VideoProcessd(video);
            videoProcessd.publishAfterCommit();

         });
        */

    }
}
