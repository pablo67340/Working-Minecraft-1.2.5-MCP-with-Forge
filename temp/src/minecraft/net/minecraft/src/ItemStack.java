package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.src.Block;
import net.minecraft.src.Enchantment;
import net.minecraft.src.EnchantmentHelper;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumAction;
import net.minecraft.src.EnumRarity;
import net.minecraft.src.Item;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.StatList;
import net.minecraft.src.World;

public final class ItemStack {

   public int field_1615_a;
   public int field_1614_b;
   public int field_1617_c;
   public NBTTagCompound field_40715_d;
   private int field_1616_d;


   public ItemStack(Block p_i743_1_) {
      this(p_i743_1_, 1);
   }

   public ItemStack(Block p_i744_1_, int p_i744_2_) {
      this(p_i744_1_.field_376_bc, p_i744_2_, 0);
   }

   public ItemStack(Block p_i745_1_, int p_i745_2_, int p_i745_3_) {
      this(p_i745_1_.field_376_bc, p_i745_2_, p_i745_3_);
   }

   public ItemStack(Item p_i746_1_) {
      this(p_i746_1_.field_291_aS, 1, 0);
   }

   public ItemStack(Item p_i747_1_, int p_i747_2_) {
      this(p_i747_1_.field_291_aS, p_i747_2_, 0);
   }

   public ItemStack(Item p_i748_1_, int p_i748_2_, int p_i748_3_) {
      this(p_i748_1_.field_291_aS, p_i748_2_, p_i748_3_);
   }

   public ItemStack(int p_i749_1_, int p_i749_2_, int p_i749_3_) {
      this.field_1615_a = 0;
      this.field_1617_c = p_i749_1_;
      this.field_1615_a = p_i749_2_;
      this.field_1616_d = p_i749_3_;
   }

   public static ItemStack func_35864_a(NBTTagCompound p_35864_0_) {
      ItemStack var1 = new ItemStack();
      var1.func_1096_b(p_35864_0_);
      return var1.func_1091_a() != null?var1:null;
   }

   private ItemStack() {
      this.field_1615_a = 0;
   }

   public ItemStack func_1085_a(int p_1085_1_) {
      ItemStack var2 = new ItemStack(this.field_1617_c, p_1085_1_, this.field_1616_d);
      if(this.field_40715_d != null) {
         var2.field_40715_d = (NBTTagCompound)this.field_40715_d.func_40195_b();
      }

      this.field_1615_a -= p_1085_1_;
      return var2;
   }

   public Item func_1091_a() {
      return Item.field_233_c[this.field_1617_c];
   }

   public int func_1088_b() {
      return this.func_1091_a().func_196_a(this);
   }

   public boolean func_1090_a(EntityPlayer p_1090_1_, World p_1090_2_, int p_1090_3_, int p_1090_4_, int p_1090_5_, int p_1090_6_) {
      boolean var7 = this.func_1091_a().func_192_a(this, p_1090_1_, p_1090_2_, p_1090_3_, p_1090_4_, p_1090_5_, p_1090_6_);
      if(var7) {
         p_1090_1_.func_25058_a(StatList.field_25172_A[this.field_1617_c], 1);
      }

      return var7;
   }

   public float func_1098_a(Block p_1098_1_) {
      return this.func_1091_a().func_204_a(this, p_1098_1_);
   }

   public ItemStack func_1093_a(World p_1093_1_, EntityPlayer p_1093_2_) {
      return this.func_1091_a().func_193_a(this, p_1093_1_, p_1093_2_);
   }

   public ItemStack func_35863_b(World p_35863_1_, EntityPlayer p_35863_2_) {
      return this.func_1091_a().func_35413_b(this, p_35863_1_, p_35863_2_);
   }

   public NBTTagCompound func_1086_a(NBTTagCompound p_1086_1_) {
      p_1086_1_.func_749_a("id", (short)this.field_1617_c);
      p_1086_1_.func_761_a("Count", (byte)this.field_1615_a);
      p_1086_1_.func_749_a("Damage", (short)this.field_1616_d);
      if(this.field_40715_d != null) {
         p_1086_1_.func_762_a("tag", this.field_40715_d);
      }

      return p_1086_1_;
   }

   public void func_1096_b(NBTTagCompound p_1096_1_) {
      this.field_1617_c = p_1096_1_.func_745_d("id");
      this.field_1615_a = p_1096_1_.func_746_c("Count");
      this.field_1616_d = p_1096_1_.func_745_d("Damage");
      if(p_1096_1_.func_751_b("tag")) {
         this.field_40715_d = p_1096_1_.func_743_k("tag");
      }

   }

