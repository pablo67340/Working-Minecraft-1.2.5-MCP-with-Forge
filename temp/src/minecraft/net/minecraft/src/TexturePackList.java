package net.minecraft.src;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.src.TexturePackBase;
import net.minecraft.src.TexturePackCustom;
import net.minecraft.src.TexturePackDefault;
import net.minecraft.src.TexturePackFolder;

public class TexturePackList {

   private List field_6533_b = new ArrayList();
   private TexturePackBase field_6539_c = new TexturePackDefault();
   public TexturePackBase field_6534_a;
   private Map field_6538_d = new HashMap();
   private Minecraft field_6537_e;
   private File field_6536_f;
   private String field_6535_g;


   public TexturePackList(Minecraft p_i340_1_, File p_i340_2_) {
      this.field_6537_e = p_i340_1_;
      this.field_6536_f = new File(p_i340_2_, "texturepacks");
      if(this.field_6536_f.exists()) {
         if(!this.field_6536_f.isDirectory()) {
            this.field_6536_f.delete();
            this.field_6536_f.mkdirs();
         }
      } else {
         this.field_6536_f.mkdirs();
      }

      this.field_6535_g = p_i340_1_.field_6304_y.field_6524_j;
      this.func_6532_a();
      this.field_6534_a.func_6482_a();
   }

   public boolean func_6531_a(TexturePackBase p_6531_1_) {
      if(p_6531_1_ == this.field_6534_a) {
         return false;
      } else {
         this.field_6534_a.func_6480_b();
         this.field_6535_g = p_6531_1_.field_6487_a;
         this.field_6534_a = p_6531_1_;
         this.field_6537_e.field_6304_y.field_6524_j = this.field_6535_g;
         this.field_6537_e.field_6304_y.func_1041_b();
         this.field_6534_a.func_6482_a();
         return true;
      }
   }

   public void func_6532_a() {
      ArrayList var1 = new ArrayList();
      this.field_6534_a = null;
      var1.add(this.field_6539_c);
      if(this.field_6536_f.exists() && this.field_6536_f.isDirectory()) {
         File[] var2 = this.field_6536_f.listFiles();
         File[] var3 = var2;
         int var4 = var2.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            File var6 = var3[var5];
            String var7;
            TexturePackBase var13;
            if(var6.isFile() && var6.getName().toLowerCase().endsWith(".zip")) {
               var7 = var6.getName() + ":" + var6.length() + ":" + var6.lastModified();

               try {
                  if(!this.field_6538_d.containsKey(var7)) {
                     TexturePackCustom var14 = new TexturePackCustom(var6);
                     var14.field_6488_d = var7;
                     this.field_6538_d.put(var7, var14);
                     var14.func_6485_a(this.field_6537_e);
                  }

                  var13 = (TexturePackBase)this.field_6538_d.get(var7);
                  if(var13.field_6487_a.equals(this.field_6535_g)) {
                     this.field_6534_a = var13;
                  }

                  var1.add(var13);
               } catch (IOException var10) {
                  var10.printStackTrace();
               }
            } else if(var6.isDirectory() && (new File(var6, "pack.txt")).exists()) {
               var7 = var6.getName() + ":folder:" + var6.lastModified();

               try {
                  if(!this.field_6538_d.containsKey(var7)) {
                     TexturePackFolder var8 = new TexturePackFolder(var6);
                     var8.field_6488_d = var7;
                     this.field_6538_d.put(var7, var8);
                     var8.func_6485_a(this.field_6537_e);
                  }

                  var13 = (TexturePackBase)this.field_6538_d.get(var7);
                  if(var13.field_6487_a.equals(this.field_6535_g)) {
                     this.field_6534_a = var13;
                  }

                  var1.add(var13);
               } catch (IOException var9) {
                  var9.printStackTrace();
               }
            }
         }
      }

      if(this.field_6534_a == null) {
         this.field_6534_a = this.field_6539_c;
      }

      this.field_6533_b.removeAll(var1);
      Iterator var11 = this.field_6533_b.iterator();

      while(var11.hasNext()) {
         TexturePackBase var12 = (TexturePackBase)var11.next();
         var12.func_6484_b(this.field_6537_e);
         this.field_6538_d.remove(var12.field_6488_d);
      }

      this.field_6533_b = var1;
   }

   public List func_6530_b() {
      return new ArrayList(this.field_6533_b);
   }
}
