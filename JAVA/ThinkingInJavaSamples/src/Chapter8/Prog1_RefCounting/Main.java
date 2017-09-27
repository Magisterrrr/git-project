package Chapter8.Prog1_RefCounting;


class Shared{
    private int refcount = 0;
    private static long counter = 0;
    private final long id = counter++;
    public Shared(){
        System.out.println("Створюємо "+this);
    }
    public void addRef(){refcount++;}
    protected void dispose(){
        if(--refcount==0)
            System.out.println("Disposing "+id);
    }
    public String toString(){return "Shared "+id;}
}

class Composing{
    private Shared shared;
    private static long counter = 0;
    private final long id = counter++;
    public Composing(Shared shared){
        System.out.println("Створюємо "+this);
        this.shared = shared;
        this.shared.addRef();
    }
    protected void dispose(){
        System.out.println("Disposing "+this);
        shared.dispose();
    }
    public String toString(){return "Composing "+id;}
}


abstract class As{

}
class As1 extends As{

}

public class Main {
    public static void main(String...args){
        Shared shared = new Shared();

        Composing[] composings = { new Composing(shared ),new Composing(shared ),
                new Composing(shared ),new Composing(shared ),new Composing(shared )};
        for(Composing c:composings){
            c.dispose();
        }
    }
}
