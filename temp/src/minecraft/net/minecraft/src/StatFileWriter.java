package net.minecraft.src;

import argo.jdom.JdomParser;
import argo.jdom.JsonNode;
import argo.jdom.JsonRootNode;
import argo.jdom.JsonStringNode;
import argo.saj.InvalidSyntaxException;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.src.Achievement;
import net.minecraft.src.MD5String;
import net.minecraft.src.Session;
import net.minecraft.src.StatBase;
import net.minecraft.src.StatList;
import net.minecraft.src.StatsSyncher;

public class StatFileWriter {

   private Map field_25102_a = new HashMap();
   private Map field_25101_b = new HashMap();
   private boolean field_27189_c = false;
   private StatsSyncher field_27188_d;


   public StatFileWriter(Session p_i195_1_, File p_i195_2_) {
      File var3 = new File(p_i195_2_, "stats");
      if(!var3.exists()) {
         var3.mkdir();
      }

      File[] var4 = p_i195_2_.listFiles();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         File var7 = var4[var6];
         if(var7.getName().startsWith("stats_") && var7.getName().endsWith(".dat")) {
            File var8 = new File(var3, var7.getName());
            if(!var8.exists()) {
               System.out.println("Relocating " + var7.getName());
               var7.renameTo(var8);
            }
         }
      }

      this.field_27188_d = new StatsSyncher(p_i195_1_, this, var3);
   }

   public void func_25100_a(StatBase p_25100_1_, int p_25100_2_) {
      this.func_27186_a(this.field_25101_b, p_25100_1_, p_25100_2_);
      this.func_27186_a(this.field_25102_a, p_25100_1_, p_25100_2_);
      this.field_27189_c = true;
   }

   private void func_27186_a(Map p_27186_1_, StatBase p_27186_2_, int p_27186_3_) {
      Integer var4 = (Integer)p_27186_1_.get(p_27186_2_);
      int var5 = var4 == null?0:var4.intValue();
      p_27186_1_.put(p_27186_2_, Integer.valueOf(var5 + p_27186_3_));
   }

   public Map func_27176_a() {
      return new HashMap(this.field_25101_b);
   }

   public void func_27179_a(Map p_27179_1_) {
      if(p_27179_1_ != null) {
         this.field_27189_c = true;
         Iterator var2 = p_27179_1_.keySet().iterator();

         while(var2.hasNext()) {
            StatBase var3 = (StatBase)var2.next();
            this.func_27186_a(this.field_25101_b, var3, ((Integer)p_27179_1_.get(var3)).intValue());
            this.func_27186_a(this.field_25102_a, var3, ((Integer)p_27179_1_.get(var3)).intValue());
         }

      }
   }

   public void func_27180_b(Map p_27180_1_) {
      if(p_27180_1_ != null) {
         Iterator var2 = p_27180_1_.keySet().iterator();

         while(var2.hasNext()) {
            StatBase var3 = (StatBase)var2.next();
            Integer var4 = (Integer)this.field_25101_b.get(var3);
            int var5 = var4 == null?0:var4.intValue();
            this.field_25102_a.put(var3, Integer.valueOf(((Integer)p_27180_1_.get(var3)).intValue() + var5));
         }

      }
   }

   public void func_27187_c(Map p_27187_1_) {
      if(p_27187_1_ != null) {
         this.field_27189_c = true;
         Iterator var2 = p_27187_1_.keySet().iterator();

         while(var2.hasNext()) {
            StatBase var3 = (StatBase)var2.next();
            this.func_27186_a(this.field_25101_b, var3, ((Integer)p_27187_1_.get(var3)).intValue());
         }

      }
   }

   public static Map func_27177_a(String p_27177_0_) {
      HashMap var1 = new HashMap();

      try {
         String var2 = "local";
         StringBuilder var3 = new StringBuilder();
         JsonRootNode var4 = (new JdomParser()).func_27367_a(p_27177_0_);
         List var5 = var4.func_27217_b(new Object[]{"stats-change"});
         Iterator var6 = var5.iterator();

         while(var6.hasNext()) {
            JsonNode var7 = (JsonNode)var6.next();
            Map var8 = var7.func_27214_c();
            Entry var9 = (Entry)var8.entrySet().iterator().next();
            int var10 = Integer.parseInt(((JsonStringNode)var9.getKey()).func_27216_b());
            int var11 = Integer.parseInt(((JsonNode)var9.getValue()).func_27216_b());
            StatBase var12 = StatList.func_27361_a(var10);
            if(var12 == null) {
               System.out.println(var10 + " is not a valid stat");
            } else {
               var3.append(StatList.func_27361_a(var10).field_25069_f).append(",");
               var3.append(var11).append(",");
               var1.put(var12, Integer.valueOf(var11));
            }
         }

         MD5String var14 = new MD5String(var2);
         String var15 = var14.func_27369_a(var3.toString());
         if(!var15.equals(var4.func_27213_a(new Object[]{"checksum"}))) {
            System.out.println("CHECKSUM MISMATCH");
            return null;
         }
      } catch (InvalidSyntaxException var13) {
         var13.printStackTrace();
      }

      return var1;
   }

   public static String func_27185_a(String p_27185_0_, String p_27185_1_, Map p_27185_2_) {
      StringBuilder var3 = new StringBuilder();
      StringBuilder var4 = new StringBuilder();
      boolean var5 = true;
      var3.append("{\r\n");
      if(p_27185_0_ != null && p_27185_1_ != null) {
         var3.append("  \"user\":{\r\n");
         var3.append("    \"name\":\"").append(p_27185_0_).append("\",\r\n");
         var3.append("    \"sessionid\":\"").append(p_27185_1_).append("\"\r\n");
         var3.append("  },\r\n");
      }

      var3.append("  \"stats-change\":[");
      Iterator var6 = p_27185_2_.keySet().iterator();

      while(var6.hasNext()) {
         StatBase var7 = (StatBase)var6.next();
         if(!var5) {
            var3.append("},");
         } else {
            var5 = false;
         }

         var3.append("\r\n    {\"").append(var7.field_25071_d).append("\":").append(p_27185_2_.get(var7));
         var4.append(var7.field_25069_f).append(",");
         var4.append(p_27185_2_.get(var7)).append(",");
      }

      if(!var5) {
         var3.append("}");
      }

      MD5String var8 = new MD5String(p_27185_1_);
      var3.append("\r\n  ],\r\n");
      var3.append("  \"checksum\":\"").append(var8.func_27369_a(var4.toString())).append("\"\r\n");
      var3.append("}");
      return var3.toString();
   }

   public boolean func_27183_a(Achievement p_27183_1_) {
      return this.field_25102_a.containsKey(p_27183_1_);
   }

   public boolean func_27181_b(Achievement p_27181_1_) {
      return p_27181_1_.field_25076_c == null || this.func_27183_a(p_27181_1_.field_25076_c);
   }

   public int func_27184_a(StatBase p_27184_1_) {
      Integer var2 = (Integer)this.field_25102_a.get(p_27184_1_);
      return var2 == null?0:var2.intValue();
   }

   public void func_27175_b() {}

   public void func_27182_c() {
      this.field_27188_d.func_27407_b(this.func_27176_a());
   }

   public void func_27178_d() {
      if(this.field_27189_c && this.field_27188_d.func_27420_b()) {
         this.field_27188_d.func_27424_a(this.func_27176_a());
      }

      this.field_27188_d.func_27425_c();
   }
}
