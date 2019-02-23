package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.EntityAIEatGrass;
import net.minecraft.src.EntityAIFollowParent;
import net.minecraft.src.EntityAILookIdle;
import net.minecraft.src.EntityAIMate;
import net.minecraft.src.EntityAIPanic;
import net.minecraft.src.EntityAISwimming;
import net.minecraft.src.EntityAITempt;
import net.minecraft.src.EntityAIWander;
import net.minecraft.src.EntityAIWatchClosest;
import net.minecraft.src.EntityAnimal;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntitySheep extends EntityAnimal {

   public static final float[][] field_21075_a = new float[][]{{1.0F, 1.0F, 1.0F}, {0.95F, 0.7F, 0.2F}, {0.9F, 0.5F, 0.85F}, {0.6F, 0.7F, 0.95F}, {0.9F, 0.9F, 0.2F}, {0.5F, 0.8F, 0.1F}, {0.95F, 0.7F, 0.8F}, {0.3F, 0.3F, 0.3F}, {0.6F, 0.6F, 0.6F}, {0.3F, 0.6F, 0.7F}, {0.7F, 0.4F, 0.9F}, {0.2F, 0.4F, 0.8F}, {0.5F, 0.4F, 0.3F}, {0.4F, 0.5F, 0.2F}, {0.8F, 0.3F, 0.3F}, {0.1F, 0.1F, 0.1F}};
   private int field_44004_b;
   private EntityAIEatGrass field_48137_c = new EntityAIEatGrass(this);


   public EntitySheep(World p_i272_1_) {
      super(p_i272_1_);
      this.field_9357_z = "/mob/sheep.png";
      this.func_371_a(0.9F, 1.3F);
      float var2 = 0.23F;
      this.func_48084_aL().func_48664_a(true);
      this.field_46019_bU.func_46118_a(0, new EntityAISwimming(this));
      this.field_46019_bU.func_46118_a(1, new EntityAIPanic(this, 0.38F));
      this.field_46019_bU.func_46118_a(2, new EntityAIMate(this, var2));
      this.field_46019_bU.func_46118_a(3, new EntityAITempt(this, 0.25F, Item.field_243_R.field_291_aS, false));
      this.field_46019_bU.func_46118_a(4, new EntityAIFollowParent(this, 0.25F));
      this.field_46019_bU.func_46118_a(5, this.field_48137_c);
      this.field_46019_bU.func_46118_a(6, new EntityAIWander(this, var2));
      this.field_46019_bU.func_46118_a(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
      this.field_46019_bU.func_46118_a(8, new EntityAILookIdle(this));
   }

   protected boolean func_46006_aR() {
      return true;
   }

   protected void func_46014_aS() {
      this.field_44004_b = this.field_48137_c.func_48396_h();
      super.func_46014_aS();
   }

   public void func_425_j() {
      if(this.field_615_ag.field_1026_y) {
         this.field_44004_b = Math.max(0, this.field_44004_b - 1);
      }

      super.func_425_j();
   }

   public int func_40117_c() {
      return 8;
   }

   protected void func_21057_b() {
      super.func_21057_b();
      this.field_21064_bx.func_21124_a(16, new Byte((byte)0));
   }

   protected void func_21066_o(boolean p_21066_1_, int p_21066_2_) {
      if(!this.func_21072_p()) {
         this.func_21058_a(new ItemStack(Block.field_419_ac.field_376_bc, 1, this.func_21074_p_()), 0.0F);
      }

   }

   protected int func_422_g() {
      return Block.field_419_ac.field_376_bc;
   }

   public void func_9282_a(byte p_9282_1_) {
      if(p_9282_1_ == 10) {
         this.field_44004_b = 40;
      } else {
         super.func_9282_a(p_9282_1_);
      }

   }

   public float func_44003_c(float p_44003_1_) {
      return this.field_44004_b <= 0?0.0F:(this.field_44004_b >= 4 && this.field_44004_b <= 36?1.0F:(this.field_44004_b < 4?((float)this.field_44004_b - p_44003_1_) / 4.0F:-((float)(this.field_44004_b - 40) - p_44003_1_) / 4.0F));
   }

   public float func_44002_d(float p_44002_1_) {
      if(this.field_44004_b > 4 && this.field_44004_b <= 36) {
         float var2 = ((float)(this.field_44004_b - 4) - p_44002_1_) / 32.0F;
         return 0.62831855F + 0.21991149F * MathHelper.func_1106_a(var2 * 28.7F);
      } else {
         return this.field_44004_b > 0?0.62831855F:this.field_604_ar / 57.295776F;
      }
   }

   public boolean func_353_a(EntityPlayer p_353_1_) {
      ItemStack var2 = p_353_1_.field_778_b.func_494_a();
      if(var2 != null && var2.field_1617_c == Item.field_31001_bc.field_291_aS && !this.func_21072_p() && !this.func_40127_l()) {
         if(!this.field_615_ag.field_1026_y) {
            this.func_21073_a(true);
            int var3 = 1 + this.field_9312_bd.nextInt(3);

            for(int var4 = 0; var4 < var3; ++var4) {
               EntityItem var5 = this.func_21058_a(new ItemStack(Block.field_419_ac.field_376_bc, 1, this.func_21074_p_()), 1.0F);
               var5.field_607_ao += (double)(this.field_9312_bd.nextFloat() * 0.05F);
               var5.field_608_an += (double)((this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.1F);
               var5.field_606_ap += (double)((this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.1F);
            }
         }

         var2.func_25190_a(1, p_353_1_);
      }

      return super.func_353_a(p_353_1_);
   }

   public void func_352_a(NBTTagCompound p_352_1_) {
      super.func_352_a(p_352_1_);
      p_352_1_.func_748_a("Sheared", this.func_21072_p());
      p_352_1_.func_761_a("Color", (byte)this.func_21074_p_());
   }

   public void func_357_b(NBTTagCompound p_357_1_) {
      super.func_357_b(p_357_1_);
      this.func_21073_a(p_357_1_.func_760_m("Sheared"));
      this.func_21071_b_(p_357_1_.func_746_c("Color"));
   }

   protected String func_6389_d() {
      return "mob.sheep";
   }

   protected String func_6394_f_() {
      return "mob.sheep";
   }

   protected String func_6390_f() {
      return "mob.sheep";
   }

   public int func_21074_p_() {
      return this.field_21064_bx.func_21130_a(16) & 15;
   }

   public void func_21071_b_(int p_21071_1_) {
      byte var2 = this.field_21064_bx.func_21130_a(16);
      this.field_21064_bx.func_21129_b(16, Byte.valueOf((byte)(var2 & 240 | p_21071_1_ & 15)));
   }

   public boolean func_21072_p() {
      return (this.field_21064_bx.func_21130_a(16) & 16) != 0;
   }

   public void func_21073_a(boolean p_21073_1_) {
      byte var2 = this.field_21064_bx.func_21130_a(16);
      if(p_21073_1_) {
         this.field_21064_bx.func_21129_b(16, Byte.valueOf((byte)(var2 | 16)));
      } else {
         this.field_21064_bx.func_21129_b(16, Byte.valueOf((byte)(var2 & -17)));
      }

   }

   public static int func_21070_a(Random p_21070_0_) {
      int var1 = p_21070_0_.nextInt(100);
      return var1 < 5?15:(var1 < 10?7:(var1 < 15?8:(var1 < 18?12:(p_21070_0_.nextInt(500) == 0?6:0))));
   }

   public EntityAnimal func_40145_a(EntityAnimal p_40145_1_) {
      EntitySheep var2 = (EntitySheep)p_40145_1_;
      EntitySheep var3 = new EntitySheep(this.field_615_ag);
      if(this.field_9312_bd.nextBoolean()) {
         var3.func_21071_b_(this.func_21074_p_());
      } else {
         var3.func_21071_b_(var2.func_21074_p_());
      }

      return var3;
   }

   public void func_48095_u() {
      this.func_21073_a(false);
      if(this.func_40127_l()) {
         int var1 = this.func_48123_at() + 1200;
         if(var1 > 0) {
            var1 = 0;
         }

         this.func_48122_d(var1);
      }

   }

}
