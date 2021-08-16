package parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class URLParser {

    private static final Logger LOG = LoggerFactory.getLogger(URLParser.class.getName());
    private final URL url;
    private final String date;

    public URLParser (URL url, String date) {
        this.url = url;
        this.date = date;
    }

    public void parse() {
        try {
            URLConnection connection = url.openConnection();

            try (InputStream input = connection.getInputStream();
                 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input))) {

                List<String> lines = Stream.generate(() -> readNext(bufferedReader))
                        .takeWhile(Objects::nonNull)
                        .filter(line -> line.contains(date))
                        .collect(Collectors.toList());

                LOG.info("Список распоряжений: {}",lines);
                LOG.info("Количество действовавших ограничений движения транспорта на эту дату: {}", lines.size());
            }

        } catch (Exception e) {
            LOG.error("Connection error", e);
        }
    }

    private String readNext(BufferedReader bufferedReader) {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            LOG.error("Read error", e);
        }
        return null;
    }
}
