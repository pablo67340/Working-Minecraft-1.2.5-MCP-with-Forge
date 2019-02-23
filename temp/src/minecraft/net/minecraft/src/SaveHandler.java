package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import net.minecraft.src.CompressedStreamTools;
import net.minecraft.src.IChunkLoader;
import net.minecraft.src.ISaveHandler;
import net.minecraft.src.MinecraftException;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.WorldInfo;
import net.minecraft.src.WorldProvider;

public class SaveHandler implements ISaveHandler {

   private static final Logger field_22156_a = Logger.getLogger("Minecraft");
   private final File field_22155_b;
   private final File field_22158_c;
   private final File field_28114_d;
   private final long field_22157_d = System.currentTimeMillis();
   private final String field_40531_f;


   public SaveHandler(File p_i299_1_, String p_i299_2_, boolean p_i299_3_) {
      this.field_22155_b = new File(p_i299_1_, p_i299_2_);
      this.field_22155_b.mkdirs();
      this.field_22158_c = new File(this.field_22155_b, "players");
      this.field_28114_d = new File(this.field_22155_b, "data");
      this.field_28114_d.mkdirs();
      this.field_40531_f = p_i299_2_;
      if(p_i299_3_) {
         this.field_22158_c.mkdirs();
      }

      this.func_22154_d();
   }

   private void func_22154_d() {
      try {
         File var1 = new File(this.field_22155_b, "session.lock");
         DataOutputStream var2 = new DataOutputStream(new FileOutputStream(var1));

         try {
            var2.writeLong(this.field_22157_d);
         } finally {
            var2.close();
         }

      } catch (IOException var7) {
         var7.printStackTrace();
         throw new RuntimeException("Failed to check session lock, aborting");
      }
   }

   protected File func_22153_a() {
      return this.field_22155_b;
   }

   public void func_22150_b() {
      try {
         File var1 = new File(this.field_22155_b, "session.lock");
         DataInputStream var2 = new DataInputStream(new FileInputStream(var1));

         try {
            if(var2.readLong() != this.field_22157_d) {
               throw new MinecraftException("The save is being accessed from another location, aborting");
            }
         } finally {
            var2.close();
         }

      } catch (IOException var7) {
         throw new MinecraftException("Failed to check session lock, aborting");
      }
   }

   public IChunkLoader func_22149_a(WorldProvider p_22149_1_) {
      throw new RuntimeException("Old Chunk Storage is no longer supported.");
   }

   public WorldInfo func_22151_c() {
      File var1 = new File(this.field_22155_b, "level.dat");
      NBTTagCompound var2;
      NBTTagCompound var3;
      if(var1.exists()) {
         try {
            var2 = CompressedStreamTools.func_1138_a(new FileInputStream(var1));
            var3 = var2.func_743_k("Data");
            return new WorldInfo(var3);
         } catch (Exception var5) {
            var5.printStackTrace();
         }
      }

      var1 = new File(this.field_22155_b, "level.dat_old");
      if(var1.exists()) {
         try {
            var2 = CompressedStreamTools.func_1138_a(new FileInputStream(var1));
            var3 = var2.func_743_k("Data");
            return new WorldInfo(var3);
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      }

      return null;
   }

   public void func_22148_a(WorldInfo p_22148_1_, List p_22148_2_) {
      NBTTagCompound var3 = p_22148_1_.func_22305_a(p_22148_2_);
      NBTTagCompound var4 = new NBTTagCompound();
      var4.func_762_a("Data", var3);

      try {
         File var5 = new File(this.field_22155_b, "level.dat_new");
         File var6 = new File(this.field_22155_b, "level.dat_old");
         File var7 = new File(this.field_22155_b, "level.dat");
         CompressedStreamTools.func_1143_a(var4, new FileOutputStream(var5));
         if(var6.exists()) {
            var6.delete();
         }

         var7.renameTo(var6);
         if(var7.exists()) {
            var7.delete();
         }

         var5.renameTo(var7);
         if(var5.exists()) {
            var5.delete();
         }
      } catch (Exception var8) {
         var8.printStackTrace();
      }

   }

   public void func_22152_a(WorldInfo p_22152_1_) {
      NBTTagCompound var2 = p_22152_1_.func_22299_a();
      NBTTagCompound var3 = new NBTTagCompound();
      var3.func_762_a("Data", var2);

      try {
         File var4 = new File(this.field_22155_b, "level.dat_new");
         File var5 = new File(this.field_22155_b, "level.dat_old");
         File var6 = new File(this.field_22155_b, "level.dat");
         CompressedStreamTools.func_1143_a(var3, new FileOutputStream(var4));
         if(var5.exists()) {
            var5.delete();
         }

         var6.renameTo(var5);
         if(var6.exists()) {
            var6.delete();
         }

         var4.renameTo(var6);
         if(var4.exists()) {
            var4.delete();
         }
      } catch (Exception var7) {
         var7.printStackTrace();
      }

   }

   public File func_28113_a(String p_28113_1_) {
      return new File(this.field_28114_d, p_28113_1_ + ".dat");
   }

   public String func_40530_d() {
      return this.field_40531_f;
   }

}
