package argo.saj;

import argo.saj.InvalidSyntaxException;
import argo.saj.JsonListener;
import argo.saj.PositionTrackingPushbackReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public final class SajParser {

   public void func_27463_a(Reader p_27463_1_, JsonListener p_27463_2_) throws InvalidSyntaxException, IOException {
      PositionTrackingPushbackReader var3 = new PositionTrackingPushbackReader(p_27463_1_);
      char var4 = (char)var3.func_27333_c();
      switch(var4) {
      case 91:
         var3.func_27334_a(var4);
         p_27463_2_.func_27195_b();
         this.func_27455_a(var3, p_27463_2_);
         break;
      case 123:
         var3.func_27334_a(var4);
         p_27463_2_.func_27195_b();
         this.func_27453_b(var3, p_27463_2_);
         break;
      default:
         throw new InvalidSyntaxException("Expected either [ or { but got [" + var4 + "].", var3);
      }

      int var5 = this.func_27448_l(var3);
      if(var5 != -1) {
         throw new InvalidSyntaxException("Got unexpected trailing character [" + (char)var5 + "].", var3);
      } else {
         p_27463_2_.func_27204_c();
      }
   }

   private void func_27455_a(PositionTrackingPushbackReader p_27455_1_, JsonListener p_27455_2_) throws InvalidSyntaxException, IOException {
      char var3 = (char)this.func_27448_l(p_27455_1_);
      if(var3 != 91) {
         throw new InvalidSyntaxException("Expected object to start with [ but got [" + var3 + "].", p_27455_1_);
      } else {
         p_27455_2_.func_27200_d();
         char var4 = (char)this.func_27448_l(p_27455_1_);
         p_27455_1_.func_27334_a(var4);
         if(var4 != 93) {
            this.func_27464_d(p_27455_1_, p_27455_2_);
         }

         boolean var5 = false;

         while(!var5) {
            char var6 = (char)this.func_27448_l(p_27455_1_);
            switch(var6) {
            case 44:
               this.func_27464_d(p_27455_1_, p_27455_2_);
               break;
            case 93:
               var5 = true;
               break;
            default:
               throw new InvalidSyntaxException("Expected either , or ] but got [" + var6 + "].", p_27455_1_);
            }
         }

         p_27455_2_.func_27197_e();
      }
   }

   private void func_27453_b(PositionTrackingPushbackReader p_27453_1_, JsonListener p_27453_2_) throws InvalidSyntaxException, IOException {
      char var3 = (char)this.func_27448_l(p_27453_1_);
      if(var3 != 123) {
         throw new InvalidSyntaxException("Expected object to start with { but got [" + var3 + "].", p_27453_1_);
      } else {
         p_27453_2_.func_27194_f();
         char var4 = (char)this.func_27448_l(p_27453_1_);
         p_27453_1_.func_27334_a(var4);
         if(var4 != 125) {
            this.func_27449_c(p_27453_1_, p_27453_2_);
         }

         boolean var5 = false;

         while(!var5) {
            char var6 = (char)this.func_27448_l(p_27453_1_);
            switch(var6) {
            case 44:
               this.func_27449_c(p_27453_1_, p_27453_2_);
               break;
            case 125:
               var5 = true;
               break;
            default:
               throw new InvalidSyntaxException("Expected either , or } but got [" + var6 + "].", p_27453_1_);
            }
         }

         p_27453_2_.func_27203_g();
      }
   }

   private void func_27449_c(PositionTrackingPushbackReader p_27449_1_, JsonListener p_27449_2_) throws InvalidSyntaxException, IOException {
      char var3 = (char)this.func_27448_l(p_27449_1_);
      if(34 != var3) {
         throw new InvalidSyntaxException("Expected object identifier to begin with [\"] but got [" + var3 + "].", p_27449_1_);
      } else {
         p_27449_1_.func_27334_a(var3);
         p_27449_2_.func_27205_a(this.func_27452_i(p_27449_1_));
         char var4 = (char)this.func_27448_l(p_27449_1_);
         if(var4 != 58) {
            throw new InvalidSyntaxException("Expected object identifier to be followed by : but got [" + var4 + "].", p_27449_1_);
         } else {
            this.func_27464_d(p_27449_1_, p_27449_2_);
            p_27449_2_.func_27199_h();
         }
      }
   }

   private void func_27464_d(PositionTrackingPushbackReader p_27464_1_, JsonListener p_27464_2_) throws InvalidSyntaxException, IOException {
      char var3 = (char)this.func_27448_l(p_27464_1_);
      switch(var3) {
      case 34:
         p_27464_1_.func_27334_a(var3);
         p_27464_2_.func_27198_c(this.func_27452_i(p_27464_1_));
         break;
      case 45:
      case 48:
      case 49:
      case 50:
      case 51:
      case 52:
      case 53:
      case 54:
      case 55:
      case 56:
      case 57:
         p_27464_1_.func_27334_a(var3);
         p_27464_2_.func_27201_b(this.func_27459_a(p_27464_1_));
         break;
      case 91:
         p_27464_1_.func_27334_a(var3);
         this.func_27455_a(p_27464_1_, p_27464_2_);
         break;
      case 102:
         char[] var6 = new char[4];
         int var7 = p_27464_1_.func_27336_b(var6);
         if(var7 != 4 || var6[0] != 97 || var6[1] != 108 || var6[2] != 115 || var6[3] != 101) {
            p_27464_1_.func_27335_a(var6);
            throw new InvalidSyntaxException("Expected \'f\' to be followed by [[a, l, s, e]], but got [" + Arrays.toString(var6) + "].", p_27464_1_);
         }

         p_27464_2_.func_27193_j();
         break;
      case 110:
         char[] var8 = new char[3];
         int var9 = p_27464_1_.func_27336_b(var8);
         if(var9 != 3 || var8[0] != 117 || var8[1] != 108 || var8[2] != 108) {
            p_27464_1_.func_27335_a(var8);
            throw new InvalidSyntaxException("Expected \'n\' to be followed by [[u, l, l]], but got [" + Arrays.toString(var8) + "].", p_27464_1_);
         }

         p_27464_2_.func_27202_k();
         break;
      case 116:
         char[] var4 = new char[3];
         int var5 = p_27464_1_.func_27336_b(var4);
         if(var5 != 3 || var4[0] != 114 || var4[1] != 117 || var4[2] != 101) {
            p_27464_1_.func_27335_a(var4);
            throw new InvalidSyntaxException("Expected \'t\' to be followed by [[r, u, e]], but got [" + Arrays.toString(var4) + "].", p_27464_1_);
         }

         p_27464_2_.func_27196_i();
         break;
      case 123:
         p_27464_1_.func_27334_a(var3);
         this.func_27453_b(p_27464_1_, p_27464_2_);
         break;
      default:
         throw new InvalidSyntaxException("Invalid character at start of value [" + var3 + "].", p_27464_1_);
      }

   }

   private String func_27459_a(PositionTrackingPushbackReader p_27459_1_) throws IOException, InvalidSyntaxException {
      StringBuilder var2 = new StringBuilder();
      char var3 = (char)p_27459_1_.func_27333_c();
      if(45 == var3) {
         var2.append('-');
      } else {
         p_27459_1_.func_27334_a(var3);
      }

      var2.append(this.func_27451_b(p_27459_1_));
      return var2.toString();
   }

   private String func_27451_b(PositionTrackingPushbackReader p_27451_1_) throws IOException, InvalidSyntaxException {
      StringBuilder var2 = new StringBuilder();
      char var3 = (char)p_27451_1_.func_27333_c();
      if(48 == var3) {
         var2.append('0');
         var2.append(this.func_27462_f(p_27451_1_));
         var2.append(this.func_27454_g(p_27451_1_));
      } else {
         p_27451_1_.func_27334_a(var3);
         var2.append(this.func_27460_c(p_27451_1_));
         var2.append(this.func_27456_e(p_27451_1_));
         var2.append(this.func_27462_f(p_27451_1_));
         var2.append(this.func_27454_g(p_27451_1_));
      }

      return var2.toString();
   }

   private char func_27460_c(PositionTrackingPushbackReader p_27460_1_) throws IOException, InvalidSyntaxException {
      char var3 = (char)p_27460_1_.func_27333_c();
      switch(var3) {
      case 49:
      case 50:
      case 51:
      case 52:
      case 53:
      case 54:
      case 55:
      case 56:
      case 57:
         return var3;
      default:
         throw new InvalidSyntaxException("Expected a digit 1 - 9 but got [" + var3 + "].", p_27460_1_);
      }
   }

   private char func_27458_d(PositionTrackingPushbackReader p_27458_1_) throws IOException, InvalidSyntaxException {
      char var3 = (char)p_27458_1_.func_27333_c();
      switch(var3) {
      case 48:
      case 49:
      case 50:
      case 51:
      case 52:
      case 53:
      case 54:
      case 55:
      case 56:
      case 57:
         return var3;
      default:
         throw new InvalidSyntaxException("Expected a digit 1 - 9 but got [" + var3 + "].", p_27458_1_);
      }
   }

   private String func_27456_e(PositionTrackingPushbackReader p_27456_1_) throws IOException {
      StringBuilder var2 = new StringBuilder();
      boolean var3 = false;

      while(!var3) {
         char var4 = (char)p_27456_1_.func_27333_c();
         switch(var4) {
         case 48:
         case 49:
         case 50:
         case 51:
         case 52:
         case 53:
         case 54:
         case 55:
         case 56:
         case 57:
            var2.append(var4);
            break;
         default:
            var3 = true;
            p_27456_1_.func_27334_a(var4);
         }
      }

      return var2.toString();
   }

   private String func_27462_f(PositionTrackingPushbackReader p_27462_1_) throws IOException, InvalidSyntaxException {
      StringBuilder var2 = new StringBuilder();
      char var3 = (char)p_27462_1_.func_27333_c();
      if(var3 == 46) {
         var2.append('.');
         var2.append(this.func_27458_d(p_27462_1_));
         var2.append(this.func_27456_e(p_27462_1_));
      } else {
         p_27462_1_.func_27334_a(var3);
      }

      return var2.toString();
   }

   private String func_27454_g(PositionTrackingPushbackReader p_27454_1_) throws IOException, InvalidSyntaxException {
      StringBuilder var2 = new StringBuilder();
      char var3 = (char)p_27454_1_.func_27333_c();
      if(var3 != 46 && var3 != 69) {
         p_27454_1_.func_27334_a(var3);
      } else {
         var2.append('E');
         var2.append(this.func_27461_h(p_27454_1_));
         var2.append(this.func_27458_d(p_27454_1_));
         var2.append(this.func_27456_e(p_27454_1_));
      }

      return var2.toString();
   }

   private String func_27461_h(PositionTrackingPushbackReader p_27461_1_) throws IOException {
      StringBuilder var2 = new StringBuilder();
      char var3 = (char)p_27461_1_.func_27333_c();
      if(var3 != 43 && var3 != 45) {
         p_27461_1_.func_27334_a(var3);
      } else {
         var2.append(var3);
      }

      return var2.toString();
   }

   private String func_27452_i(PositionTrackingPushbackReader p_27452_1_) throws InvalidSyntaxException, IOException {
      StringBuilder var2 = new StringBuilder();
      char var3 = (char)p_27452_1_.func_27333_c();
      if(34 != var3) {
         throw new InvalidSyntaxException("Expected [\"] but got [" + var3 + "].", p_27452_1_);
      } else {
         boolean var4 = false;

         while(!var4) {
            char var5 = (char)p_27452_1_.func_27333_c();
            switch(var5) {
            case 34:
               var4 = true;
               break;
            case 92:
               char var6 = this.func_27457_j(p_27452_1_);
               var2.append(var6);
               break;
            default:
               var2.append(var5);
            }
         }

         return var2.toString();
      }
   }

   private char func_27457_j(PositionTrackingPushbackReader p_27457_1_) throws IOException, InvalidSyntaxException {
      char var3 = (char)p_27457_1_.func_27333_c();
      char var2;
      switch(var3) {
      case 34:
         var2 = 34;
         break;
      case 47:
         var2 = 47;
         break;
      case 92:
         var2 = 92;
         break;
      case 98:
         var2 = 8;
         break;
      case 102:
         var2 = 12;
         break;
      case 110:
         var2 = 10;
         break;
      case 114:
         var2 = 13;
         break;
      case 116:
         var2 = 9;
         break;
      case 117:
         var2 = (char)this.func_27450_k(p_27457_1_);
         break;
      default:
         throw new InvalidSyntaxException("Unrecognised escape character [" + var3 + "].", p_27457_1_);
      }

      return var2;
   }

   private int func_27450_k(PositionTrackingPushbackReader p_27450_1_) throws IOException, InvalidSyntaxException {
      char[] var2 = new char[4];
      int var3 = p_27450_1_.func_27336_b(var2);
      if(var3 != 4) {
         throw new InvalidSyntaxException("Expected a 4 digit hexidecimal number but got only [" + var3 + "], namely [" + String.valueOf(var2, 0, var3) + "].", p_27450_1_);
      } else {
         try {
            int var4 = Integer.parseInt(String.valueOf(var2), 16);
            return var4;
         } catch (NumberFormatException var6) {
            p_27450_1_.func_27335_a(var2);
            throw new InvalidSyntaxException("Unable to parse [" + String.valueOf(var2) + "] as a hexidecimal number.", var6, p_27450_1_);
         }
      }
   }

   private int func_27448_l(PositionTrackingPushbackReader p_27448_1_) throws IOException {
      boolean var3 = false;

      int var2;
      do {
         var2 = p_27448_1_.func_27333_c();
         switch(var2) {
         case 9:
         case 10:
         case 13:
         case 32:
            break;
         default:
            var3 = true;
         }
      } while(!var3);

      return var2;
   }
}
