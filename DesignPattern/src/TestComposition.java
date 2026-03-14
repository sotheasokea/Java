import java.util.List;
import java.util.ArrayList;

public class TestComposition {
  public static void main(String[] args) {
    // create some files
    File quiz1 = new File("quiz1.png");
    File group2OOP = new File("DormitorySystem.draw_io");
    File resume = new File("resume.pdf");
    File note   = new File("DatabaseLab2.pdf");
    File pic1 = new File("familyTrip.png");
    File pic2 = new File("home.png");

    // create folder
    Folder year2 = new Folder("year2");
    Folder picture = new Folder("picture");
    Folder drive_D = new Folder("Drive D");

    year2.add(quiz1);
    year2.add(group2OOP);
    year2.add(note);

    picture.add(pic1);
    picture.add(pic2);

    drive_D.add(year2);
    drive_D.add(picture);
    drive_D.add(resume);

    drive_D.show("");
  }
}
interface FileSystem{
  void show(String indent);
}
class File implements FileSystem{
  private String name;
  public File(String name){
    this.name = name;
  }
  public void show(String indent){
    System.out.println(indent+"[File] "+name);
  }
}
class Folder implements FileSystem{
  private String name;
  private List<FileSystem> children = new ArrayList<>();
  public Folder(String name){
    this.name = name;
  }
  public void add(FileSystem fs){
    children.add(fs);
  }
  void remove(FileSystem fs){
    children.remove(fs);
  }
  public void show(String indent){
    System.out.println(indent+"[Folder] "+name);
    for(FileSystem fs: children){
      fs.show(indent+"   ");
    }
  }
}