import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

  public static File createFile(String name) throws IOException {
    File file = new File(name);
    file.createNewFile();

    return file;
  }

  public static File createFileInDir(String name, String dirName) throws IOException {
    File file = new File(dirName, name);
    file.createNewFile();

    return file;
  }

  public static boolean exist(String name) {
    File file = new File(name);
    return file.exists();
  }

  public static void delete(String name) {
    File file = new File(name);
    file.delete();
  }

  public static void writeToFile(String text, File file) throws IOException {
    FileWriter fileWriter = null;

    try {
      fileWriter = new FileWriter(file);
      fileWriter.write(text);
      fileWriter.flush();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      fileWriter.close();
    }
  }

  public static List<String> read(File file) throws IOException {
    ArrayList<String> result = new ArrayList<>();

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

      while (bufferedReader.ready()) {
        result.add(bufferedReader.readLine());
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return result;
  }
}
