import java.util.ArrayList;
import java.util.List;

public class WorkInternetProxy implements Internet {
    Internet internet = new RealInternet();
    List<String> bannedSites = new ArrayList<>();

    WorkInternetProxy() {
        bannedSites.add("facebook.com");
    }

    @Override
    public void connectTo(String url) {
        if(bannedSites.contains(url)) {
            System.out.println("Connection refused. url: '" + url + "' is banned." );
            return;
        }

        internet.connectTo(url);
    }
}
