package tanzania.magazeti.magazeti.model;

/**
 * Created by nassa on 6/18/2017.
 */
import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class Item {
    public long id;
    public String by;
    public String text;
    public String title;
    public long time;
    public long parent;
    public String type;
public long commentcounter=0;
    public Item() {

    }

    public Item(long id, String text,long parentid,String by,String type) {
        this.id = id;
        this.type=type;
        this.text = text;
        this.parent=parentid;
        this.by=by;
        time=System.currentTimeMillis() / 1000L;
    }


    public Item(long id, String text,String by,String type,String title,String unused) {
        this.id = id;
        this.type=type;
        this.title=title;
        this.text = text;
        this.by=by;
        time=System.currentTimeMillis() / 1000L;
    }
    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("parent", parent);
        result.put("title", title);
        result.put("by", by);
        result.put("text", text);
        result.put("time", time);
       result.put("type",type);
        result.put("commentcounter",commentcounter);

        return result;
    }
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id=id;
    }




    public void setBy(String by){
        this.by=by;
    }
public  void setCommentcounter(long commentcounter){
    this.commentcounter=commentcounter;
}
    public void setText(String text){
        this.text=text;
    }
    public void setTime(long time){
        this.time=time;
    }
public void setParent(long parent){
    this.parent=parent;
}
    public void setType(String type){
        this.type=type;
    }
}