   public int func_1089_c() {
      return this.func_1091_a().func_200_b();
   }

   public boolean func_21180_d() {
      return this.func_1089_c() > 1 && (!this.func_21182_e() || !this.func_21185_g());
   }

   public boolean func_21182_e() {
      return Item.field_233_c[this.field_1617_c].func_197_c() > 0;
   }

   public boolean func_21183_f() {
      return Item.field_233_c[this.field_1617_c].func_21010_e();
   }

   public boolean func_21185_g() {
      return this.func_21182_e() && this.field_1616_d > 0;
   }

   public int func_21179_h() {
      return this.field_1616_d;
   }

   public int func_21181_i() {
      return this.field_1616_d;
   }

   public void func_28156_b(int p_28156_1_) {
      this.field_1616_d = p_28156_1_;
   }

   public int func_1094_d() {
      return Item.field_233_c[this.field_1617_c].func_197_c();
   }

   public void func_25190_a(int p_25190_1_, EntityLiving p_25190_2_) {
      if(this.func_21182_e()) {
         if(p_25190_1_ > 0 && p_25190_2_ instanceof EntityPlayer) {
            int var3 = EnchantmentHelper.func_40640_c(((EntityPlayer)p_25190_2_).field_778_b);
            if(var3 > 0 && p_25190_2_.field_615_ag.field_1037_n.nextInt(var3 + 1) > 0) {
               return;
            }
         }

         this.field_1616_d += p_25190_1_;
         if(this.field_1616_d > this.func_1094_d()) {
            p_25190_2_.func_41005_b(this);
            if(p_25190_2_ instanceof EntityPlayer) {
               ((EntityPlayer)p_25190_2_).func_25058_a(StatList.field_25170_B[this.field_1617_c], 1);
            }

            --this.field_1615_a;
            if(this.field_1615_a < 0) {
               this.field_1615_a = 0;
            }

            this.field_1616_d = 0;
         }

      }
   }

   public void func_1092_a(EntityLiving p_1092_1_, EntityPlayer p_1092_2_) {
      boolean var3 = Item.field_233_c[this.field_1617_c].func_4021_a(this, p_1092_1_, p_1092_2_);
      if(var3) {
         p_1092_2_.func_25058_a(StatList.field_25172_A[this.field_1617_c], 1);
      }

   }

   public void func_25191_a(int p_25191_1_, int p_25191_2_, int p_25191_3_, int p_25191_4_, EntityPlayer p_25191_5_) {
      boolean var6 = Item.field_233_c[this.field_1617_c].func_25008_a(this, p_25191_1_, p_25191_2_, p_25191_3_, p_25191_4_, p_25191_5_);
      if(var6) {
         p_25191_5_.func_25058_a(StatList.field_25172_A[this.field_1617_c], 1);
      }

   }

   public int func_1095_a(Entity p_1095_1_) {
      return Item.field_233_c[this.field_1617_c].func_4020_a(p_1095_1_);
   }

   public boolean func_1099_b(Block p_1099_1_) {
      return Item.field_233_c[this.field_1617_c].func_4018_a(p_1099_1_);
   }

   public void func_1097_a(EntityPlayer p_1097_1_) {}

   public void func_1100_b(EntityLiving p_1100_1_) {
      Item.field_233_c[this.field_1617_c].func_4019_b(this, p_1100_1_);
   }

   public ItemStack func_1102_e() {
      ItemStack var1 = new ItemStack(this.field_1617_c, this.field_1615_a, this.field_1616_d);
      if(this.field_40715_d != null) {
         var1.field_40715_d = (NBTTagCompound)this.field_40715_d.func_40195_b();
         if(!var1.field_40715_d.equals(this.field_40715_d)) {
            return var1;
         }
      }

      return var1;
   }

   public static boolean func_46154_a(ItemStack p_46154_0_, ItemStack p_46154_1_) {
      return p_46154_0_ == null && p_46154_1_ == null?true:(p_46154_0_ != null && p_46154_1_ != null?(p_46154_0_.field_40715_d == null && p_46154_1_.field_40715_d != null?false:p_46154_0_.field_40715_d == null || p_46154_0_.field_40715_d.equals(p_46154_1_.field_40715_d)):false);
   }

   public static boolean func_20107_a(ItemStack p_20107_0_, ItemStack p_20107_1_) {
      return p_20107_0_ == null && p_20107_1_ == null?true:(p_20107_0_ != null && p_20107_1_ != null?p_20107_0_.func_20108_a(p_20107_1_):false);
   }

