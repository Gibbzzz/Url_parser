package parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.MalformedURLException;
import java.net.URL;

public class Launcher {

    private static final String URL_ADDRESS = "https://data.gov.spb.ru/opendata/7803032323-block_traffic/";
    private static final Logger LOG = LoggerFactory.getLogger(Launcher.class.getName());

    public static void main(String[] args) {
        try {
            URLParser parser = new URLParser(new URL(URL_ADDRESS), "14.03.2014");
            parser.parse();
        } catch (MalformedURLException e) {
            LOG.error("Wrong URL address", e);
        }
    }
}
