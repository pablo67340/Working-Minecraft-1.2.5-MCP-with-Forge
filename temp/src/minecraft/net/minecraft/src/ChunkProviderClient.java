package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.src.Chunk;
import net.minecraft.src.ChunkCoordIntPair;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.EmptyChunk;
import net.minecraft.src.EnumCreatureType;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.IProgressUpdate;
import net.minecraft.src.LongHashMap;
import net.minecraft.src.World;

public class ChunkProviderClient implements IChunkProvider {

   private Chunk field_887_a;
   private LongHashMap field_886_b = new LongHashMap();
   private List field_889_c = new ArrayList();
   private World field_888_d;


   public ChunkProviderClient(World p_i511_1_) {
      this.field_887_a = new EmptyChunk(p_i511_1_, 0, 0);
      this.field_888_d = p_i511_1_;
   }

   public boolean func_537_a(int p_537_1_, int p_537_2_) {
      return true;
   }

   public void func_539_c(int p_539_1_, int p_539_2_) {
      Chunk var3 = this.func_533_b(p_539_1_, p_539_2_);
      if(!var3.func_21167_h()) {
         var3.func_998_e();
      }

      this.field_886_b.func_35574_d(ChunkCoordIntPair.func_22011_a(p_539_1_, p_539_2_));
      this.field_889_c.remove(var3);
   }

   public Chunk func_538_d(int p_538_1_, int p_538_2_) {
      Chunk var3 = new Chunk(this.field_888_d, p_538_1_, p_538_2_);
      this.field_886_b.func_35577_a(ChunkCoordIntPair.func_22011_a(p_538_1_, p_538_2_), var3);
      var3.field_1538_c = true;
      return var3;
   }

   public Chunk func_533_b(int p_533_1_, int p_533_2_) {
      Chunk var3 = (Chunk)this.field_886_b.func_35578_a(ChunkCoordIntPair.func_22011_a(p_533_1_, p_533_2_));
      return var3 == null?this.field_887_a:var3;
   }

   public boolean func_535_a(boolean p_535_1_, IProgressUpdate p_535_2_) {
      return true;
   }

   public boolean func_532_a() {
      return false;
   }

   public boolean func_536_b() {
      return false;
   }

   public void func_534_a(IChunkProvider p_534_1_, int p_534_2_, int p_534_3_) {}

   public String func_21109_c() {
      return "MultiplayerChunkCache: " + this.field_886_b.func_35576_a();
   }

   public List func_40377_a(EnumCreatureType p_40377_1_, int p_40377_2_, int p_40377_3_, int p_40377_4_) {
      return null;
   }

   public ChunkPosition func_40376_a(World p_40376_1_, String p_40376_2_, int p_40376_3_, int p_40376_4_, int p_40376_5_) {
      return null;
   }
}
