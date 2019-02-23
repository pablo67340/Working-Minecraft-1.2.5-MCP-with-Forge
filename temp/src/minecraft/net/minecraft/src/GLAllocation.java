package net.minecraft.src;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.opengl.GL11;

public class GLAllocation {

   private static List field_1671_a = new ArrayList();
   private static List field_1670_b = new ArrayList();


   public static synchronized int func_1124_a(int p_1124_0_) {
      int var1 = GL11.glGenLists(p_1124_0_);
      field_1671_a.add(Integer.valueOf(var1));
      field_1671_a.add(Integer.valueOf(p_1124_0_));
      return var1;
   }

   public static synchronized void func_1128_a(IntBuffer p_1128_0_) {
      GL11.glGenTextures(p_1128_0_);

      for(int var1 = p_1128_0_.position(); var1 < p_1128_0_.limit(); ++var1) {
         field_1670_b.add(Integer.valueOf(p_1128_0_.get(var1)));
      }

   }

   public static synchronized void func_28194_b(int p_28194_0_) {
      int var1 = field_1671_a.indexOf(Integer.valueOf(p_28194_0_));
      GL11.glDeleteLists(((Integer)field_1671_a.get(var1)).intValue(), ((Integer)field_1671_a.get(var1 + 1)).intValue());
      field_1671_a.remove(var1);
      field_1671_a.remove(var1);
   }

   public static synchronized void func_1126_a() {
      for(int var0 = 0; var0 < field_1671_a.size(); var0 += 2) {
         GL11.glDeleteLists(((Integer)field_1671_a.get(var0)).intValue(), ((Integer)field_1671_a.get(var0 + 1)).intValue());
      }

      IntBuffer var2 = func_1125_c(field_1670_b.size());
      var2.flip();
      GL11.glDeleteTextures(var2);

      for(int var1 = 0; var1 < field_1670_b.size(); ++var1) {
         var2.put(((Integer)field_1670_b.get(var1)).intValue());
      }

      var2.flip();
      GL11.glDeleteTextures(var2);
      field_1671_a.clear();
      field_1670_b.clear();
   }

   public static synchronized ByteBuffer func_1127_b(int p_1127_0_) {
      ByteBuffer var1 = ByteBuffer.allocateDirect(p_1127_0_).order(ByteOrder.nativeOrder());
      return var1;
   }

   public static IntBuffer func_1125_c(int p_1125_0_) {
      return func_1127_b(p_1125_0_ << 2).asIntBuffer();
   }

   public static FloatBuffer func_1123_d(int p_1123_0_) {
      return func_1127_b(p_1123_0_ << 2).asFloatBuffer();
   }

}
