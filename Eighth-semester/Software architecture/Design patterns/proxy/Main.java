public class Main {
    public static void main(String[] args) {
        Internet workInternet = new WorkInternetProxy();
        workInternet.connectTo("facebook.com");
        workInternet.connectTo("slack.com");
    }
}
