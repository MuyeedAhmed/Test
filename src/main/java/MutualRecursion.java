public class MutualRecursion {
    public int f(int x){
        if (x>=0 && x < 100){
            return g(x+1);
        }else{
            return 0;
        }
    }
    public int g(int x){
        if (x >= 0 && x < 100){
            return f(x+1);
        }else{
            return 0;
        }
    }
}
