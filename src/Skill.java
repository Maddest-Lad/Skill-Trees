import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


/**
 * Skill Is The Main Class of This Doubly Linked Tree / Acyclic Directed Graph
 * Skills are Intended to Keep Track of Categories and Sub Divisions
 * Each Skill Will Have a Progress Bar, Which is Made Up By It's Children
 * Only Skills With No Children Will Truly Represent Their Own Progress Value
 * <p>
 * The Structure Is As Follows, With Nodes Having N Many Children
 * <p>
 * Main Category [37.5%]
 * <p>
 * Sub-Category-1 [50%]
 * Some Skill A [100%]
 * Some Skill B [0%]
 * <p>
 * Sub-Category-2 [25%]
 * Some Skill A [35%]
 * Some Skill B [15%]
 * <p>
 * One More Thing To Clarify, Skills Will Act Both As Categories *and* The Skills Themselves
 */
public class Skill {

    public String name;
    private int progress;

    private Skill parent;
    private List<Skill> children;

    // Primary Use Constructor
    public Skill(String name, Skill parent, int progress) {
        this.name = name;
        this.progress = progress;
        parent.addChild(this);
        this.parent = parent;
        this.children = new ArrayList<>();
        update();
    }

    // Root Only Constructor
    public Skill(String name) {
        this.name = name;
        this.progress = 0;
        this.parent = null;
        this.children = new ArrayList<>();
        update();
    }

    // Included a Constructor With Both Parent and Children In Case of Creating a Skill Between Existing Parents/Children
    public Skill(String name, Skill parent, Skill... children) {
        this.name = name;
        parent.addChild(this);
        this.parent = parent;
        this.children = new ArrayList<Skill>(Arrays.asList(children));
        update();
    }

    // Updates The Whole Tree
    private void update() {
        this.getRoot().computeProgress();
    }

    // From the Starting Skill, Recursively Update Itself Based on It's Children
    // While This Can Be Called On Non-Root Skills, It Shouldn't As It Won't Update The Progress of It's Parent Nodes
    private int computeProgress() {

        if (children.size() > 0)
        {
            // Make Sure To Average Everything On It's Own Sub-Level
            double subLevelProgress = 0.0;
            for (Skill child : children)
            {
                subLevelProgress += child.computeProgress();
            }

            // Set That Sub Level's Progress then Continue Recursing
            this.progress = (int) (subLevelProgress / children.size());
        }
        return this.progress;
    }

    // From Any Node, Traverse to The Root
    private Skill getRoot() {
        if (this.parent == null)
        {
            return this;
        }

        return this.parent;
    }


    public Skill getParent() {
        return parent;
    }

    public List<Skill> getChildren() {
        return children;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
        update();
    }

    public void addChild(Skill s) {
        children.add(s);
    }

    public void addChildren(Skill... s) {
        children.addAll(Arrays.asList(s));
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder(50);
        print(buffer, "", "");
        return buffer.toString();
    }

    private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(name).append(" [").append((progress)).append("%]");
        buffer.append('\n');
        for (Iterator<Skill> it = children.iterator(); it.hasNext(); )
        {
            Skill next = it.next();
            if (it.hasNext())
            {
                next.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
            } else
            {
                next.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
            }
        }
    }
}

