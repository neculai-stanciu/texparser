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
package com.dickimawbooks.texparserlib.bib;

import com.dickimawbooks.texparserlib.TeXSyntaxException;
import com.dickimawbooks.texparserlib.TeXParser;

public class BibTeXSyntaxException extends TeXSyntaxException
{
   public BibTeXSyntaxException(TeXParser parser, String errorTag, String param)
   {
      super(parser, errorTag, param);
   }

   public BibTeXSyntaxException(TeXParser parser, String errorTag, String[] params)
   {
      super(parser, errorTag, params);
   }

   public BibTeXSyntaxException(TeXParser parser, String errorTag,
      String param, Throwable cause)
   {
      super(parser, errorTag, param, cause);
   }

   public BibTeXSyntaxException(TeXParser parser, String errorTag,
      String[] params, Throwable cause)
   {
      super(parser, errorTag, params, cause);
   }

   public BibTeXSyntaxException(TeXParser parser, String errorTag)
   {
      super(parser, errorTag);
   }

   public BibTeXSyntaxException(TeXParser parser, String errorTag,
     Throwable cause)
   {
      super(parser, errorTag, cause);
   }

   public static final String ERROR_MISSING_VALUE = 
      "bibtex.error.missing_value";
   public static final String ERROR_EXPECTING = 
      "bibtex.error.expecting";
   public static final String ERROR_EXPECTING_OR = 
      "bibtex.error.expecting_or";
   public static final String ERROR_MISSING_FIELD_PART = 
      "bibtex.error.missing_field_part";
   public static final String ERROR_MISSING_FIELD_NAME = 
      "bibtex.error.missing_field_name";
   public static final String ERROR_UNBALANCED_BRACES = 
      "bibtex.error.unbalanced_braces";
   public static final String ERROR_IMMEDIATELY_FOLLOWS_ENTRY_TYPE = 
      "bibtex.error.immediately_follows_entry_type";
   public static final String ERROR_IMMEDIATELY_FOLLOWS_FIELD_NAME = 
      "bibtex.error.immediately_follows_field_name";
   public static final String ERROR_IMMEDIATELY_FOLLOWS_STRING_NAME = 
      "bibtex.error.immediately_follows_string_name";
   public static final String ERROR_ILLEGAL_END = 
      "bibtex.error.illegal_end";
   public static final String ERROR_MISSING = 
      "bibtex.error.missing";
}