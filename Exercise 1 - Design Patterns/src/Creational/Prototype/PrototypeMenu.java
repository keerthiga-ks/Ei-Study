package Creational.Prototype;

import java.util.*;
import java.util.logging.Logger;

public class PrototypeMenu {
    public static void run(Scanner sc, Logger logger) {
        List<Document> documents = new ArrayList<>();
        boolean back = false;

        while(!back) {
            System.out.println("\n--- Prototype Pattern: Document Cloning ---");
            System.out.println("1. Create Template Document");
            System.out.println("2. Clone a Document");
            System.out.println("3. View All Documents");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter choice: ");

            String choice = sc.nextLine();
            try {
                switch(choice) {
                    case "1":
                        System.out.print("Enter template name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter content: ");
                        String content = sc.nextLine();
                        Document doc = new Document(name, content);
                        documents.add(doc);
                        logger.info("Template created: " + name);
                        break;
                    case "2":
                        if(documents.isEmpty()) { System.out.println("No documents to clone!"); break; }
                        System.out.println("Available documents:");
                        for(int i=0;i<documents.size();i++) System.out.println((i+1)+". "+documents.get(i).getName());
                        System.out.print("Choose document number to clone: ");
                        int index = Integer.parseInt(sc.nextLine())-1;
                        if(index<0 || index>=documents.size()) { System.out.println("Invalid index!"); break; }
                        Document clone = documents.get(index).clone();
                        System.out.print("Enter name for clone: ");
                        String cloneName = sc.nextLine();
                        clone = new Document(cloneName, clone.getContent());
                        documents.add(clone);
                        logger.info("Document cloned: " + cloneName);
                        break;
                    case "3":
                        if(documents.isEmpty()) System.out.println("No documents available.");
                        else { for(Document d: documents) d.display(); }
                        break;
                    case "4": back = true; break;
                    default: System.out.println("Invalid choice!");
                }
            } catch(Exception e){ System.out.println("Error: "+e.getMessage()); logger.warning(e.getMessage()); }
        }
    }
}
