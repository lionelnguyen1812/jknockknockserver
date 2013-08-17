/* @author chad */
package knockknockserver;

public class ServerLogger {
    private String name;
    
    public ServerLogger(String name) {
        this.name = name;
    }
    
    public void log(String s){
        System.out.println(this.name + ": " + s);
    }

}
