import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {
    private static final String[] HEADER = {
            "ContaContabil",
            "InformacaoComplementar1",
            "TipoInformacaoComplementar1",
            "InformacaoComplementar2",
            "TipoInformacaoComplementar2",
            "InformacaoComplementar3",
            "TipoInformacaoComplementar3",
            "InformacaoComplementar4",
            "TipoInformacaoComplementar4",
            "InformacaoComplementar5",
            "TipoInformacaoComplementar5",
            "InformacaoComplementar6",
            "TipoInformacaoComplementar6",
            "Valor",
            "TipoValor",
            "NaturezaValor"
    };

    public static void writeCSV(TreeNode rootNode, String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);

            // Escrever o cabeçalho
            writeHeader(writer);

            // Escrever os dados dos nós da árvore
            writeNodeData(rootNode, writer);

            writer.close();

            System.out.println("Arquivo CSV salvo com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeHeader(FileWriter writer) throws IOException {
        for (int i = 0; i < HEADER.length; i++) {
            writer.write(HEADER[i]);
            if (i < HEADER.length - 1) {
                writer.write(";");
            }
        }
        writer.write("\n");
    }

    private static void writeNodeData(TreeNode node, FileWriter writer) throws IOException {
        if (node.getTag().equals("accountMainID")) {
            writer.write(node.getInfo());
            writer.write(";");
        }

        if (node.getTag().equals("accountSubID")) {
            writer.write(node.getInfo());
            writer.write(";");
        }

        if (node.getTag().equals("accountSubType")) {
            writer.write(node.getInfo());
            writer.write(";");
        }

        if (node.getTag().equals("amount")) {
            writer.write(node.getInfo());
            writer.write(";");
        }

        if (node.getTag().equals("debitCreditCode")) {
            writer.write(node.getInfo());
            writer.write("\n");
        }

        List<TreeNode> children = node.getChildren();
        for (TreeNode child : children) {
            writeNodeData(child, writer);
        }
    }
}
