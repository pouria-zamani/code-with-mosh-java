public class Main {
    public static void main(String[] args) {
        var video = new Video();

        video.setFileName("birthday.mp4");
        video.setTitle("Jennifer's Birthday");
        video.setUser(new User("pouuriaxz2001@gmail.com"));

        var processor = new VideoProcessor(
                new AVideoEncoder(),
                new SqlVideoDatabase(),
                new EmailService()
        );
        processor.process(video);
    }
}
