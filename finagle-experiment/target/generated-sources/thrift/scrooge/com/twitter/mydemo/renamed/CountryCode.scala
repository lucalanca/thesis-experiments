/**
 * generated by Scrooge 3.1.1
 */
package com.twitter.mydemo.renamed

import com.twitter.scrooge.ThriftEnum


@javax.annotation.Generated(value = Array("com.twitter.scrooge.Compiler"), date = "2013-05-31T12:34:38.929+0100")
case object CountryCode {
  
  case object Es extends CountryCode {
    val value = 0
    val name = "Es"
  }

  /**
   * Find the enum by its integer value, as defined in the Thrift IDL.
   * @throws NoSuchElementException if the value is not found.
   */
  def apply(value: Int): CountryCode = {
    value match {
      case 0 => Es
      case _ => throw new NoSuchElementException(value.toString)
    }
  }

  /**
   * Find the enum by its integer value, as defined in the Thrift IDL.
   * Returns None if the value is not found
   */
  def get(value: Int): Option[CountryCode] = {
    value match {
      case 0 => scala.Some(Es)
      case _ => scala.None
    }
  }

  def valueOf(name: String): Option[CountryCode] = {
    name.toLowerCase match {
      case "es" => scala.Some(CountryCode.Es)
      case _ => scala.None
    }
  }
}



@javax.annotation.Generated(value = Array("com.twitter.scrooge.Compiler"), date = "2013-05-31T12:34:38.929+0100")
sealed trait CountryCode extends ThriftEnum with Serializable