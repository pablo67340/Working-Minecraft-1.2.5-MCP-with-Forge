package net.minecraft.src;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.src.Block;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntityBrewingStand;
import net.minecraft.src.TileEntityChest;
import net.minecraft.src.TileEntityDispenser;
import net.minecraft.src.TileEntityEnchantmentTable;
import net.minecraft.src.TileEntityEndPortal;
import net.minecraft.src.TileEntityFurnace;
import net.minecraft.src.TileEntityMobSpawner;
import net.minecraft.src.TileEntityNote;
import net.minecraft.src.TileEntityPiston;
import net.minecraft.src.TileEntityRecordPlayer;
import net.minecraft.src.TileEntitySign;
import net.minecraft.src.World;

public class TileEntity {

   private static Map field_820_a = new HashMap();
   private static Map field_819_b = new HashMap();
   public World field_824_e;
   public int field_823_f;
   public int field_822_g;
   public int field_821_h;
   protected boolean field_31007_h;
   public int field_35145_n = -1;
   public Block field_35146_o;


   private static void func_476_a(Class p_476_0_, String p_476_1_) {
      if(field_819_b.containsKey(p_476_1_)) {
         throw new IllegalArgumentException("Duplicate id: " + p_476_1_);
      } else {
         field_820_a.put(p_476_1_, p_476_0_);
         field_819_b.put(p_476_0_, p_476_1_);
      }
   }

   public void func_482_a(NBTTagCompound p_482_1_) {
      this.field_823_f = p_482_1_.func_756_e("x");
      this.field_822_g = p_482_1_.func_756_e("y");
      this.field_821_h = p_482_1_.func_756_e("z");
   }

   public void func_481_b(NBTTagCompound p_481_1_) {
      String var2 = (String)field_819_b.get(this.getClass());
      if(var2 == null) {
         throw new RuntimeException(this.getClass() + " is missing a mapping! This is a bug!");
      } else {
         p_481_1_.func_754_a("id", var2);
         p_481_1_.func_758_a("x", this.field_823_f);
         p_481_1_.func_758_a("y", this.field_822_g);
         p_481_1_.func_758_a("z", this.field_821_h);
      }
   }

   public void func_475_b() {}

   public static TileEntity func_477_c(NBTTagCompound p_477_0_) {
      TileEntity var1 = null;

      try {
         Class var2 = (Class)field_820_a.get(p_477_0_.func_755_i("id"));
         if(var2 != null) {
            var1 = (TileEntity)var2.newInstance();
         }
      } catch (Exception var3) {
         var3.printStackTrace();
      }

      if(var1 != null) {
         var1.func_482_a(p_477_0_);
      } else {
         System.out.println("Skipping TileEntity with id " + p_477_0_.func_755_i("id"));
      }

      return var1;
   }

   public int func_479_f() {
      if(this.field_35145_n == -1) {
         this.field_35145_n = this.field_824_e.func_602_e(this.field_823_f, this.field_822_g, this.field_821_h);
      }

      return this.field_35145_n;
   }

   public void func_474_j_() {
      if(this.field_824_e != null) {
         this.field_35145_n = this.field_824_e.func_602_e(this.field_823_f, this.field_822_g, this.field_821_h);
         this.field_824_e.func_698_b(this.field_823_f, this.field_822_g, this.field_821_h, this);
      }

   }

   public double func_480_a(double p_480_1_, double p_480_3_, double p_480_5_) {
      double var7 = (double)this.field_823_f + 0.5D - p_480_1_;
      double var9 = (double)this.field_822_g + 0.5D - p_480_3_;
      double var11 = (double)this.field_821_h + 0.5D - p_480_5_;
      return var7 * var7 + var9 * var9 + var11 * var11;
   }

   public Block func_478_g() {
      if(this.field_35146_o == null) {
         this.field_35146_o = Block.field_345_n[this.field_824_e.func_600_a(this.field_823_f, this.field_822_g, this.field_821_h)];
      }

      return this.field_35146_o;
   }

   public boolean func_31006_g() {
      return this.field_31007_h;
   }

   public void func_31005_i() {
      this.field_31007_h = true;
   }

   public void func_31004_j() {
      this.field_31007_h = false;
   }

   public void func_35143_b(int p_35143_1_, int p_35143_2_) {}

   public void func_35144_b() {
      this.field_35146_o = null;
      this.field_35145_n = -1;
   }

   static {
      func_476_a(TileEntityFurnace.class, "Furnace");
      func_476_a(TileEntityChest.class, "Chest");
      func_476_a(TileEntityRecordPlayer.class, "RecordPlayer");
      func_476_a(TileEntityDispenser.class, "Trap");
      func_476_a(TileEntitySign.class, "Sign");
      func_476_a(TileEntityMobSpawner.class, "MobSpawner");
      func_476_a(TileEntityNote.class, "Music");
      func_476_a(TileEntityPiston.class, "Piston");
      func_476_a(TileEntityBrewingStand.class, "Cauldron");
      func_476_a(TileEntityEnchantmentTable.class, "EnchantTable");
      func_476_a(TileEntityEndPortal.class, "Airportal");
   }
}
