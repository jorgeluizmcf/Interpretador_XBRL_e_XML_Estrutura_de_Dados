import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.*;
import java.util.List;

public class XMLParser {
    public static TreeNode parseXML(String filePath) {
        try {
            // Criar o construtor do SAXBuilder
            SAXBuilder builder = new SAXBuilder();

            // Ler o arquivo XML com a codificação "ISO-8859-1"
            File xmlFile = new File(filePath);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(xmlFile), "ISO-8859-1");
            Document document = builder.build(reader);

            // Obter o elemento raiz do documento
            Element rootElement = document.getRootElement();

            // Construir a árvore a partir do elemento raiz
            TreeNode rootNode = buildTree(rootElement);

            return rootNode;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static TreeNode buildTree(Element element) {
        TreeNode node = new TreeNode(element.getName());

        // Obter os atributos do elemento
        List<org.jdom2.Attribute> attributes = element.getAttributes();
        for (org.jdom2.Attribute attribute : attributes) {
            node.addAttribute(attribute.getName(), attribute.getValue());
        }

        // Obter o conteúdo do elemento
        String info = element.getText();
        node.setInfo(info);

        // Obter os elementos filhos
        List<Element> children = element.getChildren();
        for (Element child : children) {
            TreeNode childNode = buildTree(child);
            node.addChild(childNode);
        }

        return node;
    }
}
