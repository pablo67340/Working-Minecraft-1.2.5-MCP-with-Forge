package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.src.AnvilConverterData;
import net.minecraft.src.AnvilSaveConverterFileFilter;
import net.minecraft.src.AnvilSaveHandler;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.ChunkLoader;
import net.minecraft.src.CompressedStreamTools;
import net.minecraft.src.IProgressUpdate;
import net.minecraft.src.ISaveHandler;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.RegionFile;
import net.minecraft.src.RegionFileCache;
import net.minecraft.src.SaveFormatComparator;
import net.minecraft.src.SaveFormatOld;
import net.minecraft.src.WorldChunkManager;
import net.minecraft.src.WorldChunkManagerHell;
import net.minecraft.src.WorldInfo;
import net.minecraft.src.WorldType;

public class AnvilSaveConverter extends SaveFormatOld {

   public AnvilSaveConverter(File p_i1034_1_) {
      super(p_i1034_1_);
   }

   public String func_22178_a() {
      return "Anvil";
   }

   public List func_22176_b() {
      ArrayList var1 = new ArrayList();
      File[] var2 = this.field_22180_a.listFiles();
      File[] var3 = var2;
      int var4 = var2.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         File var6 = var3[var5];
         if(var6.isDirectory()) {
            String var7 = var6.getName();
            WorldInfo var8 = this.func_22173_b(var7);
            if(var8 != null && (var8.func_22296_k() == 19132 || var8.func_22296_k() == 19133)) {
               boolean var9 = var8.func_22296_k() != this.func_48431_c();
               String var10 = var8.func_22302_j();
               if(var10 == null || MathHelper.func_22282_a(var10)) {
                  var10 = var7;
               }

               long var11 = 0L;
               var1.add(new SaveFormatComparator(var7, var10, var8.func_22301_l(), var11, var8.func_35918_q(), var9, var8.func_40724_s()));
            }
         }
      }

