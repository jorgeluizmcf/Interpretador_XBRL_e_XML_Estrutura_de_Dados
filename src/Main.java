import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o caminho do arquivo XML: ");
        String xmlFilePath = scanner.nextLine();

        // Interpretar o XML e obter a árvore
        TreeNode rootNode = XMLParser.parseXML(xmlFilePath);

        if (rootNode != null) {
            System.out.print("Digite o nome do arquivo CSV a ser salvo: ");
            String csvFileName = scanner.nextLine() + ".csv";

            String csvFilePath = getCsvFilePath(xmlFilePath, csvFileName);

            // Salvar as informações no arquivo CSV
            CSVWriter.writeCSV(rootNode, csvFilePath);
        }
    }

    private static String getCsvFilePath(String xmlFilePath, String csvFileName) {
        File xmlFile = new File(xmlFilePath);
        String xmlParentPath = xmlFile.getParent();
        return xmlParentPath + File.separator + csvFileName;
    }
}
