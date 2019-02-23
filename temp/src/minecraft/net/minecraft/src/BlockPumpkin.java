package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.BlockDirectional;
import net.minecraft.src.EntityIronGolem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntitySnowman;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class BlockPumpkin extends BlockDirectional {

   private boolean field_4072_a;


   protected BlockPumpkin(int p_i671_1_, int p_i671_2_, boolean p_i671_3_) {
      super(p_i671_1_, Material.field_4261_w);
      this.field_378_bb = p_i671_2_;
      this.func_253_b(true);
      this.field_4072_a = p_i671_3_;
   }

   public int func_232_a(int p_232_1_, int p_232_2_) {
      if(p_232_1_ == 1) {
         return this.field_378_bb;
      } else if(p_232_1_ == 0) {
         return this.field_378_bb;
      } else {
         int var3 = this.field_378_bb + 1 + 16;
         if(this.field_4072_a) {
            ++var3;
         }

         return p_232_2_ == 2 && p_232_1_ == 2?var3:(p_232_2_ == 3 && p_232_1_ == 5?var3:(p_232_2_ == 0 && p_232_1_ == 3?var3:(p_232_2_ == 1 && p_232_1_ == 4?var3:this.field_378_bb + 16)));
      }
   }

   public int func_218_a(int p_218_1_) {
      return p_218_1_ == 1?this.field_378_bb:(p_218_1_ == 0?this.field_378_bb:(p_218_1_ == 3?this.field_378_bb + 1 + 16:this.field_378_bb + 16));
   }

   public void func_235_e(World p_235_1_, int p_235_2_, int p_235_3_, int p_235_4_) {
      super.func_235_e(p_235_1_, p_235_2_, p_235_3_, p_235_4_);
      if(p_235_1_.func_600_a(p_235_2_, p_235_3_ - 1, p_235_4_) == Block.field_426_aV.field_376_bc && p_235_1_.func_600_a(p_235_2_, p_235_3_ - 2, p_235_4_) == Block.field_426_aV.field_376_bc) {
         if(!p_235_1_.field_1026_y) {
            p_235_1_.func_634_a(p_235_2_, p_235_3_, p_235_4_, 0);
            p_235_1_.func_634_a(p_235_2_, p_235_3_ - 1, p_235_4_, 0);
            p_235_1_.func_634_a(p_235_2_, p_235_3_ - 2, p_235_4_, 0);
            EntitySnowman var9 = new EntitySnowman(p_235_1_);
            var9.func_365_c((double)p_235_2_ + 0.5D, (double)p_235_3_ - 1.95D, (double)p_235_4_ + 0.5D, 0.0F, 0.0F);
            p_235_1_.func_674_a(var9);
            p_235_1_.func_617_e(p_235_2_, p_235_3_, p_235_4_, 0);
            p_235_1_.func_617_e(p_235_2_, p_235_3_ - 1, p_235_4_, 0);
            p_235_1_.func_617_e(p_235_2_, p_235_3_ - 2, p_235_4_, 0);
         }

         for(int var10 = 0; var10 < 120; ++var10) {
            p_235_1_.func_694_a("snowshovel", (double)p_235_2_ + p_235_1_.field_1037_n.nextDouble(), (double)(p_235_3_ - 2) + p_235_1_.field_1037_n.nextDouble() * 2.5D, (double)p_235_4_ + p_235_1_.field_1037_n.nextDouble(), 0.0D, 0.0D, 0.0D);
         }
      } else if(p_235_1_.func_600_a(p_235_2_, p_235_3_ - 1, p_235_4_) == Block.field_412_aj.field_376_bc && p_235_1_.func_600_a(p_235_2_, p_235_3_ - 2, p_235_4_) == Block.field_412_aj.field_376_bc) {
         boolean var5 = p_235_1_.func_600_a(p_235_2_ - 1, p_235_3_ - 1, p_235_4_) == Block.field_412_aj.field_376_bc && p_235_1_.func_600_a(p_235_2_ + 1, p_235_3_ - 1, p_235_4_) == Block.field_412_aj.field_376_bc;
         boolean var6 = p_235_1_.func_600_a(p_235_2_, p_235_3_ - 1, p_235_4_ - 1) == Block.field_412_aj.field_376_bc && p_235_1_.func_600_a(p_235_2_, p_235_3_ - 1, p_235_4_ + 1) == Block.field_412_aj.field_376_bc;
         if(var5 || var6) {
            p_235_1_.func_634_a(p_235_2_, p_235_3_, p_235_4_, 0);
            p_235_1_.func_634_a(p_235_2_, p_235_3_ - 1, p_235_4_, 0);
            p_235_1_.func_634_a(p_235_2_, p_235_3_ - 2, p_235_4_, 0);
            if(var5) {
               p_235_1_.func_634_a(p_235_2_ - 1, p_235_3_ - 1, p_235_4_, 0);
               p_235_1_.func_634_a(p_235_2_ + 1, p_235_3_ - 1, p_235_4_, 0);
            } else {
               p_235_1_.func_634_a(p_235_2_, p_235_3_ - 1, p_235_4_ - 1, 0);
               p_235_1_.func_634_a(p_235_2_, p_235_3_ - 1, p_235_4_ + 1, 0);
            }

            EntityIronGolem var7 = new EntityIronGolem(p_235_1_);
            var7.func_48115_b(true);
            var7.func_365_c((double)p_235_2_ + 0.5D, (double)p_235_3_ - 1.95D, (double)p_235_4_ + 0.5D, 0.0F, 0.0F);
            p_235_1_.func_674_a(var7);

            for(int var8 = 0; var8 < 120; ++var8) {
               p_235_1_.func_694_a("snowballpoof", (double)p_235_2_ + p_235_1_.field_1037_n.nextDouble(), (double)(p_235_3_ - 2) + p_235_1_.field_1037_n.nextDouble() * 3.9D, (double)p_235_4_ + p_235_1_.field_1037_n.nextDouble(), 0.0D, 0.0D, 0.0D);
            }

            p_235_1_.func_617_e(p_235_2_, p_235_3_, p_235_4_, 0);
            p_235_1_.func_617_e(p_235_2_, p_235_3_ - 1, p_235_4_, 0);
            p_235_1_.func_617_e(p_235_2_, p_235_3_ - 2, p_235_4_, 0);
            if(var5) {
               p_235_1_.func_617_e(p_235_2_ - 1, p_235_3_ - 1, p_235_4_, 0);
               p_235_1_.func_617_e(p_235_2_ + 1, p_235_3_ - 1, p_235_4_, 0);
            } else {
               p_235_1_.func_617_e(p_235_2_, p_235_3_ - 1, p_235_4_ - 1, 0);
               p_235_1_.func_617_e(p_235_2_, p_235_3_ - 1, p_235_4_ + 1, 0);
            }
         }
      }

   }

   public boolean func_243_a(World p_243_1_, int p_243_2_, int p_243_3_, int p_243_4_) {
      int var5 = p_243_1_.func_600_a(p_243_2_, p_243_3_, p_243_4_);
      return (var5 == 0 || Block.field_345_n[var5].field_356_bn.func_27283_g()) && p_243_1_.func_28100_h(p_243_2_, p_243_3_ - 1, p_243_4_);
   }

   public void func_4026_a(World p_4026_1_, int p_4026_2_, int p_4026_3_, int p_4026_4_, EntityLiving p_4026_5_) {
      int var6 = MathHelper.func_1108_b((double)(p_4026_5_.field_605_aq * 4.0F / 360.0F) + 2.5D) & 3;
      p_4026_1_.func_691_b(p_4026_2_, p_4026_3_, p_4026_4_, var6);
   }
}
