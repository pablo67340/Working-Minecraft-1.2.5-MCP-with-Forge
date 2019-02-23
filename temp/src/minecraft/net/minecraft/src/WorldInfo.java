package net.minecraft.src;

import java.util.List;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.WorldSettings;
import net.minecraft.src.WorldType;

public class WorldInfo {

   private long field_22320_a;
   private WorldType field_46134_b;
   private int field_22319_b;
   private int field_22318_c;
   private int field_22317_d;
   private long field_22316_e;
   private long field_22315_f;
   private long field_22314_g;
   private NBTTagCompound field_22313_h;
   private int field_22312_i;
   private String field_22311_j;
   private int field_22310_k;
   private boolean field_27404_l;
   private int field_27403_m;
   private boolean field_27402_n;
   private int field_27401_o;
   private int field_35920_p;
   private boolean field_35919_q;
   private boolean field_40725_r;


   public WorldInfo(NBTTagCompound p_i662_1_) {
      this.field_46134_b = WorldType.field_48635_b;
      this.field_40725_r = false;
      this.field_22320_a = p_i662_1_.func_764_f("RandomSeed");
      if(p_i662_1_.func_751_b("generatorName")) {
         String var2 = p_i662_1_.func_755_i("generatorName");
         this.field_46134_b = WorldType.func_46135_a(var2);
         if(this.field_46134_b == null) {
            this.field_46134_b = WorldType.field_48635_b;
         } else if(this.field_46134_b.func_48626_e()) {
            int var3 = 0;
            if(p_i662_1_.func_751_b("generatorVersion")) {
               var3 = p_i662_1_.func_756_e("generatorVersion");
            }

            this.field_46134_b = this.field_46134_b.func_48629_a(var3);
         }
      }

      this.field_35920_p = p_i662_1_.func_756_e("GameType");
      if(p_i662_1_.func_751_b("MapFeatures")) {
         this.field_35919_q = p_i662_1_.func_760_m("MapFeatures");
      } else {
         this.field_35919_q = true;
      }

      this.field_22319_b = p_i662_1_.func_756_e("SpawnX");
      this.field_22318_c = p_i662_1_.func_756_e("SpawnY");
      this.field_22317_d = p_i662_1_.func_756_e("SpawnZ");
      this.field_22316_e = p_i662_1_.func_764_f("Time");
      this.field_22315_f = p_i662_1_.func_764_f("LastPlayed");
      this.field_22314_g = p_i662_1_.func_764_f("SizeOnDisk");
      this.field_22311_j = p_i662_1_.func_755_i("LevelName");
      this.field_22310_k = p_i662_1_.func_756_e("version");
      this.field_27403_m = p_i662_1_.func_756_e("rainTime");
      this.field_27404_l = p_i662_1_.func_760_m("raining");
      this.field_27401_o = p_i662_1_.func_756_e("thunderTime");
      this.field_27402_n = p_i662_1_.func_760_m("thundering");
      this.field_40725_r = p_i662_1_.func_760_m("hardcore");
      if(p_i662_1_.func_751_b("Player")) {
         this.field_22313_h = p_i662_1_.func_743_k("Player");
         this.field_22312_i = this.field_22313_h.func_756_e("Dimension");
      }

   }

   public WorldInfo(WorldSettings p_i663_1_, String p_i663_2_) {
      this.field_46134_b = WorldType.field_48635_b;
      this.field_40725_r = false;
      this.field_22320_a = p_i663_1_.func_35518_a();
      this.field_35920_p = p_i663_1_.func_35519_b();
      this.field_35919_q = p_i663_1_.func_35520_c();
      this.field_22311_j = p_i663_2_;
      this.field_40725_r = p_i663_1_.func_40557_c();
      this.field_46134_b = p_i663_1_.func_46107_e();
   }

   public WorldInfo(WorldInfo p_i664_1_) {
      this.field_46134_b = WorldType.field_48635_b;
      this.field_40725_r = false;
      this.field_22320_a = p_i664_1_.field_22320_a;
      this.field_46134_b = p_i664_1_.field_46134_b;
      this.field_35920_p = p_i664_1_.field_35920_p;
      this.field_35919_q = p_i664_1_.field_35919_q;
      this.field_22319_b = p_i664_1_.field_22319_b;
      this.field_22318_c = p_i664_1_.field_22318_c;
      this.field_22317_d = p_i664_1_.field_22317_d;
      this.field_22316_e = p_i664_1_.field_22316_e;
      this.field_22315_f = p_i664_1_.field_22315_f;
      this.field_22314_g = p_i664_1_.field_22314_g;
      this.field_22313_h = p_i664_1_.field_22313_h;
      this.field_22312_i = p_i664_1_.field_22312_i;
      this.field_22311_j = p_i664_1_.field_22311_j;
      this.field_22310_k = p_i664_1_.field_22310_k;
      this.field_27403_m = p_i664_1_.field_27403_m;
      this.field_27404_l = p_i664_1_.field_27404_l;
      this.field_27401_o = p_i664_1_.field_27401_o;
      this.field_27402_n = p_i664_1_.field_27402_n;
      this.field_40725_r = p_i664_1_.field_40725_r;
   }

