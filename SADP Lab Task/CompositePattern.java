import java.util.ArrayList;
import java.util.List;

interface Filesystem{
    public void display();
}

class File implements Filesystem{

    private String name;
    
    public File(String name){
        this.name= name;
    }

    @Override
    public void display(){
        System.out.println("File : "+name);
    }
}

class Directory implements Filesystem{
    private String name;
    private List<Filesystem> childern;

    public Directory(String name){
        this.name=name;
        childern= new ArrayList<>();
    }

    public void addComponent(Filesystem component){

        childern.add(component);
    }
    public void removeComponent(Filesystem component){
        childern.remove(component);
    }
    
    @Override
    public void display(){
        System.out.println("Directory : "+name);
        System.out.println("Content : ");

        for(Filesystem component : childern)
        {
            component.display();
        }
    } 
}

class Client{
    public static void main(String[] args) {
        File file1 = new File("Document.txt");
        File file2 = new File("image.jpg");
        File file3 = new File("sheet.xlsx");
        File file4 = new File("Info.docx");

        Directory direct1 = new Directory("Documents");
        direct1.addComponent(file1);
        direct1.addComponent(file3);
        direct1.addComponent(file4);

        Directory direct2 = new Directory("Pictures");
        direct2.addComponent(file2);

        Directory rootdirect = new Directory("Root");
        rootdirect.addComponent(direct1);
        rootdirect.addComponent(direct2);

        rootdirect.display();

        direct1.removeComponent(file4);
        System.out.println("\n**REMOVING DONE**");

        rootdirect.display();
    }
}