   private boolean func_20108_a(ItemStack p_20108_1_) {
      return this.field_1615_a != p_20108_1_.field_1615_a?false:(this.field_1617_c != p_20108_1_.field_1617_c?false:(this.field_1616_d != p_20108_1_.field_1616_d?false:(this.field_40715_d == null && p_20108_1_.field_40715_d != null?false:this.field_40715_d == null || this.field_40715_d.equals(p_20108_1_.field_40715_d))));
   }

   public boolean func_21184_a(ItemStack p_21184_1_) {
      return this.field_1617_c == p_21184_1_.field_1617_c && this.field_1616_d == p_21184_1_.field_1616_d;
   }

   public static ItemStack func_30010_b(ItemStack p_30010_0_) {
      return p_30010_0_ == null?null:p_30010_0_.func_1102_e();
   }

   public String toString() {
      return this.field_1615_a + "x" + Item.field_233_c[this.field_1617_c].func_20009_a() + "@" + this.field_1616_d;
   }

   public void func_28153_a(World p_28153_1_, Entity p_28153_2_, int p_28153_3_, boolean p_28153_4_) {
      if(this.field_1614_b > 0) {
         --this.field_1614_b;
      }

      Item.field_233_c[this.field_1617_c].func_28008_a(this, p_28153_1_, p_28153_2_, p_28153_3_, p_28153_4_);
   }

   public void func_48507_a(World p_48507_1_, EntityPlayer p_48507_2_, int p_48507_3_) {
      p_48507_2_.func_25058_a(StatList.field_25158_z[this.field_1617_c], p_48507_3_);
      Item.field_233_c[this.field_1617_c].func_28009_b(this, p_48507_1_, p_48507_2_);
   }

   public boolean func_28154_b(ItemStack p_28154_1_) {
      return this.field_1617_c == p_28154_1_.field_1617_c && this.field_1615_a == p_28154_1_.field_1615_a && this.field_1616_d == p_28154_1_.field_1616_d;
   }

   public int func_35866_m() {
      return this.func_1091_a().func_35411_c(this);
   }

   public EnumAction func_35865_n() {
      return this.func_1091_a().func_35412_b(this);
   }

   public void func_35862_a(World p_35862_1_, EntityPlayer p_35862_2_, int p_35862_3_) {
      this.func_1091_a().func_35414_a(this, p_35862_1_, p_35862_2_, p_35862_3_);
   }

   public boolean func_40710_n() {
      return this.field_40715_d != null;
   }

   public NBTTagCompound func_40709_o() {
      return this.field_40715_d;
   }

   public NBTTagList func_40714_p() {
      return this.field_40715_d == null?null:(NBTTagList)this.field_40715_d.func_40196_b("ench");
   }

   public void func_40706_d(NBTTagCompound p_40706_1_) {
      this.field_40715_d = p_40706_1_;
   }

   public List func_40712_q() {
      ArrayList var1 = new ArrayList();
      Item var2 = Item.field_233_c[this.field_1617_c];
      var1.add(var2.func_40397_d(this));
      var2.func_40404_a(this, var1);
      if(this.func_40710_n()) {
         NBTTagList var3 = this.func_40714_p();
         if(var3 != null) {
            for(int var4 = 0; var4 < var3.func_740_c(); ++var4) {
               short var5 = ((NBTTagCompound)var3.func_741_a(var4)).func_745_d("id");
               short var6 = ((NBTTagCompound)var3.func_741_a(var4)).func_745_d("lvl");
               if(Enchantment.field_40504_a[var5] != null) {
                  var1.add(Enchantment.field_40504_a[var5].func_40487_c(var6));
               }
            }
         }
      }

      return var1;
   }

   public boolean func_40713_r() {
      return this.func_1091_a().func_40403_e(this);
   }

   public EnumRarity func_40707_s() {
      return this.func_1091_a().func_40398_f(this);
   }

   public boolean func_40708_t() {
      return !this.func_1091_a().func_40401_i(this)?false:!this.func_40711_u();
   }

   public void func_40705_a(Enchantment p_40705_1_, int p_40705_2_) {
      if(this.field_40715_d == null) {
         this.func_40706_d(new NBTTagCompound());
      }

      if(!this.field_40715_d.func_751_b("ench")) {
         this.field_40715_d.func_762_a("ench", new NBTTagList("ench"));
      }

      NBTTagList var3 = (NBTTagList)this.field_40715_d.func_40196_b("ench");
      NBTTagCompound var4 = new NBTTagCompound();
      var4.func_749_a("id", (short)p_40705_1_.field_40516_s);
      var4.func_749_a("lvl", (short)((byte)p_40705_2_));
      var3.func_742_a(var4);
   }

   public boolean func_40711_u() {
      return this.field_40715_d != null && this.field_40715_d.func_751_b("ench");
   }
}
