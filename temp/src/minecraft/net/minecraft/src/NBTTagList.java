package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.src.NBTBase;

public class NBTTagList extends NBTBase {

   private List field_1091_a = new ArrayList();
   private byte field_1090_b;


   public NBTTagList() {
      super("");
   }

   public NBTTagList(String p_i481_1_) {
      super(p_i481_1_);
   }

   void func_735_a(DataOutput p_735_1_) throws IOException {
      if(this.field_1091_a.size() > 0) {
         this.field_1090_b = ((NBTBase)this.field_1091_a.get(0)).func_733_a();
      } else {
         this.field_1090_b = 1;
      }

      p_735_1_.writeByte(this.field_1090_b);
      p_735_1_.writeInt(this.field_1091_a.size());

      for(int var2 = 0; var2 < this.field_1091_a.size(); ++var2) {
         ((NBTBase)this.field_1091_a.get(var2)).func_735_a(p_735_1_);
      }

   }

   void func_736_a(DataInput p_736_1_) throws IOException {
      this.field_1090_b = p_736_1_.readByte();
      int var2 = p_736_1_.readInt();
      this.field_1091_a = new ArrayList();

      for(int var3 = 0; var3 < var2; ++var3) {
         NBTBase var4 = NBTBase.func_739_a(this.field_1090_b, (String)null);
         var4.func_736_a(p_736_1_);
         this.field_1091_a.add(var4);
      }

   }

   public byte func_733_a() {
      return (byte)9;
   }

   public String toString() {
      return "" + this.field_1091_a.size() + " entries of type " + NBTBase.func_731_b(this.field_1090_b);
   }

   public void func_742_a(NBTBase p_742_1_) {
      this.field_1090_b = p_742_1_.func_733_a();
      this.field_1091_a.add(p_742_1_);
   }

   public NBTBase func_741_a(int p_741_1_) {
      return (NBTBase)this.field_1091_a.get(p_741_1_);
   }

   public int func_740_c() {
      return this.field_1091_a.size();
   }

   public NBTBase func_40195_b() {
      NBTTagList var1 = new NBTTagList(this.func_737_b());
      var1.field_1090_b = this.field_1090_b;
      Iterator var2 = this.field_1091_a.iterator();

      while(var2.hasNext()) {
         NBTBase var3 = (NBTBase)var2.next();
         NBTBase var4 = var3.func_40195_b();
         var1.field_1091_a.add(var4);
      }

      return var1;
   }

   public boolean equals(Object p_equals_1_) {
      if(super.equals(p_equals_1_)) {
         NBTTagList var2 = (NBTTagList)p_equals_1_;
         if(this.field_1090_b == var2.field_1090_b) {
            return this.field_1091_a.equals(var2.field_1091_a);
         }
      }

      return false;
   }

   public int hashCode() {
      return super.hashCode() ^ this.field_1091_a.hashCode();
   }
}
