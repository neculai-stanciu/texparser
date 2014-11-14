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
package com.dickimawbooks.texparserlib.latex;

import java.io.IOException;
import java.util.Vector;

import com.dickimawbooks.texparserlib.*;

public abstract class LaTeXFloat extends Declaration
{
   public LaTeXFloat(String name)
   {
      super(name);
   }

   public TeXObjectList expandonce(TeXParser parser, TeXObjectList list)
      throws IOException
   {
      return null;
   }

   public TeXObjectList expandonce(TeXParser parser)
      throws IOException
   {
      return null;
   }

   public TeXObjectList expandfully(TeXParser parser, TeXObjectList list)
      throws IOException
   {
      return null;
   }

   public TeXObjectList expandfully(TeXParser parser)
      throws IOException
   {
      return null;
   }

   public boolean isModeSwitcher()
   {
      return false;
   }

   public void process(TeXParser parser, TeXObjectList stack)
   throws IOException
   {
      TeXObject arg = stack.popArg(parser, '[', ']');
      String placement = null;

      if (arg != null)
      {
         if (arg instanceof Expandable)
         {
            TeXObjectList expanded = ((Expandable)arg).expandfully(parser, stack);

            if (expanded != null)
            {
               arg = expanded;
            }
         }

         placement = arg.toString(parser);
      }

      parser.putControlSequence(true, 
         new GenericCommand("@captype", null, new TeXObjectList(getName())));

      startFloat(placement, parser, stack);
   }

   public void process(TeXParser parser)
   throws IOException
   {
      TeXObject arg = parser.popNextArg('[', ']');
      String placement = null;

      if (arg != null)
      {
         if (arg instanceof Expandable)
         {
            TeXObjectList expanded = ((Expandable)arg).expandfully(parser);

            if (expanded != null)
            {
               arg = expanded;
            }
         }

         placement = arg.toString(parser);
      }

      parser.putControlSequence(true, 
         new GenericCommand("@captype", null, new TeXObjectList(getName())));

      startFloat(placement, parser);
   }

   public abstract void startFloat(String placement, TeXParser parser, 
     TeXObjectList stack)
   throws IOException;

   public abstract void startFloat(String placement, TeXParser parser)
   throws IOException;
}
