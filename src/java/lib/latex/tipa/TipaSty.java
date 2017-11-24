/*
    Copyright (C) 2013 Nicola L.C. Talbot
    www.dickimaw-books.com

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
*/
package com.dickimawbooks.texparserlib.latex.tipa;

import java.io.IOException;

import com.dickimawbooks.texparserlib.*;
import com.dickimawbooks.texparserlib.latex.*;
import com.dickimawbooks.texparserlib.primitives.Undefined;
import com.dickimawbooks.texparserlib.generic.*;
import com.dickimawbooks.texparserlib.latex.fontenc.FontEncSty;

public class TipaSty extends LaTeXSty
{
   public TipaSty(KeyValList options, LaTeXParserListener listener)
    throws IOException
   {
      super(options, "tipa", listener);
   }

   public void addDefinitions()
   {
      TipaEncoding declaration = new TipaEncoding();
      registerControlSequence(declaration);
      registerControlSequence(new TextBlockCommand("textipa", declaration));

      LaTeXParserListener listener = getListener();

      for (int i = 0; i < SYMBOLS.length; i++)
      {
         registerControlSequence(listener.createSymbol(
           (String)SYMBOLS[i][0], 
           ((Integer)SYMBOLS[i][1]).intValue()));
      }

   }

   public void processOption(String option)
    throws IOException
   {
   }

   protected void preOptions()
     throws IOException
   {
      LaTeXParserListener listener = getListener();

      fontEncSty = listener.getFontEncSty();

      if (fontEncSty == null)
      {
         fontEncSty = (FontEncSty)listener.usepackage(null, "fontenc");
      }

      fontEncSty.registerEncoding(new T3Encoding());
   }

   private static final Object[][] SYMBOLS = new Object[][]
   {
      // 0-9
      new Object[]{"textbaru", new Integer(0x0289)},
      new Object[]{"textbari", new Integer(0x0268)},
      new Object[]{"textturnv", new Integer(0x028C)},
      new Object[]{"textrevepsilon", new Integer(0x025C)},
      new Object[]{"textturnh", new Integer(0x0265)},
      new Object[]{"textturna", new Integer(0x0250)},
      new Object[]{"textturnscripta", new Integer(0x0252)},
      new Object[]{"textramshorns", new Integer(0x0264)},
      new Object[]{"textbaro", new Integer(0x0275)},
      new Object[]{"textreve", new Integer(0x0258)},
      // @
      new Object[]{"textschwa", new Integer(0x0259)},
      // A-Z (doesn't include D: \dh and N: \ng)
      new Object[]{"textscripta", new Integer(0x0251)},
      new Object[]{"textbeta", new Integer(0x03B2)},
      new Object[]{"textctc", new Integer(0x0255)},
      new Object[]{"textepsilon", new Integer(0x025B)},
      new Object[]{"textphi", new Integer(0x0278)},
      new Object[]{"textgamma", new Integer(0x0263)},
      new Object[]{"texthth", new Integer(0x0266)},
      new Object[]{"textsci", new Integer(0x026A)},
      new Object[]{"textctj", new Integer(0x029D)},
      new Object[]{"textinvscr", new Integer(0x0281)},
      new Object[]{"textturny", new Integer(0x028E)},
      new Object[]{"texttailm", new Integer(0x0271)},
      new Object[]{"textopeno", new Integer(0x0254)},
      new Object[]{"textglotstop", new Integer(0x0294)},
      new Object[]{"textrevglotstop", new Integer(0x0295)},
      new Object[]{"textfishhookr", new Integer(0x027E)},
      new Object[]{"textesh", new Integer(0x0283)},
      new Object[]{"texttheta", new Integer(0x03B8)},
      new Object[]{"textupsilon", new Integer(0x028A)},
      new Object[]{"textscriptv", new Integer(0x028B)},
      new Object[]{"textturnm", new Integer(0x026F)},
      new Object[]{"textchi", new Integer(0x03C7)},
      new Object[]{"textscy", new Integer(0x028F)},
      new Object[]{"textyogh", new Integer(0x021D)},

      new Object[]{"textscg", new Integer(0x0262)},// g

      new Object[]{"textprimstress", new Integer(0x02C8)},// "
      new Object[]{"textlengthmark", new Integer(0x02D0)},// :
      new Object[]{"texthalflength", new Integer(0x02D1)},// ;
      new Object[]{"textpipe", new Integer('|')},

      // 224--255
      new Object[]{"textscb", new Integer(0x0299)},//224
      new Object[]{"texthtb", new Integer(0x0253)},//225
      new Object[]{"texthtd", new Integer(0x0257)},//226
      new Object[]{"textrtaild", new Integer(0x0256)},//227
      new Object[]{"texthtg", new Integer(0x0260)},//228
      new Object[]{"textscg", new Integer(0x0262)},//229
      new Object[]{"textcrh", new Integer(0x0127)},//232
      new Object[]{"textbardotlessj", new Integer(0x025F)},//233
      new Object[]{"texthtbardotlessj", new Integer(0x0284)},//234
      new Object[]{"textltilde", new Integer(0x026B)},//235
      new Object[]{"textbeltl", new Integer(0x026C)},//236
      new Object[]{"textrtaill", new Integer(0x026D)},//237
      new Object[]{"textturnmrleg", new Integer(0x0270)},//238
      new Object[]{"textrtailn", new Integer(0x0273)},//239
      new Object[]{"textscn", new Integer(0x0274)},//240
      new Object[]{"textltailn", new Integer(0x0272)},//241
      new Object[]{"textbullseye", new Integer(0x0298)},//242
      new Object[]{"textrtailr", new Integer(0x027D)},//243
      new Object[]{"textturnr", new Integer(0x0279)},//244
      new Object[]{"textturnrrtail", new Integer(0x027B)},//245
      new Object[]{"textscr", new Integer(0x0280)},//246
      new Object[]{"textrtails", new Integer(0x0282)},//249
      new Object[]{"textrtailt", new Integer(0x0288)},//250
      new Object[]{"textturnw", new Integer(0x028D)},//251
      new Object[]{"textrtailz", new Integer(0x0290)},//252
      new Object[]{"textctz", new Integer(0x0291)},//253
      new Object[]{"textthorn", new Integer(0x00FE)},//254
      new Object[]{"texthvlig", new Integer(0x0195)},//255
      // 192--223
   //TODO
   };

   private FontEncSty fontEncSty;
}
