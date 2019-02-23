package net.minecraft.src;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.src.BiomeDecorator;
import net.minecraft.src.BiomeGenBeach;
import net.minecraft.src.BiomeGenDesert;
import net.minecraft.src.BiomeGenEnd;
import net.minecraft.src.BiomeGenForest;
import net.minecraft.src.BiomeGenHell;
import net.minecraft.src.BiomeGenHills;
import net.minecraft.src.BiomeGenJungle;
import net.minecraft.src.BiomeGenMushroomIsland;
import net.minecraft.src.BiomeGenOcean;
import net.minecraft.src.BiomeGenPlains;
import net.minecraft.src.BiomeGenRiver;
import net.minecraft.src.BiomeGenSnow;
import net.minecraft.src.BiomeGenSwamp;
import net.minecraft.src.BiomeGenTaiga;
import net.minecraft.src.Block;
import net.minecraft.src.ColorizerFoliage;
import net.minecraft.src.ColorizerGrass;
import net.minecraft.src.EntityChicken;
import net.minecraft.src.EntityCow;
import net.minecraft.src.EntityCreeper;
import net.minecraft.src.EntityEnderman;
import net.minecraft.src.EntityPig;
import net.minecraft.src.EntitySheep;
import net.minecraft.src.EntitySkeleton;
import net.minecraft.src.EntitySlime;
import net.minecraft.src.EntitySpider;
import net.minecraft.src.EntitySquid;
import net.minecraft.src.EntityZombie;
import net.minecraft.src.EnumCreatureType;
import net.minecraft.src.MathHelper;
import net.minecraft.src.SpawnListEntry;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenBigTree;
import net.minecraft.src.WorldGenForest;
import net.minecraft.src.WorldGenSwamp;
import net.minecraft.src.WorldGenTallGrass;
import net.minecraft.src.WorldGenTrees;
import net.minecraft.src.WorldGenerator;

public abstract class BiomeGenBase {

