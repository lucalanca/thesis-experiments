/**
 * generated by Scrooge 3.1.1
 */
package com.twitter.mydemo.renamed

import com.twitter.scrooge.ThriftEnum


@javax.annotation.Generated(value = Array("com.twitter.scrooge.Compiler"), date = "2013-05-31T12:34:38.929+0100")
case object MarketType {
  
  case object MatchOdds extends MarketType {
    val value = 0
    val name = "MatchOdds"
  }

  /**
   * Find the enum by its integer value, as defined in the Thrift IDL.
   * @throws NoSuchElementException if the value is not found.
   */
  def apply(value: Int): MarketType = {
    value match {
      case 0 => MatchOdds
      case _ => throw new NoSuchElementException(value.toString)
    }
  }

  /**
   * Find the enum by its integer value, as defined in the Thrift IDL.
   * Returns None if the value is not found
   */
  def get(value: Int): Option[MarketType] = {
    value match {
      case 0 => scala.Some(MatchOdds)
      case _ => scala.None
    }
  }

  def valueOf(name: String): Option[MarketType] = {
    name.toLowerCase match {
      case "matchodds" => scala.Some(MarketType.MatchOdds)
      case _ => scala.None
    }
  }
}



@javax.annotation.Generated(value = Array("com.twitter.scrooge.Compiler"), date = "2013-05-31T12:34:38.929+0100")
sealed trait MarketType extends ThriftEnum with Serializable