      return var1;
   }

   protected int func_48431_c() {
      return 19133;
   }

   public void func_22177_c() {
      RegionFileCache.func_22192_a();
   }

   public ISaveHandler func_22174_a(String p_22174_1_, boolean p_22174_2_) {
      return new AnvilSaveHandler(this.field_22180_a, p_22174_1_, p_22174_2_);
   }

   public boolean func_22175_a(String p_22175_1_) {
      WorldInfo var2 = this.func_22173_b(p_22175_1_);
      return var2 != null && var2.func_22296_k() != this.func_48431_c();
   }

   public boolean func_22171_a(String p_22171_1_, IProgressUpdate p_22171_2_) {
      p_22171_2_.func_593_a(0);
      ArrayList var3 = new ArrayList();
      ArrayList var4 = new ArrayList();
      ArrayList var5 = new ArrayList();
      File var6 = new File(this.field_22180_a, p_22171_1_);
      File var7 = new File(var6, "DIM-1");
      File var8 = new File(var6, "DIM1");
      System.out.println("Scanning folders...");
      this.func_48432_a(var6, var3);
      if(var7.exists()) {
         this.func_48432_a(var7, var4);
      }

      if(var8.exists()) {
         this.func_48432_a(var8, var5);
      }

      int var9 = var3.size() + var4.size() + var5.size();
      System.out.println("Total conversion count is " + var9);
      WorldInfo var10 = this.func_22173_b(p_22171_1_);
      Object var11 = null;
      if(var10.func_46133_t() == WorldType.field_48636_c) {
         var11 = new WorldChunkManagerHell(BiomeGenBase.field_35485_c, 0.5F, 0.5F);
      } else {
         var11 = new WorldChunkManager(var10.func_22288_b(), var10.func_46133_t());
      }

      this.func_48428_a(new File(var6, "region"), var3, (WorldChunkManager)var11, 0, var9, p_22171_2_);
      this.func_48428_a(new File(var7, "region"), var4, new WorldChunkManagerHell(BiomeGenBase.field_4245_l, 1.0F, 0.0F), var3.size(), var9, p_22171_2_);
      this.func_48428_a(new File(var8, "region"), var5, new WorldChunkManagerHell(BiomeGenBase.field_28057_m, 0.5F, 0.0F), var3.size() + var4.size(), var9, p_22171_2_);
      var10.func_22289_d(19133);
      if(var10.func_46133_t() == WorldType.field_48634_d) {
         var10.func_48619_a(WorldType.field_48635_b);
      }

      this.func_48429_d(p_22171_1_);
      ISaveHandler var12 = this.func_22174_a(p_22171_1_, false);
      var12.func_22152_a(var10);
      return true;
   }

   private void func_48429_d(String p_48429_1_) {
      File var2 = new File(this.field_22180_a, p_48429_1_);
      if(!var2.exists()) {
         System.out.println("Warning: Unable to create level.dat_mcr backup");
      } else {
         File var3 = new File(var2, "level.dat");
         if(!var3.exists()) {
            System.out.println("Warning: Unable to create level.dat_mcr backup");
         } else {
            File var4 = new File(var2, "level.dat_mcr");
            if(!var3.renameTo(var4)) {
               System.out.println("Warning: Unable to create level.dat_mcr backup");
            }

         }
      }
   }

   private void func_48428_a(File p_48428_1_, ArrayList p_48428_2_, WorldChunkManager p_48428_3_, int p_48428_4_, int p_48428_5_, IProgressUpdate p_48428_6_) {
      Iterator var7 = p_48428_2_.iterator();

      while(var7.hasNext()) {
         File var8 = (File)var7.next();
         this.func_48430_a(p_48428_1_, var8, p_48428_3_, p_48428_4_, p_48428_5_, p_48428_6_);
         ++p_48428_4_;
         int var9 = (int)Math.round(100.0D * (double)p_48428_4_ / (double)p_48428_5_);
         p_48428_6_.func_593_a(var9);
      }

   }

   private void func_48430_a(File p_48430_1_, File p_48430_2_, WorldChunkManager p_48430_3_, int p_48430_4_, int p_48430_5_, IProgressUpdate p_48430_6_) {
      try {
         String var7 = p_48430_2_.getName();
         RegionFile var8 = new RegionFile(p_48430_2_);
         RegionFile var9 = new RegionFile(new File(p_48430_1_, var7.substring(0, var7.length() - ".mcr".length()) + ".mca"));

         for(int var10 = 0; var10 < 32; ++var10) {
            int var11;
            for(var11 = 0; var11 < 32; ++var11) {
               if(var8.func_22202_c(var10, var11) && !var9.func_22202_c(var10, var11)) {
                  DataInputStream var12 = var8.func_22210_a(var10, var11);
                  if(var12 == null) {
                     System.out.println("Failed to fetch input stream");
                  } else {
                     NBTTagCompound var13 = CompressedStreamTools.func_1141_a(var12);
                     var12.close();
                     NBTTagCompound var14 = var13.func_743_k("Level");
                     AnvilConverterData var15 = ChunkLoader.func_48485_a(var14);
                     NBTTagCompound var16 = new NBTTagCompound();
                     NBTTagCompound var17 = new NBTTagCompound();
                     var16.func_762_a("Level", var17);
                     ChunkLoader.func_48486_a(var15, var17, p_48430_3_);
                     DataOutputStream var18 = var9.func_22205_b(var10, var11);
                     CompressedStreamTools.func_1139_a(var16, var18);
                     var18.close();
                  }
               }
            }

            var11 = (int)Math.round(100.0D * (double)(p_48430_4_ * 1024) / (double)(p_48430_5_ * 1024));
            int var20 = (int)Math.round(100.0D * (double)((var10 + 1) * 32 + p_48430_4_ * 1024) / (double)(p_48430_5_ * 1024));
            if(var20 > var11) {
               p_48430_6_.func_593_a(var20);
            }
         }

         var8.func_22196_b();
         var9.func_22196_b();
      } catch (IOException var19) {
         var19.printStackTrace();
      }

   }

   private void func_48432_a(File p_48432_1_, ArrayList p_48432_2_) {
      File var3 = new File(p_48432_1_, "region");
      File[] var4 = var3.listFiles(new AnvilSaveConverterFileFilter(this));
      if(var4 != null) {
         File[] var5 = var4;
         int var6 = var4.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            File var8 = var5[var7];
            p_48432_2_.add(var8);
         }
      }

   }
}
