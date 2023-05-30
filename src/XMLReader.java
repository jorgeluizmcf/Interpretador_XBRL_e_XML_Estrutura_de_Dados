import java.util.List;
import java.util.Map;

public class XMLReader {
    public static void printTree(TreeNode node, int depth) {
        // Indentação para exibir a estrutura da árvore
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indent.append("  ");
        }

        // Exibir a tag do nó
        System.out.println(indent + "<" + node.getTag() + ">");

        // Exibir os atributos do nó
        Map<String, String> attributes = node.getAttributes();
        if (!attributes.isEmpty()) {
            for (Map.Entry<String, String> entry : attributes.entrySet()) {
                System.out.println(indent + "  " + entry.getKey() + "=\"" + entry.getValue() + "\"");
            }
        }

        // Percorrer os filhos do nó
        List<TreeNode> children = node.getChildren();
        for (TreeNode child : children) {
            printTree(child, depth + 1);
        }

        // Exibir o fechamento da tag do nó
        System.out.println(indent + "</" + node.getTag() + ">");
    }
}
