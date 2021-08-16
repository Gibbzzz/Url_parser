package parser;/*
10.0. Количество дорожных ограничений

Небольшая задача, которая демонстрирует, как можно приложить Java к решению практических задач.

Подготовка данных:
С портала открытых данных Санкт-Петербурга требуется определить, сколько дорожных ограничений действовало в городе на определенную дату.

Задача:
Требуется определить, сколько дорожных ограничений действовало в городе на определенную дату.
Программа в качестве аргумент получает два параметра:
Путь к файлу с данными
Дата

Необходимо вывести количество действовавших ограничений движения транспорта на эту дату.
*/

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
