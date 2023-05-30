import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLTreeParser {


    public static void buildTree(Node node, TreeItem treeItem) {
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node childNode = nodeList.item(i);
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) childNode;
                TreeItem childTreeItem = new TreeItem(element.getNodeName(), element.getTextContent());
                treeItem.addChild(childTreeItem);
                buildTree(childNode, childTreeItem);
            }
        }
    }

    public static void saveTreeToCSV(TreeItem tree, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            saveTreeItemToCSV(tree, writer, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveTreeItemToCSV(TreeItem treeItem, FileWriter writer, int level) throws IOException {
        String indent = getIndentation(level);
        String csvLine = indent + treeItem.getTag() + ";" + treeItem.getContent() + "\n";
        writer.append(csvLine);

        List<TreeItem> children = treeItem.getChildren();
        for (TreeItem child : children) {
            saveTreeItemToCSV(child, writer, level + 1);
        }
    }

    private static String getIndentation(int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append("  ");
        }
        return sb.toString();
    }

    public static String getCsvFilePath(String xmlFilePath, String csvFileName) {
        File xmlFile = new File(xmlFilePath);
        String parentPath = xmlFile.getParent();
        String csvFilePath = parentPath + File.separator + csvFileName + ".csv";
        return csvFilePath;
    }
}

class TreeItem {
    private String tag;
    private String content;
    private List<TreeItem> children;

    public TreeItem(String tag, String content) {
        this.tag = tag;
        this.content = content;
        this.children = new ArrayList<>();
    }

    public String getTag() {
        return tag;
    }

    public String getContent() {
        return content;
    }

    public List<TreeItem> getChildren() {
        return children;
    }

    public void addChild(TreeItem child) {
        children.add(child);
    }
}
