package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.src.NBTBase;
import net.minecraft.src.NBTTagByte;
import net.minecraft.src.NBTTagByteArray;
import net.minecraft.src.NBTTagDouble;
import net.minecraft.src.NBTTagFloat;
import net.minecraft.src.NBTTagInt;
import net.minecraft.src.NBTTagIntArray;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.NBTTagLong;
import net.minecraft.src.NBTTagShort;
import net.minecraft.src.NBTTagString;

public class NBTTagCompound extends NBTBase {

   private Map field_1094_a = new HashMap();


   public NBTTagCompound() {
      super("");
   }

   public NBTTagCompound(String p_i51_1_) {
      super(p_i51_1_);
   }

   void func_735_a(DataOutput p_735_1_) throws IOException {
      Iterator var2 = this.field_1094_a.values().iterator();

      while(var2.hasNext()) {
         NBTBase var3 = (NBTBase)var2.next();
         NBTBase.func_738_a(var3, p_735_1_);
      }

      p_735_1_.writeByte(0);
   }

   void func_736_a(DataInput p_736_1_) throws IOException {
      this.field_1094_a.clear();

      NBTBase var2;
      while((var2 = NBTBase.func_734_b(p_736_1_)).func_733_a() != 0) {
         this.field_1094_a.put(var2.func_737_b(), var2);
      }

   }

   public Collection func_28110_c() {
      return this.field_1094_a.values();
   }

   public byte func_733_a() {
      return (byte)10;
   }

   public void func_762_a(String p_762_1_, NBTBase p_762_2_) {
      this.field_1094_a.put(p_762_1_, p_762_2_.func_732_a(p_762_1_));
   }

   public void func_761_a(String p_761_1_, byte p_761_2_) {
      this.field_1094_a.put(p_761_1_, new NBTTagByte(p_761_1_, p_761_2_));
   }

   public void func_749_a(String p_749_1_, short p_749_2_) {
      this.field_1094_a.put(p_749_1_, new NBTTagShort(p_749_1_, p_749_2_));
   }

   public void func_758_a(String p_758_1_, int p_758_2_) {
      this.field_1094_a.put(p_758_1_, new NBTTagInt(p_758_1_, p_758_2_));
   }

   public void func_750_a(String p_750_1_, long p_750_2_) {
      this.field_1094_a.put(p_750_1_, new NBTTagLong(p_750_1_, p_750_2_));
   }

   public void func_744_a(String p_744_1_, float p_744_2_) {
      this.field_1094_a.put(p_744_1_, new NBTTagFloat(p_744_1_, p_744_2_));
   }

   public void func_765_a(String p_765_1_, double p_765_2_) {
      this.field_1094_a.put(p_765_1_, new NBTTagDouble(p_765_1_, p_765_2_));
   }

   public void func_754_a(String p_754_1_, String p_754_2_) {
      this.field_1094_a.put(p_754_1_, new NBTTagString(p_754_1_, p_754_2_));
   }

   public void func_747_a(String p_747_1_, byte[] p_747_2_) {
      this.field_1094_a.put(p_747_1_, new NBTTagByteArray(p_747_1_, p_747_2_));
   }

   public void func_48183_a(String p_48183_1_, int[] p_48183_2_) {
      this.field_1094_a.put(p_48183_1_, new NBTTagIntArray(p_48183_1_, p_48183_2_));
   }

   public void func_763_a(String p_763_1_, NBTTagCompound p_763_2_) {
      this.field_1094_a.put(p_763_1_, p_763_2_.func_732_a(p_763_1_));
   }

   public void func_748_a(String p_748_1_, boolean p_748_2_) {
      this.func_761_a(p_748_1_, (byte)(p_748_2_?1:0));
   }

   public NBTBase func_40196_b(String p_40196_1_) {
      return (NBTBase)this.field_1094_a.get(p_40196_1_);
   }

   public boolean func_751_b(String p_751_1_) {
      return this.field_1094_a.containsKey(p_751_1_);
   }

   public byte func_746_c(String p_746_1_) {
      return !this.field_1094_a.containsKey(p_746_1_)?0:((NBTTagByte)this.field_1094_a.get(p_746_1_)).field_1092_a;
   }

   public short func_745_d(String p_745_1_) {
      return !this.field_1094_a.containsKey(p_745_1_)?0:((NBTTagShort)this.field_1094_a.get(p_745_1_)).field_1088_a;
   }

   public int func_756_e(String p_756_1_) {
      return !this.field_1094_a.containsKey(p_756_1_)?0:((NBTTagInt)this.field_1094_a.get(p_756_1_)).field_1093_a;
   }

   public long func_764_f(String p_764_1_) {
      return !this.field_1094_a.containsKey(p_764_1_)?0L:((NBTTagLong)this.field_1094_a.get(p_764_1_)).field_1095_a;
   }

   public float func_752_g(String p_752_1_) {
      return !this.field_1094_a.containsKey(p_752_1_)?0.0F:((NBTTagFloat)this.field_1094_a.get(p_752_1_)).field_1097_a;
   }

   public double func_757_h(String p_757_1_) {
      return !this.field_1094_a.containsKey(p_757_1_)?0.0D:((NBTTagDouble)this.field_1094_a.get(p_757_1_)).field_1089_a;
   }

   public String func_755_i(String p_755_1_) {
      return !this.field_1094_a.containsKey(p_755_1_)?"":((NBTTagString)this.field_1094_a.get(p_755_1_)).field_1098_a;
   }

   public byte[] func_759_j(String p_759_1_) {
      return !this.field_1094_a.containsKey(p_759_1_)?new byte[0]:((NBTTagByteArray)this.field_1094_a.get(p_759_1_)).field_1096_a;
   }

   public int[] func_48182_l(String p_48182_1_) {
      return !this.field_1094_a.containsKey(p_48182_1_)?new int[0]:((NBTTagIntArray)this.field_1094_a.get(p_48182_1_)).field_48181_a;
   }

   public NBTTagCompound func_743_k(String p_743_1_) {
      return !this.field_1094_a.containsKey(p_743_1_)?new NBTTagCompound(p_743_1_):(NBTTagCompound)this.field_1094_a.get(p_743_1_);
   }

   public NBTTagList func_753_l(String p_753_1_) {
      return !this.field_1094_a.containsKey(p_753_1_)?new NBTTagList(p_753_1_):(NBTTagList)this.field_1094_a.get(p_753_1_);
   }

   public boolean func_760_m(String p_760_1_) {
      return this.func_746_c(p_760_1_) != 0;
   }

   public String toString() {
      return "" + this.field_1094_a.size() + " entries";
   }

   public NBTBase func_40195_b() {
      NBTTagCompound var1 = new NBTTagCompound(this.func_737_b());
      Iterator var2 = this.field_1094_a.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.func_762_a(var3, ((NBTBase)this.field_1094_a.get(var3)).func_40195_b());
      }

      return var1;
   }

   public boolean equals(Object p_equals_1_) {
      if(super.equals(p_equals_1_)) {
         NBTTagCompound var2 = (NBTTagCompound)p_equals_1_;
         return this.field_1094_a.entrySet().equals(var2.field_1094_a.entrySet());
      } else {
         return false;
      }
   }

   public int hashCode() {
      return super.hashCode() ^ this.field_1094_a.hashCode();
   }
}
