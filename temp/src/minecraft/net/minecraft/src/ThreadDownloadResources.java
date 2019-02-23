package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import net.minecraft.client.Minecraft;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ThreadDownloadResources extends Thread {

   public File field_1768_a;
   private Minecraft field_1767_b;
   private boolean field_1769_c = false;


   public ThreadDownloadResources(File p_i264_1_, Minecraft p_i264_2_) {
      this.field_1767_b = p_i264_2_;
      this.setName("Resource download thread");
      this.setDaemon(true);
      this.field_1768_a = new File(p_i264_1_, "resources/");
      if(!this.field_1768_a.exists() && !this.field_1768_a.mkdirs()) {
         throw new RuntimeException("The working directory could not be created: " + this.field_1768_a);
      }
   }

   public void run() {
      try {
         URL var1 = new URL("http://s3.amazonaws.com/MinecraftResources/");
         DocumentBuilderFactory var2 = DocumentBuilderFactory.newInstance();
         DocumentBuilder var3 = var2.newDocumentBuilder();
         Document var4 = var3.parse(var1.openStream());
         NodeList var5 = var4.getElementsByTagName("Contents");

         for(int var6 = 0; var6 < 2; ++var6) {
            for(int var7 = 0; var7 < var5.getLength(); ++var7) {
               Node var8 = var5.item(var7);
               if(var8.getNodeType() == 1) {
                  Element var9 = (Element)var8;
                  String var10 = ((Element)var9.getElementsByTagName("Key").item(0)).getChildNodes().item(0).getNodeValue();
                  long var11 = Long.parseLong(((Element)var9.getElementsByTagName("Size").item(0)).getChildNodes().item(0).getNodeValue());
                  if(var11 > 0L) {
                     this.func_1211_a(var1, var10, var11, var6);
                     if(this.field_1769_c) {
                        return;
                     }
                  }
               }
            }
         }
      } catch (Exception var13) {
         this.func_1209_a(this.field_1768_a, "");
         var13.printStackTrace();
      }

   }

   public void func_1210_a() {
      this.func_1209_a(this.field_1768_a, "");
   }

   private void func_1209_a(File p_1209_1_, String p_1209_2_) {
      File[] var3 = p_1209_1_.listFiles();

      for(int var4 = 0; var4 < var3.length; ++var4) {
         if(var3[var4].isDirectory()) {
            this.func_1209_a(var3[var4], p_1209_2_ + var3[var4].getName() + "/");
         } else {
            try {
               this.field_1767_b.func_6268_a(p_1209_2_ + var3[var4].getName(), var3[var4]);
            } catch (Exception var6) {
               System.out.println("Failed to add " + p_1209_2_ + var3[var4].getName());
            }
         }
      }

   }

   private void func_1211_a(URL p_1211_1_, String p_1211_2_, long p_1211_3_, int p_1211_5_) {
      try {
         int var6 = p_1211_2_.indexOf("/");
         String var7 = p_1211_2_.substring(0, var6);
         if(!var7.equals("sound") && !var7.equals("newsound")) {
            if(p_1211_5_ != 1) {
               return;
            }
         } else if(p_1211_5_ != 0) {
            return;
         }

         File var8 = new File(this.field_1768_a, p_1211_2_);
         if(!var8.exists() || var8.length() != p_1211_3_) {
            var8.getParentFile().mkdirs();
            String var9 = p_1211_2_.replaceAll(" ", "%20");
            this.func_1212_a(new URL(p_1211_1_, var9), var8, p_1211_3_);
            if(this.field_1769_c) {
               return;
            }
         }

         this.field_1767_b.func_6268_a(p_1211_2_, var8);
      } catch (Exception var10) {
         var10.printStackTrace();
      }

   }

   private void func_1212_a(URL p_1212_1_, File p_1212_2_, long p_1212_3_) throws IOException {
      byte[] var5 = new byte[4096];
      DataInputStream var6 = new DataInputStream(p_1212_1_.openStream());
      DataOutputStream var7 = new DataOutputStream(new FileOutputStream(p_1212_2_));
      boolean var8 = false;

      do {
         int var9;
         if((var9 = var6.read(var5)) < 0) {
            var6.close();
            var7.close();
            return;
         }

         var7.write(var5, 0, var9);
      } while(!this.field_1769_c);

   }

   public void func_1208_b() {
      this.field_1769_c = true;
   }
}
