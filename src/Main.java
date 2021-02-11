public class Main {

    // Testing
    public static void main(String[] args) {
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
