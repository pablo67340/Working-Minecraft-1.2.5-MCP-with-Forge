package net.minecraft.src;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.World;

public abstract class StructureStart {

   protected LinkedList field_35717_a = new LinkedList();
   protected StructureBoundingBox field_35716_b;


   public StructureBoundingBox func_35712_a() {
      return this.field_35716_b;
   }

   public LinkedList func_40560_b() {
      return this.field_35717_a;
   }

   public void func_35711_a(World p_35711_1_, Random p_35711_2_, StructureBoundingBox p_35711_3_) {
      Iterator var4 = this.field_35717_a.iterator();

      while(var4.hasNext()) {
         StructureComponent var5 = (StructureComponent)var4.next();
         if(var5.func_35021_b().func_35740_a(p_35711_3_) && !var5.func_35023_a(p_35711_1_, p_35711_2_, p_35711_3_)) {
            var4.remove();
         }
      }

   }

   protected void func_35714_b() {
      this.field_35716_b = StructureBoundingBox.func_35741_a();
      Iterator var1 = this.field_35717_a.iterator();

      while(var1.hasNext()) {
         StructureComponent var2 = (StructureComponent)var1.next();
         this.field_35716_b.func_35738_b(var2.func_35021_b());
      }

   }

   protected void func_35713_a(World p_35713_1_, Random p_35713_2_, int p_35713_3_) {
      int var4 = 63 - p_35713_3_;
      int var5 = this.field_35716_b.func_35743_c() + 1;
      if(var5 < var4) {
         var5 += p_35713_2_.nextInt(var4 - var5);
      }

      int var6 = var5 - this.field_35716_b.field_35750_e;
      this.field_35716_b.func_35745_a(0, var6, 0);
      Iterator var7 = this.field_35717_a.iterator();

      while(var7.hasNext()) {
         StructureComponent var8 = (StructureComponent)var7.next();
         var8.func_35021_b().func_35745_a(0, var6, 0);
      }

   }

   protected void func_40559_a(World p_40559_1_, Random p_40559_2_, int p_40559_3_, int p_40559_4_) {
      int var5 = p_40559_4_ - p_40559_3_ + 1 - this.field_35716_b.func_35743_c();
      boolean var6 = true;
      int var10;
      if(var5 > 1) {
         var10 = p_40559_3_ + p_40559_2_.nextInt(var5);
      } else {
         var10 = p_40559_3_;
      }

      int var7 = var10 - this.field_35716_b.field_35751_b;
      this.field_35716_b.func_35745_a(0, var7, 0);
      Iterator var8 = this.field_35717_a.iterator();

      while(var8.hasNext()) {
         StructureComponent var9 = (StructureComponent)var8.next();
         var9.func_35021_b().func_35745_a(0, var7, 0);
      }

   }

   public boolean func_35715_c() {
      return true;
   }
}
