import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TerminalVersion {



    public static void main(String[] args) throws IOException {
        // User Input Handling
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        // readLine is blocking, which is alright in this case
        while(true) {

            System.out.println();

            switch (reader.readLine()) {
                case 1:
            }




        }
    }



    // Simple Testing Fun
    public void test() {
        Skill root = new Skill("Comp Sci");

        Skill ds = new Skill("Data Structures", root, 0);
        Skill lists = new Skill("Lists", ds, 97);
        Skill graphs = new Skill("Graphs", ds, 32);
        Skill trees = new Skill("Trees", ds, 49);

        Skill alg = new Skill("Algorithms", root, 0);
        Skill sorting = new Skill("Sorting", alg, 53);
        Skill recursion = new Skill("Recursion", alg, 77);

        System.out.println(root.toString());
    }

}
