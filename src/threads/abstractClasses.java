package threads;

abstract class A{
    abstract void s();
}

abstract class B extends A{
    @Override
    void s() {
        System.out.println("Shaan");
    }
}
public class abstractClasses extends B  {

    @Override
    void s(){
        System.out.println("---------------------------------------");
    }

}
