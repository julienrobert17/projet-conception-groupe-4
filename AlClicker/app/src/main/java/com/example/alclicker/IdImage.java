package com.example.alclicker;



import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class IdImage {

    JSONObject IdImage = new JSONObject();


    JSONObject jObject  = new JSONObject("    {\"poing\":2131230731, \"club_de_golf\":2131165293, \"casserole\":2131165290,\"chipolata\":2131165291, \"claquette\":2131165292, \"cuillere_en_bois\":2131165294, \"gants_de_boxe\":2131165301, \"haltere\":2131165302, \"marteau_de_thor\":2131165313, \"penetrator\":2131165343, \"pied_de_biche\":2131165344, \"tapette_a_mouche\":2131165347, \"tazer\":2131165348}\n"); // json

    JSONObject jDegatObjectDico  = new JSONObject("{ \"poingATC\": 1 , \"club_de_golfATC\":4,\"casseroleATC\": 3 , \"chipolataATC\": 2,\"claquetteATC\":3,\"cuillere_en_boisATC\":3,\"gants_de_boxeATC\":5,\"haltereATC\":7,\"marteau_de_thorATC\":9,\"penetratorATC\":15,\"pied_de_bicheATC\":8,\"tapette_a_moucheATC\":2,\"tazerATC\":5}"); // json


    JSONObject jDegatObjectTab  = new JSONObject("{ \"1\": 1 , \"2\":4, \"3\": 3 , \"4\": 2, \"5\":3, \"6\":3, \"7\":5, \"8\":7, \"9\":9, \"10\":15, \"11\":8, \"12\":2, \"13\":5}"); // json

    JSONObject jIdObjectTab  = new JSONObject("{ \"1\": 2131230731 , \"2\":2131165345, \"3\": 2131165290 , \"4\": 2131165291, \"5\":2131165292, \"6\":2131165294, \"7\":2131165301, \"8\":2131165302, \"9\":2131165313, \"10\":2131165343, \"11\":2131165344, \"12\":2131165347, \"13\":2131165348}"); // json



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


    public int getDegatArmeDico(String name) throws JSONException {
        return jDegatObjectDico.getInt(name); // get data object
    }

    public int getDegatArmeTab(int nbr) throws JSONException {
        return jDegatObjectTab.getInt(String.valueOf(nbr)); // get data object
    }

    public int getIdArmeTab(int nbr) throws JSONException {
        return jIdObjectTab.getInt(String.valueOf(nbr)); // get data object
    }



    public IdImage() throws JSONException {
    }

    /*


    JSONObject jDegatObjectTab  = new JSONObject("{ 1: 1 , 2:4, 3: 3 , 4: 2, 5:2, 6:3, 7:5, 8:7, 9:9, 10:15, 11:8, 12:2, 13:5}"); // json

    //tableau


    JSONObject jIdObjectTab  = new JSONObject(); // json


    //dictionnaire
    JSONObject jDegatObjectDico  = new JSONObject("{ \"poingATC\": 1 , \"club_de_golfATC\":4,\"casseroleATC\": 3 , \"chipolataATC\": 2,\"claquetteATC\":2,\"cuillere_en_boisATC\":3,\"gants_de_boxeATC\":5,\"haltereATC\":7,\"marteau_de_thorATC\":9,\"penetratorATC\":15,\"pied_de_bicheATC\":8,\"tapette_a_moucheATC\":2,\"tazerATC\":5}"); // json

    JSONObject jIdObjectDico  = new JSONObject("{\"poing\":2131165293,\"club_de_golf\":2131165293,\"casserole\":2131165290,\"chipolata\":2131165291,\"claquette\":2131165292,\"cuillere_en_bois\":2131165294,\"gants_de_boxe\":2131165301,\"haltere\":2131165302,\"marteau_de_thor\":2131165313,\"penetrator\":2131165343,\"pied_de_biche\":2131165344,\"tapette_a_mouche\":2131165347,\"tazer\":2131165348}"); // json

    public IdImage() throws JSONException {
    }
/*
    public IdImage() throws JSONException {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        jDegatObjectTab.put("poingATC");
        jDegatObjectTab.put("club_de_golfATC");
        jDegatObjectTab.put("casseroleATC");
        jDegatObjectTab.put("chipolataATC");
        jDegatObjectTab.put("claquetteATC");
        jDegatObjectTab.put("cuillere_en_boisATC");
        jDegatObjectTab.put("gants_de_boxeATC");
        jDegatObjectTab.put("haltereATC");
        jDegatObjectTab.put("marteau_de_thorATC");
        jDegatObjectTab.put("penetratorATC");
        jDegatObjectTab.put("pied_de_bicheATC");
        jDegatObjectTab.put("tapette_a_moucheATC");
        jDegatObjectTab.put("tazerATC");


        jIdObjectTab.put(2131165293);
        jIdObjectTab.put(2131165290);
        jIdObjectTab.put(2131165291);
        jIdObjectTab.put(2131165292);
        jIdObjectTab.put(2131165294);
        jIdObjectTab.put(2131165301);
        jIdObjectTab.put(2131165301);
        jIdObjectTab.put(2131165302);
        jIdObjectTab.put(2131165313);
        jIdObjectTab.put(2131165343);
        jIdObjectTab.put(2131165344);
        jIdObjectTab.put(2131165347);
        jIdObjectTab.put(2131165348);
    }


    /*

{
 "poingATC": 1 ,
 "club_de_golfATC":4,
"casseroleATC": 3 ,
 "chipolataATC": 2,
"claquetteATC":2,
"cuillere_en_boisATC":3,
"gants_de_boxeATC":5,
"haltereATC":7,
"marteau_de_thorATC":9,
"penetratorATC":15,
"pied_de_bicheATC":8,
"tapette_a_moucheATC":2,
"tazerATC":5
}

{
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







    public int getIdArme(String name) throws JSONException {
        return jObject.getInt(name); // get data object
    }








    public int getIdArmeDico(String name) throws JSONException {
        return jIdObjectDico.getInt(name); // get data object
    }

    public JSONObject getIdArmesDico(String name) throws JSONException {

        return jIdObjectDico; // get data object
    }

    public int getDegatArmeDico(String name) throws JSONException {
        return jDegatObjectDico.getInt(name); // get data object
    }

    public JSONObject getDegatArmesDico(String name) throws JSONException {
        return jDegatObjectDico; // get data object
    }


    public int getIdArmeTab(int nbr) throws JSONException {
        return jIdObjectTab.getInt(String.valueOf(nbr)); // get data object
    }

    public JSONObject getIdArmesTab() throws JSONException {

        return jIdObjectTab; // get data object
    }

    public int getDegatArmeTab(int nbr) throws JSONException {
        return jDegatObjectTab.getInt(String.valueOf(nbr)); // get data object
    }

    public JSONObject getDegatArmesTab(String name) throws JSONException {
        return jDegatObjectTab; // get data object
    }




}

     */
}