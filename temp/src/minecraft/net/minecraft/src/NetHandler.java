package net.minecraft.src;

import net.minecraft.src.Packet;
import net.minecraft.src.Packet0KeepAlive;
import net.minecraft.src.Packet100OpenWindow;
import net.minecraft.src.Packet101CloseWindow;
import net.minecraft.src.Packet102WindowClick;
import net.minecraft.src.Packet103SetSlot;
import net.minecraft.src.Packet104WindowItems;
import net.minecraft.src.Packet105UpdateProgressbar;
import net.minecraft.src.Packet106Transaction;
import net.minecraft.src.Packet107CreativeSetSlot;
import net.minecraft.src.Packet108EnchantItem;
import net.minecraft.src.Packet10Flying;
import net.minecraft.src.Packet130UpdateSign;
import net.minecraft.src.Packet131MapData;
import net.minecraft.src.Packet132TileEntityData;
import net.minecraft.src.Packet14BlockDig;
import net.minecraft.src.Packet15Place;
import net.minecraft.src.Packet16BlockItemSwitch;
import net.minecraft.src.Packet17Sleep;
import net.minecraft.src.Packet18Animation;
import net.minecraft.src.Packet19EntityAction;
import net.minecraft.src.Packet1Login;
import net.minecraft.src.Packet200Statistic;
import net.minecraft.src.Packet201PlayerInfo;
import net.minecraft.src.Packet202PlayerAbilities;
import net.minecraft.src.Packet20NamedEntitySpawn;
import net.minecraft.src.Packet21PickupSpawn;
import net.minecraft.src.Packet22Collect;
import net.minecraft.src.Packet23VehicleSpawn;
import net.minecraft.src.Packet24MobSpawn;
import net.minecraft.src.Packet250CustomPayload;
import net.minecraft.src.Packet254ServerPing;
import net.minecraft.src.Packet255KickDisconnect;
import net.minecraft.src.Packet25EntityPainting;
import net.minecraft.src.Packet26EntityExpOrb;
import net.minecraft.src.Packet28EntityVelocity;
import net.minecraft.src.Packet29DestroyEntity;
import net.minecraft.src.Packet2Handshake;
import net.minecraft.src.Packet30Entity;
import net.minecraft.src.Packet34EntityTeleport;
import net.minecraft.src.Packet35EntityHeadRotation;
import net.minecraft.src.Packet38EntityStatus;
import net.minecraft.src.Packet39AttachEntity;
import net.minecraft.src.Packet3Chat;
import net.minecraft.src.Packet40EntityMetadata;
import net.minecraft.src.Packet41EntityEffect;
import net.minecraft.src.Packet42RemoveEntityEffect;
import net.minecraft.src.Packet43Experience;
import net.minecraft.src.Packet4UpdateTime;
import net.minecraft.src.Packet50PreChunk;
import net.minecraft.src.Packet51MapChunk;
import net.minecraft.src.Packet52MultiBlockChange;
import net.minecraft.src.Packet53BlockChange;
import net.minecraft.src.Packet54PlayNoteBlock;
import net.minecraft.src.Packet5PlayerInventory;
import net.minecraft.src.Packet60Explosion;
import net.minecraft.src.Packet61DoorChange;
import net.minecraft.src.Packet6SpawnPosition;
import net.minecraft.src.Packet70Bed;
import net.minecraft.src.Packet71Weather;
import net.minecraft.src.Packet7UseEntity;
import net.minecraft.src.Packet8UpdateHealth;
import net.minecraft.src.Packet9Respawn;

public abstract class NetHandler {

   public abstract boolean func_27247_c();

   public void func_48487_a(Packet51MapChunk p_48487_1_) {}

   public void func_4114_b(Packet p_4114_1_) {}

   public void func_823_a(String p_823_1_, Object[] p_823_2_) {}

   public void func_844_a(Packet255KickDisconnect p_844_1_) {
      this.func_4114_b(p_844_1_);
   }

   public void func_4115_a(Packet1Login p_4115_1_) {
      this.func_4114_b(p_4115_1_);
   }

   public void func_837_a(Packet10Flying p_837_1_) {
      this.func_4114_b(p_837_1_);
   }

   public void func_824_a(Packet52MultiBlockChange p_824_1_) {
      this.func_4114_b(p_824_1_);
   }

   public void func_821_a(Packet14BlockDig p_821_1_) {
      this.func_4114_b(p_821_1_);
   }

   public void func_822_a(Packet53BlockChange p_822_1_) {
      this.func_4114_b(p_822_1_);
   }

   public void func_826_a(Packet50PreChunk p_826_1_) {
      this.func_4114_b(p_826_1_);
   }

   public void func_820_a(Packet20NamedEntitySpawn p_820_1_) {
      this.func_4114_b(p_820_1_);
   }

   public void func_827_a(Packet30Entity p_827_1_) {
      this.func_4114_b(p_827_1_);
   }

   public void func_829_a(Packet34EntityTeleport p_829_1_) {
      this.func_4114_b(p_829_1_);
   }

   public void func_819_a(Packet15Place p_819_1_) {
      this.func_4114_b(p_819_1_);
   }

   public void func_841_a(Packet16BlockItemSwitch p_841_1_) {
      this.func_4114_b(p_841_1_);
   }

   public void func_839_a(Packet29DestroyEntity p_839_1_) {
      this.func_4114_b(p_839_1_);
   }

   public void func_832_a(Packet21PickupSpawn p_832_1_) {
      this.func_4114_b(p_832_1_);
   }

   public void func_834_a(Packet22Collect p_834_1_) {
      this.func_4114_b(p_834_1_);
   }

   public void func_4113_a(Packet3Chat p_4113_1_) {
      this.func_4114_b(p_4113_1_);
   }

