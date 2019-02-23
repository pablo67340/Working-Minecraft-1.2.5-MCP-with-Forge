package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityBrewingStand;
import net.minecraft.src.World;

public class BlockBrewingStand extends BlockContainer {

   private Random field_40214_a = new Random();


   public BlockBrewingStand(int p_i673_1_) {
      super(p_i673_1_, Material.field_1333_e);
      this.field_378_bb = 157;
   }

   public boolean func_217_b() {
      return false;
   }

   public int func_210_f() {
      return 25;
   }

   public TileEntity func_283_a_() {
      return new TileEntityBrewingStand();
   }

   public boolean func_242_c() {
      return false;
   }

   public void func_230_a(World p_230_1_, int p_230_2_, int p_230_3_, int p_230_4_, AxisAlignedBB p_230_5_, ArrayList p_230_6_) {
      this.func_213_a(0.4375F, 0.0F, 0.4375F, 0.5625F, 0.875F, 0.5625F);
      super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
      this.func_237_e();
      super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
   }

   public void func_237_e() {
      this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
   }

   public boolean func_250_a(World p_250_1_, int p_250_2_, int p_250_3_, int p_250_4_, EntityPlayer p_250_5_) {
      if(p_250_1_.field_1026_y) {
         return true;
      } else {
         TileEntityBrewingStand var6 = (TileEntityBrewingStand)p_250_1_.func_603_b(p_250_2_, p_250_3_, p_250_4_);
         if(var6 != null) {
            p_250_5_.func_40180_a(var6);
         }

         return true;
      }
   }

   public void func_247_b(World p_247_1_, int p_247_2_, int p_247_3_, int p_247_4_, Random p_247_5_) {
      double var6 = (double)((float)p_247_2_ + 0.4F + p_247_5_.nextFloat() * 0.2F);
      double var8 = (double)((float)p_247_3_ + 0.7F + p_247_5_.nextFloat() * 0.3F);
      double var10 = (double)((float)p_247_4_ + 0.4F + p_247_5_.nextFloat() * 0.2F);
      p_247_1_.func_694_a("smoke", var6, var8, var10, 0.0D, 0.0D, 0.0D);
   }

   public void func_214_b(World p_214_1_, int p_214_2_, int p_214_3_, int p_214_4_) {
      TileEntity var5 = p_214_1_.func_603_b(p_214_2_, p_214_3_, p_214_4_);
      if(var5 != null && var5 instanceof TileEntityBrewingStand) {
         TileEntityBrewingStand var6 = (TileEntityBrewingStand)var5;

         for(int var7 = 0; var7 < var6.func_469_c(); ++var7) {
            ItemStack var8 = var6.func_468_c(var7);
            if(var8 != null) {
               float var9 = this.field_40214_a.nextFloat() * 0.8F + 0.1F;
               float var10 = this.field_40214_a.nextFloat() * 0.8F + 0.1F;
               float var11 = this.field_40214_a.nextFloat() * 0.8F + 0.1F;

               while(var8.field_1615_a > 0) {
                  int var12 = this.field_40214_a.nextInt(21) + 10;
                  if(var12 > var8.field_1615_a) {
                     var12 = var8.field_1615_a;
                  }

                  var8.field_1615_a -= var12;
                  EntityItem var13 = new EntityItem(p_214_1_, (double)((float)p_214_2_ + var9), (double)((float)p_214_3_ + var10), (double)((float)p_214_4_ + var11), new ItemStack(var8.field_1617_c, var12, var8.func_21181_i()));
                  float var14 = 0.05F;
                  var13.field_608_an = (double)((float)this.field_40214_a.nextGaussian() * var14);
                  var13.field_607_ao = (double)((float)this.field_40214_a.nextGaussian() * var14 + 0.2F);
                  var13.field_606_ap = (double)((float)this.field_40214_a.nextGaussian() * var14);
                  p_214_1_.func_674_a(var13);
               }
            }
         }
      }

      super.func_214_b(p_214_1_, p_214_2_, p_214_3_, p_214_4_);
   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return Item.field_40411_by.field_291_aS;
   }
}
