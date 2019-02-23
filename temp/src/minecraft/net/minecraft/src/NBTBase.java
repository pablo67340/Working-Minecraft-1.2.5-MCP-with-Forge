package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.src.NBTTagByte;
import net.minecraft.src.NBTTagByteArray;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagDouble;
import net.minecraft.src.NBTTagEnd;
import net.minecraft.src.NBTTagFloat;
import net.minecraft.src.NBTTagInt;
import net.minecraft.src.NBTTagIntArray;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.NBTTagLong;
import net.minecraft.src.NBTTagShort;
import net.minecraft.src.NBTTagString;

public abstract class NBTBase {

   private String field_1087_a;


   abstract void func_735_a(DataOutput var1) throws IOException;

   abstract void func_736_a(DataInput var1) throws IOException;

   public abstract byte func_733_a();

   protected NBTBase(String p_i339_1_) {
      if(p_i339_1_ == null) {
         this.field_1087_a = "";
      } else {
         this.field_1087_a = p_i339_1_;
      }

   }

   public NBTBase func_732_a(String p_732_1_) {
      if(p_732_1_ == null) {
         this.field_1087_a = "";
      } else {
         this.field_1087_a = p_732_1_;
      }

      return this;
   }

   public String func_737_b() {
      return this.field_1087_a == null?"":this.field_1087_a;
   }

   public static NBTBase func_734_b(DataInput p_734_0_) throws IOException {
      byte var1 = p_734_0_.readByte();
      if(var1 == 0) {
         return new NBTTagEnd();
      } else {
         String var2 = p_734_0_.readUTF();
         NBTBase var3 = func_739_a(var1, var2);
         var3.func_736_a(p_734_0_);
         return var3;
      }
   }

   public static void func_738_a(NBTBase p_738_0_, DataOutput p_738_1_) throws IOException {
      p_738_1_.writeByte(p_738_0_.func_733_a());
      if(p_738_0_.func_733_a() != 0) {
         p_738_1_.writeUTF(p_738_0_.func_737_b());
         p_738_0_.func_735_a(p_738_1_);
      }
   }

   public static NBTBase func_739_a(byte p_739_0_, String p_739_1_) {
      switch(p_739_0_) {
      case 0:
         return new NBTTagEnd();
      case 1:
         return new NBTTagByte(p_739_1_);
      case 2:
         return new NBTTagShort(p_739_1_);
      case 3:
         return new NBTTagInt(p_739_1_);
      case 4:
         return new NBTTagLong(p_739_1_);
      case 5:
         return new NBTTagFloat(p_739_1_);
      case 6:
         return new NBTTagDouble(p_739_1_);
      case 7:
         return new NBTTagByteArray(p_739_1_);
      case 8:
         return new NBTTagString(p_739_1_);
      case 9:
         return new NBTTagList(p_739_1_);
      case 10:
         return new NBTTagCompound(p_739_1_);
      case 11:
         return new NBTTagIntArray(p_739_1_);
      default:
         return null;
      }
   }

   public static String func_731_b(byte p_731_0_) {
      switch(p_731_0_) {
      case 0:
         return "TAG_End";
      case 1:
         return "TAG_Byte";
      case 2:
         return "TAG_Short";
      case 3:
         return "TAG_Int";
      case 4:
         return "TAG_Long";
      case 5:
         return "TAG_Float";
      case 6:
         return "TAG_Double";
      case 7:
         return "TAG_Byte_Array";
      case 8:
         return "TAG_String";
      case 9:
         return "TAG_List";
      case 10:
         return "TAG_Compound";
      case 11:
         return "TAG_Int_Array";
      default:
         return "UNKNOWN";
      }
   }

   public abstract NBTBase func_40195_b();

   public boolean equals(Object p_equals_1_) {
      if(p_equals_1_ != null && p_equals_1_ instanceof NBTBase) {
         NBTBase var2 = (NBTBase)p_equals_1_;
         return this.func_733_a() != var2.func_733_a()?false:((this.field_1087_a != null || var2.field_1087_a == null) && (this.field_1087_a == null || var2.field_1087_a != null)?this.field_1087_a == null || this.field_1087_a.equals(var2.field_1087_a):false);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.field_1087_a.hashCode() ^ this.func_733_a();
   }
}
