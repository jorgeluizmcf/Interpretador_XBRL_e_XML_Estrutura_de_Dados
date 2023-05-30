import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CSVWriter {
    public static void writeCSV(TreeNode rootNode, String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);

            // Escrever o cabeçalho do CSV
            writer.write("ContaContabil,InformacaoComplementar1,TipoInformacaoComplementar1,InformacaoComplementar2,TipoInformacaoComplementar2,InformacaoComplementar3,TipoInformacaoComplementar3,InformacaoComplementar4,TipoInformacaoComplementar4,InformacaoComplementar5,TipoInformacaoComplementar5,InformacaoComplementar6,TipoInformacaoComplementar6,Valor,TipoValor,NaturezaValor\n");

            writeNodeData(rootNode, writer, 0);

            writer.close();

            System.out.println("Arquivo CSV salvo com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeNodeData(TreeNode node, FileWriter writer, int depth) throws IOException {
        // Escrever os dados do nó
        StringBuilder sb = new StringBuilder();

        // Obter as informações do nó
        Map<String, String> attributes = node.getAttributes();
        String contaContabil = attributes.getOrDefault("ContaContabil", "");
        String informacaoComplementar1 = attributes.getOrDefault("InformacaoComplementar1", "");
        String tipoInformacaoComplementar1 = attributes.getOrDefault("TipoInformacaoComplementar1", "");
        String informacaoComplementar2 = attributes.getOrDefault("InformacaoComplementar2", "");
        String tipoInformacaoComplementar2 = attributes.getOrDefault("TipoInformacaoComplementar2", "");
        String informacaoComplementar3 = attributes.getOrDefault("InformacaoComplementar3", "");
        String tipoInformacaoComplementar3 = attributes.getOrDefault("TipoInformacaoComplementar3", "");
        String informacaoComplementar4 = attributes.getOrDefault("InformacaoComplementar4", "");
        String tipoInformacaoComplementar4 = attributes.getOrDefault("TipoInformacaoComplementar4", "");
        String informacaoComplementar5 = attributes.getOrDefault("InformacaoComplementar5", "");
        String tipoInformacaoComplementar5 = attributes.getOrDefault("TipoInformacaoComplementar5", "");
        String informacaoComplementar6 = attributes.getOrDefault("InformacaoComplementar6", "");
        String tipoInformacaoComplementar6 = attributes.getOrDefault("TipoInformacaoComplementar6", "");
        String valor = attributes.getOrDefault("Valor", "");
        String tipoValor = attributes.getOrDefault("TipoValor", "");
        String naturezaValor = attributes.getOrDefault("NaturezaValor", "");

        sb.append(escapeCSVField(contaContabil)).append(",");
        sb.append(escapeCSVField(informacaoComplementar1)).append(",");
        sb
    }