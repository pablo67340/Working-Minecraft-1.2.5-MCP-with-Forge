package argo.jdom;


public enum JsonNodeType {

   OBJECT("OBJECT", 0),
   ARRAY("ARRAY", 1),
   STRING("STRING", 2),
   NUMBER("NUMBER", 3),
   TRUE("TRUE", 4),
   FALSE("FALSE", 5),
   NULL("NULL", 6);
   // $FF: synthetic field
   private static final JsonNodeType[] $VALUES = new JsonNodeType[]{OBJECT, ARRAY, STRING, NUMBER, TRUE, FALSE, NULL};


   private JsonNodeType(String p_i615_1_, int p_i615_2_) {}

}
