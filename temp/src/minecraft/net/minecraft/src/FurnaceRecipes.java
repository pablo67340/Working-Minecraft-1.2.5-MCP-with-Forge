package net.minecraft.src;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class FurnaceRecipes {

   private static final FurnaceRecipes field_21202_a = new FurnaceRecipes();
   private Map field_21201_b = new HashMap();


   public static final FurnaceRecipes func_21200_a() {
      return field_21202_a;
   }

   private FurnaceRecipes() {
      this.func_21199_a(Block.field_388_I.field_376_bc, new ItemStack(Item.field_223_m));
      this.func_21199_a(Block.field_390_H.field_376_bc, new ItemStack(Item.field_222_n));
      this.func_21199_a(Block.field_391_ax.field_376_bc, new ItemStack(Item.field_224_l));
      this.func_21199_a(Block.field_393_F.field_376_bc, new ItemStack(Block.field_382_N));
      this.func_21199_a(Item.field_272_ao.field_291_aS, new ItemStack(Item.field_4017_ap));
      this.func_21199_a(Item.field_35417_bj.field_291_aS, new ItemStack(Item.field_35418_bk));
      this.func_21199_a(Item.field_35419_bl.field_291_aS, new ItemStack(Item.field_35420_bm));
      this.func_21199_a(Item.field_4021_aS.field_291_aS, new ItemStack(Item.field_4020_aT));
      this.func_21199_a(Block.field_335_x.field_376_bc, new ItemStack(Block.field_338_u));
      this.func_21199_a(Item.field_303_aG.field_291_aS, new ItemStack(Item.field_4030_aF));
      this.func_21199_a(Block.field_425_aW.field_376_bc, new ItemStack(Item.field_21021_aU, 1, 2));
      this.func_21199_a(Block.field_385_K.field_376_bc, new ItemStack(Item.field_225_k, 1, 1));
      this.func_21199_a(Block.field_386_J.field_376_bc, new ItemStack(Item.field_225_k));
      this.func_21199_a(Block.field_433_aO.field_376_bc, new ItemStack(Item.field_309_aA));
      this.func_21199_a(Block.field_9267_N.field_376_bc, new ItemStack(Item.field_21021_aU, 1, 4));
   }

   public void func_21199_a(int p_21199_1_, ItemStack p_21199_2_) {
      this.field_21201_b.put(Integer.valueOf(p_21199_1_), p_21199_2_);
   }

   public ItemStack func_21198_a(int p_21198_1_) {
      return (ItemStack)this.field_21201_b.get(Integer.valueOf(p_21198_1_));
   }

   public Map func_25194_b() {
      return this.field_21201_b;
   }

}
