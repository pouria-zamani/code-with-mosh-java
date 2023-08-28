public class EmailService implements NotificationService{
    @Override
    public void notify(User user) {
        System.out.println("Notifying with Email Service " + user.getEmail() + "...");
        System.out.println("Done!\n");
    }
}
