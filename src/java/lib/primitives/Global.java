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
package com.dickimawbooks.texparserlib.primitives;

import java.io.IOException;

import com.dickimawbooks.texparserlib.*;

public class Global extends Primitive
{
   public Global()
   {
      this("global");
   }

   public Global(String name)
   {
      super(name);
   }

   public Object clone()
   {
      return new Global(getName());
   }

   public void process(TeXParser parser, TeXObjectList stack)
      throws IOException
   {
      TeXObject object = stack.popToken(TeXObjectList.POP_IGNORE_LEADING_SPACE);

      if (object instanceof TeXCsRef)
      {
         object = parser.getListener().getControlSequence(
           ((TeXCsRef)object).getName());
      }

      if (object instanceof Macro)
      {
         ((Macro)object).setPrefix(Macro.PREFIX_GLOBAL);

         if (parser == stack)
         {
            object.process(parser);
         }
         else
         {
            object.process(parser, stack);
         }

         ((Macro)object).clearPrefix();
      }
      else
      {
         stack.push(object);
      }
   }

   public void process(TeXParser parser)
      throws IOException
   {
      process(parser, parser);
   }
}