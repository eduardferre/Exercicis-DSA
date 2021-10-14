import java.util.*;

public class I18NManager {
    private static I18NManager instance;
    //Hauria de ser un diccionari.
    public Map <String, String> mapCache = new HashMap<String,String>();
    private I18NManager() {
    }

    //Mira si tenemos dicha búsqueda en la caché.
    public String getFromCache (String idNom){
        return mapCache.get(idNom);
    }

    //Estructura del Singleton.
    public static I18NManager getInstance(){
        if (instance==null) {
            instance = new I18NManager();
        }
        return instance;
    }

    public String getText(String idParaula, String nomArxiu){
        if (this.getFromCache(idParaula) != null){
            System.out.println("Estava a la caché.");
            return this.getFromCache(idParaula);
        }
        else {
            ResourceBundle rb = ResourceBundle.getBundle(nomArxiu);
            mapCache.put(idParaula, rb.getString(idParaula));
            System.out.println("No estava a la caché");
            return rb.getString(idParaula);
        }
                 
    }
}
