import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    try {
      String name = "newDirectory";
      DirUtils.createDirectory(name);
      System.out.println(DirUtils.exists(name));
      // DirUtils.delete(name);
    } catch (DirUtilException e) {
      //e.printStackTrace();
      System.out.println("Exception message " + e.getMessage());
    }

    try {
      // File file = FileUtils.createFile("test.txt");
      // FileUtils.createFileInDir("test.txt", "newDirectory");
      // System.out.println(FileUtils.exist("test.txt"));
      // FileUtils.delete("test.txt");
      // FileUtils.writeToFile("Hello!",file);

      List<String> stringList = FileUtils.read(new File("test.txt"));
      stringList.stream()
          .filter(x -> x.length() > 3)
          .forEach(x -> System.out.println(x));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