   public NBTTagCompound func_22299_a() {
      NBTTagCompound var1 = new NBTTagCompound();
      this.func_22291_a(var1, this.field_22313_h);
      return var1;
   }

   public NBTTagCompound func_22305_a(List p_22305_1_) {
      NBTTagCompound var2 = new NBTTagCompound();
      EntityPlayer var3 = null;
      NBTTagCompound var4 = null;
      if(p_22305_1_.size() > 0) {
         var3 = (EntityPlayer)p_22305_1_.get(0);
      }

      if(var3 != null) {
         var4 = new NBTTagCompound();
         var3.func_363_d(var4);
      }

      this.func_22291_a(var2, var4);
      return var2;
   }

   private void func_22291_a(NBTTagCompound p_22291_1_, NBTTagCompound p_22291_2_) {
      p_22291_1_.func_750_a("RandomSeed", this.field_22320_a);
      p_22291_1_.func_754_a("generatorName", this.field_46134_b.func_48628_a());
      p_22291_1_.func_758_a("generatorVersion", this.field_46134_b.func_48630_c());
      p_22291_1_.func_758_a("GameType", this.field_35920_p);
      p_22291_1_.func_748_a("MapFeatures", this.field_35919_q);
      p_22291_1_.func_758_a("SpawnX", this.field_22319_b);
      p_22291_1_.func_758_a("SpawnY", this.field_22318_c);
      p_22291_1_.func_758_a("SpawnZ", this.field_22317_d);
      p_22291_1_.func_750_a("Time", this.field_22316_e);
      p_22291_1_.func_750_a("SizeOnDisk", this.field_22314_g);
      p_22291_1_.func_750_a("LastPlayed", System.currentTimeMillis());
      p_22291_1_.func_754_a("LevelName", this.field_22311_j);
      p_22291_1_.func_758_a("version", this.field_22310_k);
      p_22291_1_.func_758_a("rainTime", this.field_27403_m);
      p_22291_1_.func_748_a("raining", this.field_27404_l);
      p_22291_1_.func_758_a("thunderTime", this.field_27401_o);
      p_22291_1_.func_748_a("thundering", this.field_27402_n);
      p_22291_1_.func_748_a("hardcore", this.field_40725_r);
      if(p_22291_2_ != null) {
         p_22291_1_.func_763_a("Player", p_22291_2_);
      }

   }

   public long func_22288_b() {
      return this.field_22320_a;
   }

   public int func_22293_c() {
      return this.field_22319_b;
   }

   public int func_22295_d() {
      return this.field_22318_c;
   }

   public int func_22300_e() {
      return this.field_22317_d;
   }

   public long func_22304_f() {
      return this.field_22316_e;
   }

   public long func_22306_g() {
      return this.field_22314_g;
   }

   public NBTTagCompound func_22303_h() {
      return this.field_22313_h;
   }

   public int func_22290_i() {
      return this.field_22312_i;
   }

   public void func_22294_a(int p_22294_1_) {
      this.field_22319_b = p_22294_1_;
   }

   public void func_22308_b(int p_22308_1_) {
      this.field_22318_c = p_22308_1_;
   }

   public void func_22298_c(int p_22298_1_) {
      this.field_22317_d = p_22298_1_;
   }

   public void func_22307_a(long p_22307_1_) {
      this.field_22316_e = p_22307_1_;
   }

   public void func_22309_a(NBTTagCompound p_22309_1_) {
      this.field_22313_h = p_22309_1_;
   }

   public void func_22292_a(int p_22292_1_, int p_22292_2_, int p_22292_3_) {
      this.field_22319_b = p_22292_1_;
      this.field_22318_c = p_22292_2_;
      this.field_22317_d = p_22292_3_;
   }

   public String func_22302_j() {
      return this.field_22311_j;
   }

   public void func_22287_a(String p_22287_1_) {
      this.field_22311_j = p_22287_1_;
   }

   public int func_22296_k() {
      return this.field_22310_k;
   }

   public void func_22289_d(int p_22289_1_) {
      this.field_22310_k = p_22289_1_;
   }

   public long func_22301_l() {
      return this.field_22315_f;
   }

   public boolean func_27396_m() {
      return this.field_27402_n;
   }

   public void func_27398_a(boolean p_27398_1_) {
      this.field_27402_n = p_27398_1_;
   }

   public int func_27400_n() {
      return this.field_27401_o;
   }

   public void func_27399_e(int p_27399_1_) {
      this.field_27401_o = p_27399_1_;
   }

   public boolean func_27397_o() {
      return this.field_27404_l;
   }

   public void func_27394_b(boolean p_27394_1_) {
      this.field_27404_l = p_27394_1_;
   }

   public int func_27393_p() {
      return this.field_27403_m;
   }

   public void func_27395_f(int p_27395_1_) {
      this.field_27403_m = p_27395_1_;
   }

   public int func_35918_q() {
      return this.field_35920_p;
   }

   public boolean func_35917_r() {
      return this.field_35919_q;
   }

   public boolean func_40724_s() {
      return this.field_40725_r;
   }

   public WorldType func_46133_t() {
      return this.field_46134_b;
   }

   public void func_48619_a(WorldType p_48619_1_) {
      this.field_46134_b = p_48619_1_;
   }
}
