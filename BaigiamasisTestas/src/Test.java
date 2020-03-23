import java.util.Map;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {

        Map<Integer, String> names = new TreeMap<>();
        names.put(2, "Petras");
        names.put(1, "Jonas");
        names.put(3, "Antanas");
        names.put(1, "Sigis");

        for (Integer map : names.keySet()){
            System.out.println("id" + map + " value " +
                     names.get(map));
        }
    }
}


