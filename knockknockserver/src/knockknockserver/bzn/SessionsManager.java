/* @author chad */
package knockknockserver.bzn;

import java.util.ArrayList;
import java.util.List;
import knockknockserver.model.Session;

public class SessionsManager {
    List<Session> list;

    public SessionsManager() {
        this.list = new ArrayList<>();
    }
    
    public String addSession(int id){
        Session s = new Session(id);
        return s.getIdent();
    }
    
    
    
}
