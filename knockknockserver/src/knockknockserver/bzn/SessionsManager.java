/* @author chad */
package knockknockserver.bzn;

import java.util.ArrayList;
import java.util.List;
import knockknockserver.model.Session;

public class SessionsManager {
    private List<Session> list;

    public SessionsManager() {
        this.list = new ArrayList<>();
    }
    
    public String addSession(int id){
        Session s = new Session(id);
        return s.getIdent();
    }
    
    public String getIdent(int id){
        for(Session s: list){
            if (s.getUser_id() == id){
                return s.getIdent();
            }
        }
        return "";
    }
    
}
