package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.src.CompressedStreamTools;
import net.minecraft.src.ISaveHandler;
import net.minecraft.src.NBTBase;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagShort;
import net.minecraft.src.WorldSavedData;

public class MapStorage {

   private ISaveHandler field_28191_a;
   private Map field_28190_b = new HashMap();
   private List field_28193_c = new ArrayList();
   private Map field_28192_d = new HashMap();


   public MapStorage(ISaveHandler p_i713_1_) {
      this.field_28191_a = p_i713_1_;
      this.func_28187_b();
   }

   public WorldSavedData func_28185_a(Class p_28185_1_, String p_28185_2_) {
      WorldSavedData var3 = (WorldSavedData)this.field_28190_b.get(p_28185_2_);
      if(var3 != null) {
         return var3;
      } else {
         if(this.field_28191_a != null) {
            try {
               File var4 = this.field_28191_a.func_28113_a(p_28185_2_);
               if(var4 != null && var4.exists()) {
                  try {
                     var3 = (WorldSavedData)p_28185_1_.getConstructor(new Class[]{String.class}).newInstance(new Object[]{p_28185_2_});
                  } catch (Exception var7) {
                     throw new RuntimeException("Failed to instantiate " + p_28185_1_.toString(), var7);
                  }

                  FileInputStream var5 = new FileInputStream(var4);
                  NBTTagCompound var6 = CompressedStreamTools.func_1138_a(var5);
                  var5.close();
                  var3.func_28163_a(var6.func_743_k("data"));
               }
            } catch (Exception var8) {
               var8.printStackTrace();
            }
         }

         if(var3 != null) {
            this.field_28190_b.put(p_28185_2_, var3);
            this.field_28193_c.add(var3);
         }

         return var3;
      }
   }

   public void func_28184_a(String p_28184_1_, WorldSavedData p_28184_2_) {
      if(p_28184_2_ == null) {
         throw new RuntimeException("Can\'t set null data");
      } else {
         if(this.field_28190_b.containsKey(p_28184_1_)) {
            this.field_28193_c.remove(this.field_28190_b.remove(p_28184_1_));
         }

         this.field_28190_b.put(p_28184_1_, p_28184_2_);
         this.field_28193_c.add(p_28184_2_);
      }
   }

   public void func_28188_a() {
      for(int var1 = 0; var1 < this.field_28193_c.size(); ++var1) {
         WorldSavedData var2 = (WorldSavedData)this.field_28193_c.get(var1);
         if(var2.func_28166_b()) {
            this.func_28189_a(var2);
            var2.func_28165_a(false);
         }
      }

   }

   private void func_28189_a(WorldSavedData p_28189_1_) {
      if(this.field_28191_a != null) {
         try {
            File var2 = this.field_28191_a.func_28113_a(p_28189_1_.field_28168_a);
            if(var2 != null) {
               NBTTagCompound var3 = new NBTTagCompound();
               p_28189_1_.func_28162_b(var3);
               NBTTagCompound var4 = new NBTTagCompound();
               var4.func_763_a("data", var3);
               FileOutputStream var5 = new FileOutputStream(var2);
               CompressedStreamTools.func_1143_a(var4, var5);
               var5.close();
            }
         } catch (Exception var6) {
            var6.printStackTrace();
         }

      }
   }

   private void func_28187_b() {
      try {
         this.field_28192_d.clear();
         if(this.field_28191_a == null) {
            return;
         }

         File var1 = this.field_28191_a.func_28113_a("idcounts");
         if(var1 != null && var1.exists()) {
            DataInputStream var2 = new DataInputStream(new FileInputStream(var1));
            NBTTagCompound var3 = CompressedStreamTools.func_1141_a(var2);
            var2.close();
            Iterator var4 = var3.func_28110_c().iterator();

            while(var4.hasNext()) {
               NBTBase var5 = (NBTBase)var4.next();
               if(var5 instanceof NBTTagShort) {
                  NBTTagShort var6 = (NBTTagShort)var5;
                  String var7 = var6.func_737_b();
                  short var8 = var6.field_1088_a;
                  this.field_28192_d.put(var7, Short.valueOf(var8));
               }
            }
         }
      } catch (Exception var9) {
         var9.printStackTrace();
      }

   }

   public int func_28186_a(String p_28186_1_) {
      Short var2 = (Short)this.field_28192_d.get(p_28186_1_);
      if(var2 == null) {
         var2 = Short.valueOf((short)0);
      } else {
         var2 = Short.valueOf((short)(var2.shortValue() + 1));
      }

      this.field_28192_d.put(p_28186_1_, var2);
      if(this.field_28191_a == null) {
         return var2.shortValue();
      } else {
         try {
            File var3 = this.field_28191_a.func_28113_a("idcounts");
            if(var3 != null) {
               NBTTagCompound var4 = new NBTTagCompound();
               Iterator var5 = this.field_28192_d.keySet().iterator();

               while(var5.hasNext()) {
                  String var6 = (String)var5.next();
                  short var7 = ((Short)this.field_28192_d.get(var6)).shortValue();
                  var4.func_749_a(var6, var7);
               }

               DataOutputStream var9 = new DataOutputStream(new FileOutputStream(var3));
               CompressedStreamTools.func_1139_a(var4, var9);
               var9.close();
            }
         } catch (Exception var8) {
            var8.printStackTrace();
         }

         return var2.shortValue();
      }
   }
}
