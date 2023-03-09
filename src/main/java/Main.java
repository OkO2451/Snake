public class Main {
    public static void main(String[] args) {
        Window window = new Window(Constants.WIDTH, Constants.HEIGHT, Constants.TITLE);
        Thread thread = new Thread(window);
        thread.start();
    }
}