   public void func_835_a(Packet23VehicleSpawn p_835_1_) {
      this.func_4114_b(p_835_1_);
   }

   public void func_825_a(Packet18Animation p_825_1_) {
      this.func_4114_b(p_825_1_);
   }

   public void func_21147_a(Packet19EntityAction p_21147_1_) {
      this.func_4114_b(p_21147_1_);
   }

   public void func_838_a(Packet2Handshake p_838_1_) {
      this.func_4114_b(p_838_1_);
   }

   public void func_828_a(Packet24MobSpawn p_828_1_) {
      this.func_4114_b(p_828_1_);
   }

   public void func_846_a(Packet4UpdateTime p_846_1_) {
      this.func_4114_b(p_846_1_);
   }

   public void func_845_a(Packet6SpawnPosition p_845_1_) {
      this.func_4114_b(p_845_1_);
   }

   public void func_6498_a(Packet28EntityVelocity p_6498_1_) {
      this.func_4114_b(p_6498_1_);
   }

   public void func_21148_a(Packet40EntityMetadata p_21148_1_) {
      this.func_4114_b(p_21148_1_);
   }

   public void func_6497_a(Packet39AttachEntity p_6497_1_) {
      this.func_4114_b(p_6497_1_);
   }

   public void func_6499_a(Packet7UseEntity p_6499_1_) {
      this.func_4114_b(p_6499_1_);
   }

   public void func_9447_a(Packet38EntityStatus p_9447_1_) {
      this.func_4114_b(p_9447_1_);
   }

   public void func_9446_a(Packet8UpdateHealth p_9446_1_) {
      this.func_4114_b(p_9446_1_);
   }

   public void func_9448_a(Packet9Respawn p_9448_1_) {
      this.func_4114_b(p_9448_1_);
   }

   public void func_12245_a(Packet60Explosion p_12245_1_) {
      this.func_4114_b(p_12245_1_);
   }

   public void func_20087_a(Packet100OpenWindow p_20087_1_) {
      this.func_4114_b(p_20087_1_);
   }

   public void func_20092_a(Packet101CloseWindow p_20092_1_) {
      this.func_4114_b(p_20092_1_);
   }

   public void func_20091_a(Packet102WindowClick p_20091_1_) {
      this.func_4114_b(p_20091_1_);
   }

   public void func_20088_a(Packet103SetSlot p_20088_1_) {
      this.func_4114_b(p_20088_1_);
   }

   public void func_20094_a(Packet104WindowItems p_20094_1_) {
      this.func_4114_b(p_20094_1_);
   }

   public void func_20093_a(Packet130UpdateSign p_20093_1_) {
      this.func_4114_b(p_20093_1_);
   }

   public void func_20090_a(Packet105UpdateProgressbar p_20090_1_) {
      this.func_4114_b(p_20090_1_);
   }

   public void func_843_a(Packet5PlayerInventory p_843_1_) {
      this.func_4114_b(p_843_1_);
   }

   public void func_20089_a(Packet106Transaction p_20089_1_) {
      this.func_4114_b(p_20089_1_);
   }

   public void func_21146_a(Packet25EntityPainting p_21146_1_) {
      this.func_4114_b(p_21146_1_);
   }

   public void func_21145_a(Packet54PlayNoteBlock p_21145_1_) {
      this.func_4114_b(p_21145_1_);
   }

   public void func_27245_a(Packet200Statistic p_27245_1_) {
      this.func_4114_b(p_27245_1_);
   }

   public void func_22186_a(Packet17Sleep p_22186_1_) {
      this.func_4114_b(p_22186_1_);
   }

   public void func_25118_a(Packet70Bed p_25118_1_) {
      this.func_4114_b(p_25118_1_);
   }

   public void func_27246_a(Packet71Weather p_27246_1_) {
      this.func_4114_b(p_27246_1_);
   }

   public void func_28116_a(Packet131MapData p_28116_1_) {
      this.func_4114_b(p_28116_1_);
   }

   public void func_28115_a(Packet61DoorChange p_28115_1_) {
      this.func_4114_b(p_28115_1_);
   }

   public void func_35782_a(Packet254ServerPing p_35782_1_) {
      this.func_4114_b(p_35782_1_);
   }

   public void func_35780_a(Packet41EntityEffect p_35780_1_) {
      this.func_4114_b(p_35780_1_);
   }

   public void func_35783_a(Packet42RemoveEntityEffect p_35783_1_) {
      this.func_4114_b(p_35783_1_);
   }

   public void func_35779_a(Packet201PlayerInfo p_35779_1_) {
      this.func_4114_b(p_35779_1_);
   }

   public void func_35784_a(Packet0KeepAlive p_35784_1_) {
      this.func_4114_b(p_35784_1_);
   }

   public void func_35777_a(Packet43Experience p_35777_1_) {
      this.func_4114_b(p_35777_1_);
   }

   public void func_35781_a(Packet107CreativeSetSlot p_35781_1_) {
      this.func_4114_b(p_35781_1_);
   }

   public void func_35778_a(Packet26EntityExpOrb p_35778_1_) {
      this.func_4114_b(p_35778_1_);
   }

   public void func_40599_a(Packet108EnchantItem p_40599_1_) {}

   public void func_44028_a(Packet250CustomPayload p_44028_1_) {}

   public void func_48488_a(Packet35EntityHeadRotation p_48488_1_) {
      this.func_4114_b(p_48488_1_);
   }

   public void func_48489_a(Packet132TileEntityData p_48489_1_) {
      this.func_4114_b(p_48489_1_);
   }

   public void func_50100_a(Packet202PlayerAbilities p_50100_1_) {
      this.func_4114_b(p_50100_1_);
   }
}
