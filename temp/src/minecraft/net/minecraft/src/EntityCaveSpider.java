package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntitySpider;
import net.minecraft.src.Potion;
import net.minecraft.src.PotionEffect;
import net.minecraft.src.World;

public class EntityCaveSpider extends EntitySpider {

   public EntityCaveSpider(World p_i324_1_) {
      super(p_i324_1_);
      this.field_9357_z = "/mob/cavespider.png";
      this.func_371_a(0.7F, 0.5F);
   }

   public int func_40117_c() {
      return 12;
   }

   public float func_35188_k_() {
      return 0.7F;
   }

   public boolean func_35175_b(Entity p_35175_1_) {
      if(super.func_35175_b(p_35175_1_)) {
         if(p_35175_1_ instanceof EntityLiving) {
            byte var2 = 0;
            if(this.field_615_ag.field_1039_l > 1) {
               if(this.field_615_ag.field_1039_l == 2) {
                  var2 = 7;
               } else if(this.field_615_ag.field_1039_l == 3) {
                  var2 = 15;
               }
            }

            if(var2 > 0) {
               ((EntityLiving)p_35175_1_).func_35165_a(new PotionEffect(Potion.field_35689_u.field_35670_H, var2 * 20, 0));
            }
         }

         return true;
      } else {
         return false;
      }
   }
}
