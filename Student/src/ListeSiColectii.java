import java.util.*;
import java.util.stream.IntStream;


public class ListeSiColectii
{
    public static void main(String[] args)
    {
        List<Integer> x = new ArrayList();
        List<Integer> y = new ArrayList();
        List<Integer> xPlusY = new ArrayList(); //a
        Set<Integer> zSet = new TreeSet(); //b
        List<Integer> xMinusY = new ArrayList();//c
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList(); //d

        java.util.Random rand = new java.util.Random();

        IntStream.range(0,5).forEach(i -> x.add(rand.nextInt(10)));
        IntStream.range(0,7).forEach(i -> y.add(rand.nextInt(10)));
        xPlusY.addAll(x);
        xPlusY.addAll(y);
        Collections.sort(xPlusY);


      Collections.sort(x);
      Collections.sort(y);
      zSet.addAll(x);
      zSet.removeAll(y);


        xMinusY.addAll(x);
        Iterator<Integer> it = xMinusY.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            for (Integer a : y) {
                if (a.equals(i)) {
                    xMinusY.remove(i);
                }
            }
        }
        Collections.sort(xMinusY);



        xPlusYLimitedByP.addAll(x);
        xPlusYLimitedByP.addAll(y);
        Iterator<Integer> ite=xPlusYLimitedByP.iterator();
        while(ite.hasNext())
        {
            Integer b=ite.next();
            if(b>=p) xPlusYLimitedByP.remove(b);
        }
        Collections.sort(xPlusYLimitedByP);

    }
}