   public static final BiomeGenBase[] field_35486_a = new BiomeGenBase[256];
   public static final BiomeGenBase field_35484_b = (new BiomeGenOcean(0)).func_4123_b(112).func_4125_a("Ocean").func_35479_b(-1.0F, 0.4F);
   public static final BiomeGenBase field_35485_c = (new BiomeGenPlains(1)).func_4123_b(9286496).func_4125_a("Plains").func_35478_a(0.8F, 0.4F);
   public static final BiomeGenBase field_4249_h = (new BiomeGenDesert(2)).func_4123_b(16421912).func_4125_a("Desert").func_27076_e().func_35478_a(2.0F, 0.0F).func_35479_b(0.1F, 0.2F);
   public static final BiomeGenBase field_35483_e = (new BiomeGenHills(3)).func_4123_b(6316128).func_4125_a("Extreme Hills").func_35479_b(0.2F, 1.3F).func_35478_a(0.2F, 0.3F);
   public static final BiomeGenBase field_4253_d = (new BiomeGenForest(4)).func_4123_b(353825).func_4125_a("Forest").func_4124_a(5159473).func_35478_a(0.7F, 0.8F);
   public static final BiomeGenBase field_4250_g = (new BiomeGenTaiga(5)).func_4123_b(747097).func_4125_a("Taiga").func_4124_a(5159473).func_50086_b().func_35478_a(0.05F, 0.8F).func_35479_b(0.1F, 0.4F);
   public static final BiomeGenBase field_4255_b = (new BiomeGenSwamp(6)).func_4123_b(522674).func_4125_a("Swampland").func_4124_a(9154376).func_35479_b(-0.2F, 0.1F).func_35478_a(0.8F, 0.9F);
   public static final BiomeGenBase field_35487_i = (new BiomeGenRiver(7)).func_4123_b(255).func_4125_a("River").func_35479_b(-0.5F, 0.0F);
   public static final BiomeGenBase field_4245_l = (new BiomeGenHell(8)).func_4123_b(16711680).func_4125_a("Hell").func_27076_e().func_35478_a(2.0F, 0.0F);
   public static final BiomeGenBase field_28057_m = (new BiomeGenEnd(9)).func_4123_b(8421631).func_4125_a("Sky").func_27076_e();
   public static final BiomeGenBase field_40259_l = (new BiomeGenOcean(10)).func_4123_b(9474208).func_4125_a("FrozenOcean").func_50086_b().func_35479_b(-1.0F, 0.5F).func_35478_a(0.0F, 0.5F);
   public static final BiomeGenBase field_40260_m = (new BiomeGenRiver(11)).func_4123_b(10526975).func_4125_a("FrozenRiver").func_50086_b().func_35479_b(-0.5F, 0.0F).func_35478_a(0.0F, 0.5F);
   public static final BiomeGenBase field_40257_n = (new BiomeGenSnow(12)).func_4123_b(16777215).func_4125_a("Ice Plains").func_50086_b().func_35478_a(0.0F, 0.5F);
   public static final BiomeGenBase field_40258_o = (new BiomeGenSnow(13)).func_4123_b(10526880).func_4125_a("Ice Mountains").func_50086_b().func_35479_b(0.2F, 1.2F).func_35478_a(0.0F, 0.5F);
   public static final BiomeGenBase field_40262_p = (new BiomeGenMushroomIsland(14)).func_4123_b(16711935).func_4125_a("MushroomIsland").func_35478_a(0.9F, 1.0F).func_35479_b(0.2F, 1.0F);
   public static final BiomeGenBase field_40261_q = (new BiomeGenMushroomIsland(15)).func_4123_b(10486015).func_4125_a("MushroomIslandShore").func_35478_a(0.9F, 1.0F).func_35479_b(-1.0F, 0.1F);
   public static final BiomeGenBase field_46050_r = (new BiomeGenBeach(16)).func_4123_b(16440917).func_4125_a("Beach").func_35478_a(0.8F, 0.4F).func_35479_b(0.0F, 0.1F);
   public static final BiomeGenBase field_46049_s = (new BiomeGenDesert(17)).func_4123_b(13786898).func_4125_a("DesertHills").func_27076_e().func_35478_a(2.0F, 0.0F).func_35479_b(0.2F, 0.7F);
   public static final BiomeGenBase field_46048_t = (new BiomeGenForest(18)).func_4123_b(2250012).func_4125_a("ForestHills").func_4124_a(5159473).func_35478_a(0.7F, 0.8F).func_35479_b(0.2F, 0.6F);
   public static final BiomeGenBase field_46047_u = (new BiomeGenTaiga(19)).func_4123_b(1456435).func_4125_a("TaigaHills").func_50086_b().func_4124_a(5159473).func_35478_a(0.05F, 0.8F).func_35479_b(0.2F, 0.7F);
   public static final BiomeGenBase field_46046_v = (new BiomeGenHills(20)).func_4123_b(7501978).func_4125_a("Extreme Hills Edge").func_35479_b(0.2F, 0.8F).func_35478_a(0.2F, 0.3F);
   public static final BiomeGenBase field_48416_w = (new BiomeGenJungle(21)).func_4123_b(5470985).func_4125_a("Jungle").func_4124_a(5470985).func_35478_a(1.2F, 0.9F).func_35479_b(0.2F, 0.4F);
   public static final BiomeGenBase field_48417_x = (new BiomeGenJungle(22)).func_4123_b(2900485).func_4125_a("JungleHills").func_4124_a(5470985).func_35478_a(1.2F, 0.9F).func_35479_b(1.8F, 0.2F);
   public String field_6504_m;
   public int field_6503_n;
   public byte field_4242_o;
   public byte field_4241_p;
   public int field_6502_q;
   public float field_35492_q;
   public float field_35491_r;
   public float field_35490_s;
   public float field_35489_t;
   public int field_40256_A;
   public BiomeDecorator field_35488_u;
   protected List field_25066_r;
   protected List field_25065_s;
   protected List field_25064_t;
   private boolean field_27080_u;
   private boolean field_27079_v;
   public final int field_35494_y;
   protected WorldGenTrees field_35493_z;
   protected WorldGenBigTree field_35480_A;
   protected WorldGenForest field_35481_B;
   protected WorldGenSwamp field_35482_C;


   protected BiomeGenBase(int p_i769_1_) {
      this.field_4242_o = (byte)Block.field_337_v.field_376_bc;
      this.field_4241_p = (byte)Block.field_336_w.field_376_bc;
      this.field_6502_q = 5169201;
      this.field_35492_q = 0.1F;
      this.field_35491_r = 0.3F;
      this.field_35490_s = 0.5F;
      this.field_35489_t = 0.5F;
      this.field_40256_A = 16777215;
      this.field_25066_r = new ArrayList();
      this.field_25065_s = new ArrayList();
      this.field_25064_t = new ArrayList();
      this.field_27079_v = true;
      this.field_35493_z = new WorldGenTrees(false);
      this.field_35480_A = new WorldGenBigTree(false);
      this.field_35481_B = new WorldGenForest(false);
      this.field_35482_C = new WorldGenSwamp();
      this.field_35494_y = p_i769_1_;
      field_35486_a[p_i769_1_] = this;
      this.field_35488_u = this.func_35475_a();
      this.field_25065_s.add(new SpawnListEntry(EntitySheep.class, 12, 4, 4));
      this.field_25065_s.add(new SpawnListEntry(EntityPig.class, 10, 4, 4));
      this.field_25065_s.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
      this.field_25065_s.add(new SpawnListEntry(EntityCow.class, 8, 4, 4));
      this.field_25066_r.add(new SpawnListEntry(EntitySpider.class, 10, 4, 4));
      this.field_25066_r.add(new SpawnListEntry(EntityZombie.class, 10, 4, 4));
      this.field_25066_r.add(new SpawnListEntry(EntitySkeleton.class, 10, 4, 4));
      this.field_25066_r.add(new SpawnListEntry(EntityCreeper.class, 10, 4, 4));
      this.field_25066_r.add(new SpawnListEntry(EntitySlime.class, 10, 4, 4));
      this.field_25066_r.add(new SpawnListEntry(EntityEnderman.class, 1, 1, 4));
      this.field_25064_t.add(new SpawnListEntry(EntitySquid.class, 10, 4, 4));
   }

