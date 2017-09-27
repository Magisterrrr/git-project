package Chapter9.Prog1_ClassProcessor;

import javafx.beans.binding.ObjectExpression;

import java.util.Arrays;

interface Processor{
    String name();
    Object process(Object input);
}

class Apply{
    public static void process(Processor p, Object s){
        System.out.println("Using Processor "+p.name());
        System.out.println(p.process(s));
    }
}

abstract class StringProcessor implements Processor{
    public String name(){
        return  getClass().getSimpleName();
    }
    public abstract String process(Object input);
    public static String s = "If she weighs the same as a duck, she's made of wood";
}
class Upcase extends StringProcessor{
    public String process(Object input){
        return ((String)input).toUpperCase();
    }
}
class Downcase extends StringProcessor{
    public String process(Object input){
        return ((String)input).toLowerCase();
    }
}
class Spliter extends StringProcessor{
    public String process(Object input){
        return Arrays.toString(((String)input).split(" "));
    }
}

public class Main{
    public static void main(String...args){
        Apply.process(new Upcase(),StringProcessor.s);
        Apply.process(new Downcase(),StringProcessor.s);
        Apply.process(new Spliter(),StringProcessor.s);
    }
}