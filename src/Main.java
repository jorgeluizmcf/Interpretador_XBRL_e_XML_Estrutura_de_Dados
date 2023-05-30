import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o caminho do arquivo XML: ");
        String xmlFilePath = scanner.nextLine();

        System.out.print("Digite o nome do arquivo CSV a ser salvo (sem a extensão): ");
        String csvFileName = scanner.nextLine();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFilePath);

            Node root = document.getDocumentElement();
            TreeItem tree = new TreeItem(root.getNodeName(), root.getTextContent());

            XMLTreeParser.buildTree(root, tree);

            String csvFilePath = XMLTreeParser.getCsvFilePath(xmlFilePath, csvFileName);
            XMLTreeParser.saveTreeToCSV(tree, csvFilePath);

            System.out.println("Árvore do XML armazenada em formato CSV com sucesso!");
        } catch (ParserConfigurationException | IOException | org.xml.sax.SAXException e) {
            e.printStackTrace();
        }
    }
}
