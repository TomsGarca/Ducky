import static java.lang.System.*;

public class useTurkeyAdapter {
 public static void main(String[] args) {
  Duck duck = new MallardDuck();
  Turkey turkey = new WildTurkey();
  Duck turkey_in_disguise = new TurkeyAdapter(turkey);
  Turkey duck_in_disguise = new DuckAdapter(duck);
  
  out.println("\nThe Duck says...");
  testDuck(duck);

  out.println("\nThe turkey adapter says...");
  testDuck(turkey_in_disguise);

  out.println("\nThe Turkey says...");
  testTurkey(turkey);
 
  out.println("\nThe Duck adapter says...");
  testTurkey(duck_in_disguise);
 }

 static void testDuck(Duck duck) {
  duck.quack();
  duck.fly();
 }

 static void testTurkey(Turkey turkey) {
  turkey.gobble();
  turkey.fly();
 }
}



// Interfaces
interface Duck {
 public void quack();
 public void fly();
}

interface Turkey {
 public void gobble();
 public void fly();
}

// Adapters
class TurkeyAdapter implements Duck {
 Turkey turkey;

 public TurkeyAdapter(Turkey turkey) {
  this.turkey = turkey;
 }

 @Override
 public void quack() {
  turkey.gobble();
 }

 @Override
 public void fly() {
  for(int i = 0; i < 5; i ++)
   turkey.fly();
 }
}

// Two way adapter
/*class Adapter implements Turkey, Duck {
 public void quack() { }
 public void gobble() { }
 public void fly() { }
}*/

class DuckAdapter implements Turkey {
 Duck duck;

 public DuckAdapter(Duck duck) {
  this.duck = duck;
 }

 public void gobble() {
  duck.quack();
 }

 public void fly() {
  duck.fly();
  out.println("I am Flying");
 }
}


// Classes
class MallardDuck implements Duck {
 @Override
 public void quack() {
  out.println("Quack!");
 }

 @Override
 public void fly() {
  out.println("I'm flying");
 }
}

class WildTurkey implements Turkey {
 @Override
 public void gobble() {
  out.println("gobble gobble");
 }

 @Override
 public void fly() {
  out.println("I'm flying a short distance");
 }
}