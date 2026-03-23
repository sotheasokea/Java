package OtherPractise;

public class FactoryPatternPractise {
  public static void main(String[] args) {
    AnimalFactory choosAnimal = new AnimalFactory();
    Animal animal1 = choosAnimal.createAnimal(AnimalType.DOG);
    Animal animal2 = choosAnimal.createAnimal(AnimalType.CAT);
    Animal animal3 = choosAnimal.createAnimal(AnimalType.COW);
    Animal animal4 = choosAnimal.createAnimal(AnimalType.FROG);

    animal1.makeSound();
    animal2.makeSound();
    animal3.makeSound();
    animal4.makeSound();

  }
}
interface Animal{
  void makeSound();
}

class Dog implements Animal{
  public void makeSound(){
    System.out.println("Woof!");
  }
}

class Cat implements Animal{
  public void makeSound(){
    System.out.println("Meow!");
  }
}

class Cow implements Animal{
  public void makeSound(){
    System.out.println("Moo!");
  }
}

class Frog implements Animal{
  public void makeSound(){
    System.out.println("Ribbit!");
  }
}

enum AnimalType{
  DOG,
  CAT,
  COW,
  FROG
}

class AnimalFactory{
  Animal createAnimal(AnimalType type){
    Animal animal;
    switch (type) {
      case DOG:
        animal = new Dog();
      break;
      case CAT:
        animal = new Cat();
      break;
      case COW:
        animal = new Cow();
      break;
      case FROG:
        animal = new Frog();
      break;
      default:
        throw new IllegalArgumentException("Unknown animal: " + type);
    }
    return animal;
  }
}