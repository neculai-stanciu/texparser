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
package com.dickimawbooks.texparserlib;

import java.io.IOException;
import java.util.Vector;

public class AssignedActiveChar extends ActiveChar
{
   public AssignedActiveChar(int charCode, TeXObject underlying)
   {
      this.charCode = charCode;
      this.underlying = underlying;

      if (underlying instanceof Macro)
      {
         Macro macro = (Macro)underlying;

         setAllowsPrefix(macro.getAllowsPrefix());
         setShort(macro.isShort());
         setSyntax(macro.getSyntax());
      }
   }

   public int getCharCode()
   {
      return charCode;
   }

   public Object clone()
   {
      return new AssignedActiveChar(getCharCode(), 
        (TeXObject)underlying.clone());
   }

   public boolean isPar()
   {
      return underlying.isPar();
   }

   public void setPrefix(byte prefix)
   {
      if (underlying instanceof Macro)
      {
         Macro macro = (Macro)underlying;

         macro.setPrefix(prefix);
         super.setPrefix(prefix);
      }
   }

   public void clearPrefix()
   {
      if (underlying instanceof Macro)
      {
         ((Macro)underlying).clearPrefix();
         super.clearPrefix();
      }
   }

   public boolean equals(Object obj)
   {
      if (obj == null || !(obj instanceof TeXObject))
      {
         return false;
      }

      if (obj instanceof AssignedMacro)
      {
         return underlying.equals(((AssignedMacro)obj).getUnderlying());
      }

      return underlying.equals(obj);
   }

   public void process(TeXParser parser)
      throws IOException
   {
      underlying.process(parser);
   }

   public void process(TeXParser parser, TeXObjectList stack)
      throws IOException
   {
      underlying.process(parser, stack);
   }

   public TeXObjectList expandonce(TeXParser parser)
      throws IOException
   {
      if (!(underlying instanceof Expandable))
      {
         return null;
      }

      return ((Expandable)underlying).expandonce(parser);
   }

   public TeXObjectList expandonce(TeXParser parser, TeXObjectList stack)
      throws IOException
   {
      if (!(underlying instanceof Expandable))
      {
         return null;
      }

      return ((Expandable)underlying).expandonce(parser, stack);
   }

   public TeXObjectList expandfully(TeXParser parser)
      throws IOException
   {
      if (!(underlying instanceof Expandable))
      {
         return null;
      }

      return ((Expandable)underlying).expandfully(parser);
   }

   public TeXObjectList expandfully(TeXParser parser, TeXObjectList stack)
      throws IOException
   {
      if (!(underlying instanceof Expandable))
      {
         return null;
      }

      return ((Expandable)underlying).expandfully(parser, stack);
   }

   public String toString(TeXParser parser)
   {
      return toString();
   }

   public String toString()
   {
      return new String(Character.toChars(charCode));
   }

   public TeXObjectList string(TeXParser parser)
     throws IOException
   {
      TeXObjectList list = new TeXObjectList();
      list.add(parser.getListener().getOther(charCode));
      return list;
   }

   private TeXObject underlying;
   private int charCode;
}
