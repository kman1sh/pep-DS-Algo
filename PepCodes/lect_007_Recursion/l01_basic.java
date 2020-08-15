public class l01_basic {

    public static void main(String[] args) {
        // System.out.println(factorial(5));
        // System.out.println(pow(5,4));
        // System.out.println(pow_better(2,0));
        // System.out.println(calls(5));
        System.out.println(calls_01(5, 0));

    }

    public static int factorial(int n) {
        if (n <= 1)
            return 1;

        int result = factorial(n - 1);
        return n * result;
    }

    /**
     * problem with this power function is, the function calls itself for @param b numbers of times.
     * Hence, "b" size the stack memory bnega
     * but since stack max size is fixed
     * (size depend on JVMs, different VMs have different stack size but IT IS OF FIXED SIZE).
     * SO in situations where "b" is a large number like 6000, 8000 etc and stack size is fixed to 3000 only.
     * so b size ka stack bnana possible ni ho payega and program will give error.
     * Hence we need a better function to reduce number of calls this function makes to itself 
     * and hence use less stack memory.
     */
    public static int pow(int a, int b) {
        if(b == 0) return 1;

        int result = pow(a, b-1);
        return a * result;
    }

    //v2 power function, a better one.
    public static int pow_better(int a, int b) {
        
        if(b ==1) return a;
        if(b ==0) return 1;
        
        int result = pow_better(a, b/2);
        result *= result;

        return ((b & 1) == 0)? result : result*a;
    }

    //Practice Excercise for Dry RUN
    public static int calls(int n) {
        if (n <= 1) {
            System.out.println("base: " + n);
            return n + 1;
        }

        int count = 0;

        System.out.println("Pre: " + n);
        count += calls(n - 1);

        System.out.println("In: " + n);

        count += calls(n - 2);
        System.out.println("Post: " + n);

        return count + 3;
    }

    //Practice Excercise 2 for Dry RUN
    public static int calls_01(int n, int level) {
        if (n <= 1) {
            System.out.println("base: " + n + "@" + level);
            return n + 1;
        }

        int count = 0;
 
        System.out.println("Pre: " + n + "@" + level);
        count += calls_01(n - 1, level + 1);

        System.out.println("In 1: " + n + "@" + level);

        count += calls_01(n - 2, level + 1);

        System.out.println("In 2: " + n + "@" + level);

        count += calls_01(n - 3, level + 1);
        System.out.println("Post: " + n + "@" + level);

        return count + 3;
    }

    
}