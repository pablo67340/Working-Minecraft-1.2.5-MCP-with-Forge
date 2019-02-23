package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Packet;
import net.minecraft.src.WatchableObject;

public class DataWatcher {

   private static final HashMap field_21133_a = new HashMap();
   private final Map field_21132_b = new HashMap();
   private boolean field_21134_c;


   public void func_21124_a(int p_21124_1_, Object p_21124_2_) {
      Integer var3 = (Integer)field_21133_a.get(p_21124_2_.getClass());
      if(var3 == null) {
         throw new IllegalArgumentException("Unknown data type: " + p_21124_2_.getClass());
      } else if(p_21124_1_ > 31) {
         throw new IllegalArgumentException("Data value id is too big with " + p_21124_1_ + "! (Max is " + 31 + ")");
      } else if(this.field_21132_b.containsKey(Integer.valueOf(p_21124_1_))) {
         throw new IllegalArgumentException("Duplicate id value for " + p_21124_1_ + "!");
      } else {
         WatchableObject var4 = new WatchableObject(var3.intValue(), p_21124_1_, p_21124_2_);
         this.field_21132_b.put(Integer.valueOf(p_21124_1_), var4);
      }
   }

   public byte func_21130_a(int p_21130_1_) {
      return ((Byte)((WatchableObject)this.field_21132_b.get(Integer.valueOf(p_21130_1_))).func_21158_b()).byteValue();
   }

   public short func_41062_b(int p_41062_1_) {
      return ((Short)((WatchableObject)this.field_21132_b.get(Integer.valueOf(p_41062_1_))).func_21158_b()).shortValue();
   }

   public int func_25115_b(int p_25115_1_) {
      return ((Integer)((WatchableObject)this.field_21132_b.get(Integer.valueOf(p_25115_1_))).func_21158_b()).intValue();
   }

   public String func_25116_c(int p_25116_1_) {
      return (String)((WatchableObject)this.field_21132_b.get(Integer.valueOf(p_25116_1_))).func_21158_b();
   }

   public void func_21129_b(int p_21129_1_, Object p_21129_2_) {
      WatchableObject var3 = (WatchableObject)this.field_21132_b.get(Integer.valueOf(p_21129_1_));
      if(!p_21129_2_.equals(var3.func_21158_b())) {
         var3.func_21160_a(p_21129_2_);
         var3.func_21162_a(true);
         this.field_21134_c = true;
      }

   }

   public static void func_21125_a(List p_21125_0_, DataOutputStream p_21125_1_) throws IOException {
      if(p_21125_0_ != null) {
         Iterator var2 = p_21125_0_.iterator();

         while(var2.hasNext()) {
            WatchableObject var3 = (WatchableObject)var2.next();
            func_21128_a(p_21125_1_, var3);
         }
      }

      p_21125_1_.writeByte(127);
   }

   public void func_21127_a(DataOutputStream p_21127_1_) throws IOException {
      Iterator var2 = this.field_21132_b.values().iterator();

      while(var2.hasNext()) {
         WatchableObject var3 = (WatchableObject)var2.next();
         func_21128_a(p_21127_1_, var3);
      }

      p_21127_1_.writeByte(127);
   }

   private static void func_21128_a(DataOutputStream p_21128_0_, WatchableObject p_21128_1_) throws IOException {
      int var2 = (p_21128_1_.func_21159_c() << 5 | p_21128_1_.func_21161_a() & 31) & 255;
      p_21128_0_.writeByte(var2);
      switch(p_21128_1_.func_21159_c()) {
      case 0:
         p_21128_0_.writeByte(((Byte)p_21128_1_.func_21158_b()).byteValue());
         break;
      case 1:
         p_21128_0_.writeShort(((Short)p_21128_1_.func_21158_b()).shortValue());
         break;
      case 2:
         p_21128_0_.writeInt(((Integer)p_21128_1_.func_21158_b()).intValue());
         break;
      case 3:
         p_21128_0_.writeFloat(((Float)p_21128_1_.func_21158_b()).floatValue());
         break;
      case 4:
         Packet.func_27049_a((String)p_21128_1_.func_21158_b(), p_21128_0_);
         break;
      case 5:
         ItemStack var4 = (ItemStack)p_21128_1_.func_21158_b();
         p_21128_0_.writeShort(var4.func_1091_a().field_291_aS);
         p_21128_0_.writeByte(var4.field_1615_a);
         p_21128_0_.writeShort(var4.func_21181_i());
         break;
      case 6:
         ChunkCoordinates var3 = (ChunkCoordinates)p_21128_1_.func_21158_b();
         p_21128_0_.writeInt(var3.field_22395_a);
         p_21128_0_.writeInt(var3.field_22394_b);
         p_21128_0_.writeInt(var3.field_22396_c);
      }

   }

   public static List func_21131_a(DataInputStream p_21131_0_) throws IOException {
      ArrayList var1 = null;

      for(byte var2 = p_21131_0_.readByte(); var2 != 127; var2 = p_21131_0_.readByte()) {
         if(var1 == null) {
            var1 = new ArrayList();
         }

         int var3 = (var2 & 224) >> 5;
         int var4 = var2 & 31;
         WatchableObject var5 = null;
         switch(var3) {
         case 0:
            var5 = new WatchableObject(var3, var4, Byte.valueOf(p_21131_0_.readByte()));
            break;
         case 1:
            var5 = new WatchableObject(var3, var4, Short.valueOf(p_21131_0_.readShort()));
            break;
         case 2:
            var5 = new WatchableObject(var3, var4, Integer.valueOf(p_21131_0_.readInt()));
            break;
         case 3:
            var5 = new WatchableObject(var3, var4, Float.valueOf(p_21131_0_.readFloat()));
            break;
         case 4:
            var5 = new WatchableObject(var3, var4, Packet.func_27048_a(p_21131_0_, 64));
            break;
         case 5:
            short var9 = p_21131_0_.readShort();
            byte var10 = p_21131_0_.readByte();
            short var11 = p_21131_0_.readShort();
            var5 = new WatchableObject(var3, var4, new ItemStack(var9, var10, var11));
            break;
         case 6:
            int var6 = p_21131_0_.readInt();
            int var7 = p_21131_0_.readInt();
            int var8 = p_21131_0_.readInt();
            var5 = new WatchableObject(var3, var4, new ChunkCoordinates(var6, var7, var8));
         }

         var1.add(var5);
      }

      return var1;
   }

   public void func_21126_a(List p_21126_1_) {
      Iterator var2 = p_21126_1_.iterator();

      while(var2.hasNext()) {
         WatchableObject var3 = (WatchableObject)var2.next();
         WatchableObject var4 = (WatchableObject)this.field_21132_b.get(Integer.valueOf(var3.func_21161_a()));
         if(var4 != null) {
            var4.func_21160_a(var3.func_21158_b());
         }
      }

   }

   static {
      field_21133_a.put(Byte.class, Integer.valueOf(0));
      field_21133_a.put(Short.class, Integer.valueOf(1));
      field_21133_a.put(Integer.class, Integer.valueOf(2));
      field_21133_a.put(Float.class, Integer.valueOf(3));
      field_21133_a.put(String.class, Integer.valueOf(4));
      field_21133_a.put(ItemStack.class, Integer.valueOf(5));
      field_21133_a.put(ChunkCoordinates.class, Integer.valueOf(6));
   }
}
