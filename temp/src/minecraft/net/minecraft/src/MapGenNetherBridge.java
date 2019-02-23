package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.src.EntityBlaze;
import net.minecraft.src.EntityMagmaCube;
import net.minecraft.src.EntityPigZombie;
import net.minecraft.src.MapGenStructure;
import net.minecraft.src.SpawnListEntry;
import net.minecraft.src.StructureNetherBridgeStart;
import net.minecraft.src.StructureStart;

public class MapGenNetherBridge extends MapGenStructure {

   private List field_40486_a = new ArrayList();


   public MapGenNetherBridge() {
      this.field_40486_a.add(new SpawnListEntry(EntityBlaze.class, 10, 2, 3));
      this.field_40486_a.add(new SpawnListEntry(EntityPigZombie.class, 10, 4, 4));
      this.field_40486_a.add(new SpawnListEntry(EntityMagmaCube.class, 3, 4, 4));
   }

   public List func_40485_b() {
      return this.field_40486_a;
   }

   protected boolean func_35628_a(int p_35628_1_, int p_35628_2_) {
      int var3 = p_35628_1_ >> 4;
      int var4 = p_35628_2_ >> 4;
      this.field_1305_b.setSeed((long)(var3 ^ var4 << 4) ^ this.field_35625_d.func_22138_q());
      this.field_1305_b.nextInt();
      return this.field_1305_b.nextInt(3) != 0?false:(p_35628_1_ != (var3 << 4) + 4 + this.field_1305_b.nextInt(8)?false:p_35628_2_ == (var4 << 4) + 4 + this.field_1305_b.nextInt(8));
   }

   protected StructureStart func_35630_b(int p_35630_1_, int p_35630_2_) {
      return new StructureNetherBridgeStart(this.field_35625_d, this.field_1305_b, p_35630_1_, p_35630_2_);
   }
}
