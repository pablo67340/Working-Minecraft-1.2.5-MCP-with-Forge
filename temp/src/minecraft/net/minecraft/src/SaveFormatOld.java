package net.minecraft.src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.src.CompressedStreamTools;
import net.minecraft.src.IProgressUpdate;
import net.minecraft.src.ISaveFormat;
import net.minecraft.src.ISaveHandler;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.SaveFormatComparator;
import net.minecraft.src.SaveHandler;
import net.minecraft.src.WorldInfo;

public class SaveFormatOld implements ISaveFormat {

   protected final File field_22180_a;


   public SaveFormatOld(File p_i136_1_) {
      if(!p_i136_1_.exists()) {
         p_i136_1_.mkdirs();
      }

      this.field_22180_a = p_i136_1_;
   }

   public String func_22178_a() {
      return "Old Format";
   }

   public List func_22176_b() {
      ArrayList var1 = new ArrayList();

      for(int var2 = 0; var2 < 5; ++var2) {
         String var3 = "World" + (var2 + 1);
         WorldInfo var4 = this.func_22173_b(var3);
         if(var4 != null) {
            var1.add(new SaveFormatComparator(var3, "", var4.func_22301_l(), var4.func_22306_g(), var4.func_35918_q(), false, var4.func_40724_s()));
         }
      }

      return var1;
   }

   public void func_22177_c() {}

   public WorldInfo func_22173_b(String p_22173_1_) {
      File var2 = new File(this.field_22180_a, p_22173_1_);
      if(!var2.exists()) {
         return null;
      } else {
         File var3 = new File(var2, "level.dat");
         NBTTagCompound var4;
         NBTTagCompound var5;
         if(var3.exists()) {
            try {
               var4 = CompressedStreamTools.func_1138_a(new FileInputStream(var3));
               var5 = var4.func_743_k("Data");
               return new WorldInfo(var5);
            } catch (Exception var7) {
               var7.printStackTrace();
            }
         }

         var3 = new File(var2, "level.dat_old");
         if(var3.exists()) {
            try {
               var4 = CompressedStreamTools.func_1138_a(new FileInputStream(var3));
               var5 = var4.func_743_k("Data");
               return new WorldInfo(var5);
            } catch (Exception var6) {
               var6.printStackTrace();
            }
         }

         return null;
      }
   }

   public void func_22170_a(String p_22170_1_, String p_22170_2_) {
      File var3 = new File(this.field_22180_a, p_22170_1_);
      if(var3.exists()) {
         File var4 = new File(var3, "level.dat");
         if(var4.exists()) {
            try {
               NBTTagCompound var5 = CompressedStreamTools.func_1138_a(new FileInputStream(var4));
               NBTTagCompound var6 = var5.func_743_k("Data");
               var6.func_754_a("LevelName", p_22170_2_);
               CompressedStreamTools.func_1143_a(var5, new FileOutputStream(var4));
            } catch (Exception var7) {
               var7.printStackTrace();
            }
         }

      }
   }

   public void func_22172_c(String p_22172_1_) {
      File var2 = new File(this.field_22180_a, p_22172_1_);
      if(var2.exists()) {
         func_22179_a(var2.listFiles());
         var2.delete();
      }
   }

   protected static void func_22179_a(File[] p_22179_0_) {
      for(int var1 = 0; var1 < p_22179_0_.length; ++var1) {
         if(p_22179_0_[var1].isDirectory()) {
            System.out.println("Deleting " + p_22179_0_[var1]);
            func_22179_a(p_22179_0_[var1].listFiles());
         }

         p_22179_0_[var1].delete();
      }

   }

   public ISaveHandler func_22174_a(String p_22174_1_, boolean p_22174_2_) {
      return new SaveHandler(this.field_22180_a, p_22174_1_, p_22174_2_);
   }

   public boolean func_22175_a(String p_22175_1_) {
      return false;
   }

   public boolean func_22171_a(String p_22171_1_, IProgressUpdate p_22171_2_) {
      return false;
   }
}