   protected BiomeDecorator func_35475_a() {
      return new BiomeDecorator(this);
   }

   private BiomeGenBase func_35478_a(float p_35478_1_, float p_35478_2_) {
      if(p_35478_1_ > 0.1F && p_35478_1_ < 0.2F) {
         throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
      } else {
         this.field_35490_s = p_35478_1_;
         this.field_35489_t = p_35478_2_;
         return this;
      }
   }

   private BiomeGenBase func_35479_b(float p_35479_1_, float p_35479_2_) {
      this.field_35492_q = p_35479_1_;
      this.field_35491_r = p_35479_2_;
      return this;
   }

   private BiomeGenBase func_27076_e() {
      this.field_27079_v = false;
      return this;
   }

   public WorldGenerator func_21107_a(Random p_21107_1_) {
      return (WorldGenerator)(p_21107_1_.nextInt(10) == 0?this.field_35480_A:this.field_35493_z);
   }

   public WorldGenerator func_48410_b(Random p_48410_1_) {
      return new WorldGenTallGrass(Block.field_9257_X.field_376_bc, 1);
   }

   protected BiomeGenBase func_50086_b() {
      this.field_27080_u = true;
      return this;
   }

   protected BiomeGenBase func_4125_a(String p_4125_1_) {
      this.field_6504_m = p_4125_1_;
      return this;
   }

   protected BiomeGenBase func_4124_a(int p_4124_1_) {
      this.field_6502_q = p_4124_1_;
      return this;
   }

   protected BiomeGenBase func_4123_b(int p_4123_1_) {
      this.field_6503_n = p_4123_1_;
      return this;
   }

   public int func_4126_a(float p_4126_1_) {
      p_4126_1_ /= 3.0F;
      if(p_4126_1_ < -1.0F) {
         p_4126_1_ = -1.0F;
      }

      if(p_4126_1_ > 1.0F) {
         p_4126_1_ = 1.0F;
      }

      return Color.getHSBColor(0.62222224F - p_4126_1_ * 0.05F, 0.5F + p_4126_1_ * 0.1F, 1.0F).getRGB();
   }

   public List func_25063_a(EnumCreatureType p_25063_1_) {
      return p_25063_1_ == EnumCreatureType.monster?this.field_25066_r:(p_25063_1_ == EnumCreatureType.creature?this.field_25065_s:(p_25063_1_ == EnumCreatureType.waterCreature?this.field_25064_t:null));
   }

   public boolean func_27078_c() {
      return this.field_27080_u;
   }

   public boolean func_27077_d() {
      return this.field_27080_u?false:this.field_27079_v;
   }

   public boolean func_48413_d() {
      return this.field_35489_t > 0.85F;
   }

   public float func_4119_a() {
      return 0.1F;
   }

   public final int func_35476_e() {
      return (int)(this.field_35489_t * 65536.0F);
   }

   public final int func_35474_f() {
      return (int)(this.field_35490_s * 65536.0F);
   }

   public final float func_48414_h() {
      return this.field_35489_t;
   }

   public final float func_48411_i() {
      return this.field_35490_s;
   }

   public void func_35477_a(World p_35477_1_, Random p_35477_2_, int p_35477_3_, int p_35477_4_) {
      this.field_35488_u.func_35881_a(p_35477_1_, p_35477_2_, p_35477_3_, p_35477_4_);
   }

   public int func_48415_j() {
      double var1 = (double)MathHelper.func_48442_a(this.func_48411_i(), 0.0F, 1.0F);
      double var3 = (double)MathHelper.func_48442_a(this.func_48414_h(), 0.0F, 1.0F);
      return ColorizerGrass.func_4147_a(var1, var3);
   }

   public int func_48412_k() {
      double var1 = (double)MathHelper.func_48442_a(this.func_48411_i(), 0.0F, 1.0F);
      double var3 = (double)MathHelper.func_48442_a(this.func_48414_h(), 0.0F, 1.0F);
      return ColorizerFoliage.func_4146_a(var1, var3);
   }

}
