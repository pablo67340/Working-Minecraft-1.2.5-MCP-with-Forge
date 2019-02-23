package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.src.ComponentVillageRoadPiece;
import net.minecraft.src.ComponentVillageStartPiece;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.StructureStart;
import net.minecraft.src.StructureVillagePieces;
import net.minecraft.src.World;

class StructureVillageStart extends StructureStart {

   private boolean field_35718_c = false;


   public StructureVillageStart(World p_i690_1_, Random p_i690_2_, int p_i690_3_, int p_i690_4_, int p_i690_5_) {
      ArrayList var7 = StructureVillagePieces.func_35705_a(p_i690_2_, p_i690_5_);
      ComponentVillageStartPiece var8 = new ComponentVillageStartPiece(p_i690_1_.func_4075_a(), 0, p_i690_2_, (p_i690_3_ << 4) + 2, (p_i690_4_ << 4) + 2, var7, p_i690_5_);
      this.field_35717_a.add(var8);
      var8.func_35004_a(var8, this.field_35717_a, p_i690_2_);
      ArrayList var9 = var8.field_35106_f;
      ArrayList var10 = var8.field_35108_e;

      int var11;
      while(!var9.isEmpty() || !var10.isEmpty()) {
         StructureComponent var12;
         if(!var9.isEmpty()) {
            var11 = p_i690_2_.nextInt(var9.size());
            var12 = (StructureComponent)var9.remove(var11);
            var12.func_35004_a(var8, this.field_35717_a, p_i690_2_);
         } else {
            var11 = p_i690_2_.nextInt(var10.size());
            var12 = (StructureComponent)var10.remove(var11);
            var12.func_35004_a(var8, this.field_35717_a, p_i690_2_);
         }
      }

      this.func_35714_b();
      var11 = 0;
      Iterator var14 = this.field_35717_a.iterator();

      while(var14.hasNext()) {
         StructureComponent var13 = (StructureComponent)var14.next();
         if(!(var13 instanceof ComponentVillageRoadPiece)) {
            ++var11;
         }
      }

      this.field_35718_c = var11 > 2;
   }

   public boolean func_35715_c() {
      return this.field_35718_c;
   }
}
