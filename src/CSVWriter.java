import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CSVWriter {
    public static void writeCSV(TreeNode rootNode, String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);

            writeNodeData(rootNode, writer, 0);

            writer.close();

            System.out.println("Arquivo CSV salvo com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeNodeData(TreeNode node, FileWriter writer, int depth) throws IOException {
        // Escrever a tag do nó
        writer.write(node.getTag());

        // Escrever os atributos do nó
        for (Map.Entry<String, String> entry : node.getAttributes().entrySet()) {
            writer.write(";" + entry.getKey());
            writer.write(";" + entry.getValue());
        }

        // Escrever as informações do nó
        writer.write("\n");
        writer.write(getFormattedData(node.getInfo()));

        // Percorrer os filhos do nó
        List<TreeNode> children = node.getChildren();
        for (TreeNode child : children) {
            writeNodeData(child, writer, depth + 1);
        }
    }

    private static String getFormattedData(String info) {
        // Tratar os valores ausentes com ponto e vírgula vazio
        if (info.isEmpty()) {
            return ";;;;;;;;;";
        } else {
            // Tratar os valores numéricos com ponto decimal e formatação de ponto e vírgula
            try {
                double value = Double.parseDouble(info);
                return String.format("%.2f", value).replace('.', ',');
            } catch (NumberFormatException e) {
                return info;
            }
        }
    }
}
