package com.example.alclicker;



import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class IdImage {

    JSONObject IdImage = new JSONObject();


    JSONObject jObject  = new JSONObject("    {\"poing\": 700137 , \"casserole\": 700149 , \"chipolata\": 700002, \"poing\":2131165345, \"club_de_golf\":2131165293, \"casserole\":2131165290,\"chipolata\":2131165291, \"claquette\":2131165292, \"cuillere_en_bois\":2131165294, \"gants_de_boxe\":2131165301, \"haltere\":2131165302, \"marteau_de_thor\":2131165313, \"penetrator\":2131165343, \"pied_de_biche\":2131165344, \"tapette_a_mouche\":2131165347, \"tazer\":2131165348}\n"); // json

    /*

    {"poing": 700137 ,
     "casserole": 700149 ,
     "chipolata": 700002,
     "poing":2131165345,
    "club_de_golf":2131165293,
    "casserole":2131165290,
    "chipolata":2131165291,
    "claquette":2131165292,
    "cuillere_en_bois":2131165294,
    "gants_de_boxe":2131165301,
    "haltere":2131165302,
    "marteau_de_thor":2131165313,
    "penetrator":2131165343,
    "pied_de_biche":2131165344,
    "tapette_a_mouche":2131165347,
    "tazer":2131165348
    }

     */






    public int getIdArme(String name) throws JSONException {
        return jObject.getInt(name); // get data object
    }





    public IdImage() throws JSONException {
    }
}
