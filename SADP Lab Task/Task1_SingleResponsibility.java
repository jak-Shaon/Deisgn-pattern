public class Task1_SingleResponsibility 
{
    public static void main(String[] args) 
    {
        FileManager fileManager = new FileManager();
        fileManager.writeFile("data.txt", "Hello, world!");

        Logger logger = new Logger();
        logger.logMessage("This is an important message.");
    }
}

class FileManager 
{
    public void writeFile(String fileName, String content) 
    {
         System.out.println("Writing content to " + fileName + ": " + content);
    }


    public String readFile(String fileName) 
    {      
            return "Content read from " + fileName;
    }
    
}


class Logger 
{
    public void logMessage(String message) 
    {
            System.out.println("Logging message: " + message);
    }
}
