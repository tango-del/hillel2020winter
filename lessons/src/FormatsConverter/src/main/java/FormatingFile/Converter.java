package FormatingFile;

import FileCreatings.FileWork;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Converter {

    private static StringBuilder strBuilder = new StringBuilder();
    //append(System.lineSeparator()) - добавляет новую строку

    /**
     * Метод создаёт File @filePath в указанной директории у @path
     *
     * У Arrays вызывается stream который проходит списком всех файлов в @filePath
     * через метод listFiles который возвращает массив File, у этого списке происходит несколько фильтраций
     * сперва фильтрует все файлы которые являются файлами а не папками (isFile)
     * потом фильтрует все файлы в чьих именах присутствуют приставки .json и .yaml
     * с помощью map бёрёт абсолютный путь файлов (getPath) в виде строки
     * forEach проходит по всем строкам с путями и на каждой итерации
     *
     * Cоздаётся @fileName которая использует split - разделение строки на подстроки через указанный разделитель '.'
     * так как сплит возвращает массив этой строки мы берём 0 индекс то есть левую часть строки
     * @Example: "test.json".split("[.]", 0) -> ["test"], ["json"]
     * в @fileName записывается 0 индекс массива.
     * File getName() - возвращает в виде String имя файла
     *
     * Оператор if else if проверяет у каждой строки наличие ".json" и ".yaml"
     * и отправляет эти строки с путями к файлам в метод convertFile у соответствующего класса
     *
     * После завершения stream вызывается метод writeToFile что бы записать файл result.txt
     * результат выполнения программы
     *
     * @param path - в качестве строки хранит абсолютную директорию в соответствии
     * той системы на которой запускается программа
     * @throws IOException
     */
    public static void convert(String path) throws IOException {

        FileWork fileWork = new FileWork();
        JsonToYaml jsonToYaml = new JsonToYaml();
        YamlToJson yamlToJson = new YamlToJson();

        File filePath = new File(path);

        fileWork.createFileDir(path);
        //FileCreator.checkDirExists(path);

        Arrays.stream(filePath.listFiles())
                .filter(File::isFile)
                .filter(file -> file.getName().contains(".json") || file.getName().contains(".yaml"))
                .map(File::getPath)
                .forEach(f -> {
                    //C:\Users\Tango\Desktop\example\20_item.json -> [C:\Users\Tango\Desktop\example\20_item], [json]
                    //String fileName = new File(f.split("[.]", 0)[0]).getName();
                    // 20_item.json -> [20_item], [json]
                    String fileName = new File(f).getName().split("[.]", 0)[0];
                    try {
                        if (f.contains(".json")) {
                            jsonToYaml.convertFile(f, fileName, strBuilder);

                        } else if (f.contains(".yaml")) {

                            yamlToJson.convertFile(f, fileName, strBuilder);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        fileWork.writeToFile(strBuilder);
    }

    /**
     * @param number - число в представлении байтов
     * @return - возвращает число в виде КилоБайтов
     */
    public static float convertByteToKilobyte(long number) {
        return (float) number / 1024;
    }
}
