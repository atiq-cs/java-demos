import java.util.ArrayList;
import java.util.Arrays;

public class LangFeaturesDemo {
  public static void main(String[] args) {
    var bFlag = true;
    System.out.println("boolean type inference: " + Boolean.toString(bFlag));
    
    // Inference of generic types (List<String>)
    var strings = Arrays.asList("World", "Java 10");
          
    // Inference in Loops
    for (var string : strings) {
        System.out.println("Hello " + string);
    }
      
    // In combination with the Diamond Operator this leads to the inference of List<Object>
    var strings1 = new ArrayList<>();
    strings1.add("Hello World");
    for (var string : strings1) {
        System.out.println(string.toString().replace("World", "Java 10")); // cannot find symbol 'replace'
    }
      
    var strings2 = new ArrayList<String>();
    strings2.add("Hello World");
    for (var string : strings2) {
        System.out.println(string.replace("World", "Java 10"));
    }
  }
}
