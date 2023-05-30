import java.util.*;

public class TreeNode {
    private String tag;
    private Map<String, String> attributes;
    private String info;
    private List<TreeNode> children;

    public TreeNode(String tag) {
        this.tag = tag;
        this.attributes = new LinkedHashMap<>();
        this.info = "";
        this.children = new ArrayList<>();
    }

    public String getTag() {
        return tag;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void addAttribute(String name, String value) {
        attributes.put(name, value);
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }

    public List<TreeNode> getChildren() {
        return children;
    }
}
