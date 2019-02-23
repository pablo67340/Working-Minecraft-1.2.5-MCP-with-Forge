package net.minecraft.src;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import net.minecraft.src.NBTBase;
import net.minecraft.src.NBTTagCompound;

public class CompressedStreamTools {

   public static NBTTagCompound func_1138_a(InputStream p_1138_0_) throws IOException {
      DataInputStream var1 = new DataInputStream(new BufferedInputStream(new GZIPInputStream(p_1138_0_)));

      NBTTagCompound var2;
      try {
         var2 = func_1141_a(var1);
      } finally {
         var1.close();
      }

      return var2;
   }

   public static void func_1143_a(NBTTagCompound p_1143_0_, OutputStream p_1143_1_) throws IOException {
      DataOutputStream var2 = new DataOutputStream(new GZIPOutputStream(p_1143_1_));

      try {
         func_1139_a(p_1143_0_, var2);
      } finally {
         var2.close();
      }

   }

   public static NBTTagCompound func_40592_a(byte[] p_40592_0_) throws IOException {
      DataInputStream var1 = new DataInputStream(new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(p_40592_0_))));

      NBTTagCompound var2;
      try {
         var2 = func_1141_a(var1);
      } finally {
         var1.close();
      }

      return var2;
   }

   public static byte[] func_40591_a(NBTTagCompound p_40591_0_) throws IOException {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      DataOutputStream var2 = new DataOutputStream(new GZIPOutputStream(var1));

      try {
         func_1139_a(p_40591_0_, var2);
      } finally {
         var2.close();
      }

      return var1.toByteArray();
   }

   public static void func_35621_a(NBTTagCompound p_35621_0_, File p_35621_1_) throws IOException {
      File var2 = new File(p_35621_1_.getAbsolutePath() + "_tmp");
      if(var2.exists()) {
         var2.delete();
      }

      func_35620_b(p_35621_0_, var2);
      if(p_35621_1_.exists()) {
         p_35621_1_.delete();
      }

      if(p_35621_1_.exists()) {
         throw new IOException("Failed to delete " + p_35621_1_);
      } else {
         var2.renameTo(p_35621_1_);
      }
   }

   public static void func_35620_b(NBTTagCompound p_35620_0_, File p_35620_1_) throws IOException {
      DataOutputStream var2 = new DataOutputStream(new FileOutputStream(p_35620_1_));

      try {
         func_1139_a(p_35620_0_, var2);
      } finally {
         var2.close();
      }

   }

   public static NBTTagCompound func_35622_a(File p_35622_0_) throws IOException {
      if(!p_35622_0_.exists()) {
         return null;
      } else {
         DataInputStream var1 = new DataInputStream(new FileInputStream(p_35622_0_));

         NBTTagCompound var2;
         try {
            var2 = func_1141_a(var1);
         } finally {
            var1.close();
         }

         return var2;
      }
   }

   public static NBTTagCompound func_1141_a(DataInput p_1141_0_) throws IOException {
      NBTBase var1 = NBTBase.func_734_b(p_1141_0_);
      if(var1 instanceof NBTTagCompound) {
         return (NBTTagCompound)var1;
      } else {
         throw new IOException("Root tag must be a named compound tag");
      }
   }

   public static void func_1139_a(NBTTagCompound p_1139_0_, DataOutput p_1139_1_) throws IOException {
      NBTBase.func_738_a(p_1139_0_, p_1139_1_);
   }
}
