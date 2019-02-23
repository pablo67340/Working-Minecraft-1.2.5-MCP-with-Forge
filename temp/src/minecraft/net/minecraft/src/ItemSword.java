package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumAction;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemSword extends Item {

   private int field_319_a;
   private final EnumToolMaterial field_40439_b;


   public ItemSword(int p_i441_1_, EnumToolMaterial p_i441_2_) {
      super(p_i441_1_);
      this.field_40439_b = p_i441_2_;
      this.field_290_aT = 1;
      this.func_21013_d(p_i441_2_.func_21207_a());
      this.field_319_a = 4 + p_i441_2_.func_21205_c();
   }

   public float func_204_a(ItemStack p_204_1_, Block p_204_2_) {
      return p_204_2_.field_376_bc == Block.field_9258_W.field_376_bc?15.0F:1.5F;
   }

   public boolean func_4021_a(ItemStack p_4021_1_, EntityLiving p_4021_2_, EntityLiving p_4021_3_) {
      p_4021_1_.func_25190_a(1, p_4021_3_);
      return true;
   }

   public boolean func_25008_a(ItemStack p_25008_1_, int p_25008_2_, int p_25008_3_, int p_25008_4_, int p_25008_5_, EntityLiving p_25008_6_) {
      p_25008_1_.func_25190_a(2, p_25008_6_);
      return true;
   }

   public int func_4020_a(Entity p_4020_1_) {
      return this.field_319_a;
   }

   public boolean func_4017_a() {
      return true;
   }

   public EnumAction func_35412_b(ItemStack p_35412_1_) {
      return EnumAction.block;
   }

   public int func_35411_c(ItemStack p_35411_1_) {
      return 72000;
   }

   public ItemStack func_193_a(ItemStack p_193_1_, World p_193_2_, EntityPlayer p_193_3_) {
      p_193_3_.func_35199_b(p_193_1_, this.func_35411_c(p_193_1_));
      return p_193_1_;
   }

   public boolean func_4018_a(Block p_4018_1_) {
      return p_4018_1_.field_376_bc == Block.field_9258_W.field_376_bc;
   }

   public int func_40399_b() {
      return this.field_40439_b.func_40731_e();
   }
}
