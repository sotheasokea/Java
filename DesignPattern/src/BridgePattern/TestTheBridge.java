package BridgePattern;

public class TestTheBridge {
  public static void main(String[] args) {
    Shape a = new Circle(new Blue());
    Shape b = new Rectangle(new Red());
    Shape c = new Square(new Green());

    a.draw();
    b.draw();
    c.draw();
  }
}
interface Color{
  String fill();
}
class Red implements Color{
  public String fill(){
    return "red";
  }
}
class Blue implements Color{
  public String fill(){
    return "blue";
  }
}
class Green implements Color{
  public String fill(){
    return "Green";
  }
}

abstract class Shape{
  protected Color c;
  public Shape(Color c){
    this.c = c;
  }
  public abstract void draw();
}
class Circle extends Shape {
  public Circle(Color c){
    super(c);
  }
  public void draw(){
    System.out.println("Draw a "+c.fill()+" circle");
  }
}
class Square extends Shape{
  public Square(Color c){
    super(c);
  }
  public void draw(){
    System.out.println("Draw a "+c.fill()+" square");
  }
}
class Rectangle extends Shape{
  public Rectangle(Color c){
    super(c);
  }
  public void draw(){
    System.out.println("Draw a "+c.fill()+" rectangle");
  }
}