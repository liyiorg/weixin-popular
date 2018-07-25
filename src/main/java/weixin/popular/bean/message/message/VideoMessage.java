package weixin.popular.bean.message.message;

/**
 * 视频
 *
 * @author LiYi
 */
public class VideoMessage extends Message {

    public VideoMessage() {
    }

    public VideoMessage(String touser, Video video) {
        super(touser, "video");
        this.video = video;
    }

    public Video video;


    public Video getVideo() {
        return video;
    }


    public void setVideo(Video video) {
        this.video = video;
    }


    public static class Video {
        private String media_id;
        private String title;
        private String description;
        private String thumb_media_id;

        public Video() {

        }

        public Video(String media_id, String title, String description, String thumb_media_id) {
            super();
            this.media_id = media_id;
            this.thumb_media_id = thumb_media_id;
            this.title = title;
            this.description = description;
        }

        public Video(String media_id, String title, String description) {
            super();
            this.media_id = media_id;
            this.title = title;
            this.description = description;
        }

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String mediaId) {
            media_id = mediaId;
        }

        public String getThumb_media_id() {
            return thumb_media_id;
        }

        public void setThumb_media_id(String thumb_media_id) {
            this.thumb_media_id = thumb_media_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

    }

}
