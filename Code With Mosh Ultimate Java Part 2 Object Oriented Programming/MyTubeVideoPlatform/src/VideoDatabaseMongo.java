public class VideoDatabaseMongo implements VideoDatabase{
    @Override
    public void store(Video video) {
        System.out.println("Storing video metadata in a Mongo database...");
        System.out.println("Title: " + video.getTitle());
        System.out.println("File Name: " + video.getFileName());
        System.out.println("Done!\n");
    }
}
