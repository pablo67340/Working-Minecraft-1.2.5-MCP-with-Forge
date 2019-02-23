package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class BlockEndPortalFrame extends Block {

   public BlockEndPortalFrame(int p_i221_1_) {
      super(p_i221_1_, 159, Material.field_4263_o);
   }

   public int func_232_a(int p_232_1_, int p_232_2_) {
      return p_232_1_ == 1?this.field_378_bb - 1:(p_232_1_ == 0?this.field_378_bb + 16:this.field_378_bb);
   }

   public boolean func_217_b() {
      return false;
   }

   public int func_210_f() {
      return 26;
   }

   public void func_237_e() {
      this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
   }

   public void func_230_a(World p_230_1_, int p_230_2_, int p_230_3_, int p_230_4_, AxisAlignedBB p_230_5_, ArrayList p_230_6_) {
      this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
      super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
      int var7 = p_230_1_.func_602_e(p_230_2_, p_230_3_, p_230_4_);
      if(func_40212_d(var7)) {
         this.func_213_a(0.3125F, 0.8125F, 0.3125F, 0.6875F, 1.0F, 0.6875F);
         super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
      }

      this.func_237_e();
   }

   public static boolean func_40212_d(int p_40212_0_) {
      return (p_40212_0_ & 4) != 0;
   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return 0;
   }

   public void func_4026_a(World p_4026_1_, int p_4026_2_, int p_4026_3_, int p_4026_4_, EntityLiving p_4026_5_) {
      int var6 = ((MathHelper.func_1108_b((double)(p_4026_5_.field_605_aq * 4.0F / 360.0F) + 0.5D) & 3) + 2) % 4;
      p_4026_1_.func_691_b(p_4026_2_, p_4026_3_, p_4026_4_, var6);
   }
}
