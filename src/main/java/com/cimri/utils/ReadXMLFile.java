package com.cimri.utils;

/**
 * @author ozlem.ulag
 */
public class ReadXMLFile {

/*   public static void main(String[] args) {

      try {
         File file = new File("src/main/resources/sites/site1.xml");
         DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
         Document document = documentBuilder.parse(file);

         NodeList nodeList = document.getElementsByTagName("row");
         for (int temp = 0; temp < nodeList.getLength(); temp++) {
            Node node = nodeList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
               Element element = (Element) node;

               System.out.println("------------------------------------------------------------------------");
               System.out.println("Id : " + element.getElementsByTagName("id").item(0).getTextContent());
               System.out.println("Title : " + element.getElementsByTagName("title").item(0).getTextContent());
               System.out.println("Brand : " + element.getElementsByTagName("brand").item(0).getTextContent());
               System.out.println("Category : " + element.getElementsByTagName("category").item(0).getTextContent());
               System.out.println("Url : " + element.getElementsByTagName("url").item(0).getTextContent());
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }*/
}
