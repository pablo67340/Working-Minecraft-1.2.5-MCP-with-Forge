package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.EntityChicken;
import net.minecraft.src.EntityOcelot;
import net.minecraft.src.SpawnListEntry;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenHugeTrees;
import net.minecraft.src.WorldGenShrub;
import net.minecraft.src.WorldGenTallGrass;
import net.minecraft.src.WorldGenTrees;
import net.minecraft.src.WorldGenVines;
import net.minecraft.src.WorldGenerator;

public class BiomeGenJungle extends BiomeGenBase {

   public BiomeGenJungle(int p_i1026_1_) {
      super(p_i1026_1_);
      this.field_35488_u.field_35911_r = 50;
      this.field_35488_u.field_35909_t = 25;
      this.field_35488_u.field_35910_s = 4;
      this.field_25066_r.add(new SpawnListEntry(EntityOcelot.class, 2, 1, 1));
      this.field_25065_s.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
   }

   public WorldGenerator func_21107_a(Random p_21107_1_) {
      return (WorldGenerator)(p_21107_1_.nextInt(10) == 0?this.field_35480_A:(p_21107_1_.nextInt(2) == 0?new WorldGenShrub(3, 0):(p_21107_1_.nextInt(3) == 0?new WorldGenHugeTrees(false, 10 + p_21107_1_.nextInt(20), 3, 3):new WorldGenTrees(false, 4 + p_21107_1_.nextInt(7), 3, 3, true))));
   }

   public WorldGenerator func_48410_b(Random p_48410_1_) {
      return p_48410_1_.nextInt(4) == 0?new WorldGenTallGrass(Block.field_9257_X.field_376_bc, 2):new WorldGenTallGrass(Block.field_9257_X.field_376_bc, 1);
   }

   public void func_35477_a(World p_35477_1_, Random p_35477_2_, int p_35477_3_, int p_35477_4_) {
      super.func_35477_a(p_35477_1_, p_35477_2_, p_35477_3_, p_35477_4_);
      WorldGenVines var5 = new WorldGenVines();

      for(int var6 = 0; var6 < 50; ++var6) {
         int var7 = p_35477_3_ + p_35477_2_.nextInt(16) + 8;
         byte var8 = 64;
         int var9 = p_35477_4_ + p_35477_2_.nextInt(16) + 8;
         var5.func_516_a(p_35477_1_, p_35477_2_, var7, var8, var9);
      }

   }
}
