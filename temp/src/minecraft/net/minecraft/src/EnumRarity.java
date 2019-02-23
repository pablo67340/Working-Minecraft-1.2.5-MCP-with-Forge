package net.minecraft.src;


public enum EnumRarity {

   common("common", 0, 15, "Common"),
   uncommon("uncommon", 1, 14, "Uncommon"),
   rare("rare", 2, 11, "Rare"),
   epic("epic", 3, 13, "Epic");
   public final int field_40535_e;
   public final String field_40532_f;
   // $FF: synthetic field
   private static final EnumRarity[] $VALUES = new EnumRarity[]{common, uncommon, rare, epic};


   private EnumRarity(String p_i325_1_, int p_i325_2_, int p_i325_3_, String p_i325_4_) {
      this.field_40535_e = p_i325_3_;
      this.field_40532_f = p_i325_4_;
   }

}
