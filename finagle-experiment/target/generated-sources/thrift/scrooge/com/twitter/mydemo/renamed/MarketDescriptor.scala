/**
 * generated by Scrooge 3.1.1
 */
package com.twitter.mydemo.renamed

import com.twitter.scrooge.{ThriftException, ThriftStruct, ThriftStructCodec3}
import org.apache.thrift.protocol._
import java.nio.ByteBuffer
import com.twitter.finagle.SourcedException
import scala.collection.mutable
import scala.collection.{Map, Set}


object MarketDescriptor extends ThriftStructCodec3[MarketDescriptor] {
  val Struct = new TStruct("MarketDescriptor")
  val BettingTypeField = new TField("bettingType", TType.I32, 1)
  val BspMarketField = new TField("bspMarket", TType.BOOL, 2)
  val MarketNameField = new TField("marketName", TType.STRING, 3)
  val MarketTimeField = new TField("marketTime", TType.STRING, 4)
  val MarketTypeField = new TField("marketType", TType.I32, 5)
  val PersistenceEnabledField = new TField("persistenceEnabled", TType.BOOL, 6)
  val SuspendTimeField = new TField("suspendTime", TType.STRING, 7)
  val TurnInPlayEnabledField = new TField("turnInPlayEnabled", TType.BOOL, 8)

  /**
   * Checks that all required fields are non-null.
   */
  def validate(_item: MarketDescriptor) {
  }

  override def encode(_item: MarketDescriptor, _oproto: TProtocol) { _item.write(_oproto) }
  override def decode(_iprot: TProtocol) = Immutable.decode(_iprot)

  def apply(_iprot: TProtocol): MarketDescriptor = decode(_iprot)

  def apply(
    bettingType: BettingType,
    bspMarket: Boolean,
    marketName: String,
    marketTime: String,
    marketType: MarketType,
    persistenceEnabled: Boolean,
    suspendTime: String,
    turnInPlayEnabled: Boolean
  ): MarketDescriptor = new Immutable(
    bettingType,
    bspMarket,
    marketName,
    marketTime,
    marketType,
    persistenceEnabled,
    suspendTime,
    turnInPlayEnabled
  )

  def unapply(_item: MarketDescriptor): Option[Product8[BettingType, Boolean, String, String, MarketType, Boolean, String, Boolean]] = Some(_item)

  object Immutable extends ThriftStructCodec3[MarketDescriptor] {
    override def encode(_item: MarketDescriptor, _oproto: TProtocol) { _item.write(_oproto) }
    override def decode(_iprot: TProtocol) = {
      var bettingType: BettingType = null
      var _got_bettingType = false
      var bspMarket: Boolean = false
      var _got_bspMarket = false
      var marketName: String = null
      var _got_marketName = false
      var marketTime: String = null
      var _got_marketTime = false
      var marketType: MarketType = null
      var _got_marketType = false
      var persistenceEnabled: Boolean = false
      var _got_persistenceEnabled = false
      var suspendTime: String = null
      var _got_suspendTime = false
      var turnInPlayEnabled: Boolean = false
      var _got_turnInPlayEnabled = false
      var _done = false
      _iprot.readStructBegin()
      while (!_done) {
        val _field = _iprot.readFieldBegin()
        if (_field.`type` == TType.STOP) {
          _done = true
        } else {
          _field.id match {
            case 1 => { /* bettingType */
              _field.`type` match {
                case TType.I32 => {
                  bettingType = {
                    com.twitter.mydemo.renamed.BettingType(_iprot.readI32())
                  }
                  _got_bettingType = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 2 => { /* bspMarket */
              _field.`type` match {
                case TType.BOOL => {
                  bspMarket = {
                    _iprot.readBool()
                  }
                  _got_bspMarket = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 3 => { /* marketName */
              _field.`type` match {
                case TType.STRING => {
                  marketName = {
                    _iprot.readString()
                  }
                  _got_marketName = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 4 => { /* marketTime */
              _field.`type` match {
                case TType.STRING => {
                  marketTime = {
                    _iprot.readString()
                  }
                  _got_marketTime = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 5 => { /* marketType */
              _field.`type` match {
                case TType.I32 => {
                  marketType = {
                    com.twitter.mydemo.renamed.MarketType(_iprot.readI32())
                  }
                  _got_marketType = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 6 => { /* persistenceEnabled */
              _field.`type` match {
                case TType.BOOL => {
                  persistenceEnabled = {
                    _iprot.readBool()
                  }
                  _got_persistenceEnabled = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 7 => { /* suspendTime */
              _field.`type` match {
                case TType.STRING => {
                  suspendTime = {
                    _iprot.readString()
                  }
                  _got_suspendTime = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 8 => { /* turnInPlayEnabled */
              _field.`type` match {
                case TType.BOOL => {
                  turnInPlayEnabled = {
                    _iprot.readBool()
                  }
                  _got_turnInPlayEnabled = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case _ => TProtocolUtil.skip(_iprot, _field.`type`)
          }
          _iprot.readFieldEnd()
        }
      }
      _iprot.readStructEnd()
      new Immutable(
        bettingType,
        bspMarket,
        marketName,
        marketTime,
        marketType,
        persistenceEnabled,
        suspendTime,
        turnInPlayEnabled
      )
    }
  }

  /**
   * The default read-only implementation of MarketDescriptor.  You typically should not need to
   * directly reference this class; instead, use the MarketDescriptor.apply method to construct
   * new instances.
   */
  class Immutable(
    val bettingType: BettingType,
    val bspMarket: Boolean,
    val marketName: String,
    val marketTime: String,
    val marketType: MarketType,
    val persistenceEnabled: Boolean,
    val suspendTime: String,
    val turnInPlayEnabled: Boolean
  ) extends MarketDescriptor

  /**
   * This Proxy trait allows you to extend the MarketDescriptor trait with additional state or
   * behavior and implement the read-only methods from MarketDescriptor using an underlying
   * instance.
   */
  trait Proxy extends MarketDescriptor {
    protected def _underlying_MarketDescriptor: MarketDescriptor
    def bettingType: BettingType = _underlying_MarketDescriptor.bettingType
    def bspMarket: Boolean = _underlying_MarketDescriptor.bspMarket
    def marketName: String = _underlying_MarketDescriptor.marketName
    def marketTime: String = _underlying_MarketDescriptor.marketTime
    def marketType: MarketType = _underlying_MarketDescriptor.marketType
    def persistenceEnabled: Boolean = _underlying_MarketDescriptor.persistenceEnabled
    def suspendTime: String = _underlying_MarketDescriptor.suspendTime
    def turnInPlayEnabled: Boolean = _underlying_MarketDescriptor.turnInPlayEnabled
  }
}

trait MarketDescriptor extends ThriftStruct
  with Product8[BettingType, Boolean, String, String, MarketType, Boolean, String, Boolean]
  with java.io.Serializable
{
  import MarketDescriptor._

  def bettingType: BettingType
  def bspMarket: Boolean
  def marketName: String
  def marketTime: String
  def marketType: MarketType
  def persistenceEnabled: Boolean
  def suspendTime: String
  def turnInPlayEnabled: Boolean

  def _1 = bettingType
  def _2 = bspMarket
  def _3 = marketName
  def _4 = marketTime
  def _5 = marketType
  def _6 = persistenceEnabled
  def _7 = suspendTime
  def _8 = turnInPlayEnabled

  override def write(_oprot: TProtocol) {
    MarketDescriptor.validate(this)
    _oprot.writeStructBegin(Struct)
    if (true) {
      val bettingType_item = bettingType
      _oprot.writeFieldBegin(BettingTypeField)
      _oprot.writeI32(bettingType_item.value)
      _oprot.writeFieldEnd()
    }
    if (true) {
      val bspMarket_item = bspMarket
      _oprot.writeFieldBegin(BspMarketField)
      _oprot.writeBool(bspMarket_item)
      _oprot.writeFieldEnd()
    }
    if (true) {
      val marketName_item = marketName
      _oprot.writeFieldBegin(MarketNameField)
      _oprot.writeString(marketName_item)
      _oprot.writeFieldEnd()
    }
    if (true) {
      val marketTime_item = marketTime
      _oprot.writeFieldBegin(MarketTimeField)
      _oprot.writeString(marketTime_item)
      _oprot.writeFieldEnd()
    }
    if (true) {
      val marketType_item = marketType
      _oprot.writeFieldBegin(MarketTypeField)
      _oprot.writeI32(marketType_item.value)
      _oprot.writeFieldEnd()
    }
    if (true) {
      val persistenceEnabled_item = persistenceEnabled
      _oprot.writeFieldBegin(PersistenceEnabledField)
      _oprot.writeBool(persistenceEnabled_item)
      _oprot.writeFieldEnd()
    }
    if (true) {
      val suspendTime_item = suspendTime
      _oprot.writeFieldBegin(SuspendTimeField)
      _oprot.writeString(suspendTime_item)
      _oprot.writeFieldEnd()
    }
    if (true) {
      val turnInPlayEnabled_item = turnInPlayEnabled
      _oprot.writeFieldBegin(TurnInPlayEnabledField)
      _oprot.writeBool(turnInPlayEnabled_item)
      _oprot.writeFieldEnd()
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    bettingType: BettingType = this.bettingType, 
    bspMarket: Boolean = this.bspMarket, 
    marketName: String = this.marketName, 
    marketTime: String = this.marketTime, 
    marketType: MarketType = this.marketType, 
    persistenceEnabled: Boolean = this.persistenceEnabled, 
    suspendTime: String = this.suspendTime, 
    turnInPlayEnabled: Boolean = this.turnInPlayEnabled
  ): MarketDescriptor = new Immutable(
    bettingType, 
    bspMarket, 
    marketName, 
    marketTime, 
    marketType, 
    persistenceEnabled, 
    suspendTime, 
    turnInPlayEnabled
  )

  override def canEqual(other: Any): Boolean = other.isInstanceOf[MarketDescriptor]

  override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)

  override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)

  override def toString: String = runtime.ScalaRunTime._toString(this)


  override def productArity: Int = 8

  override def productElement(n: Int): Any = n match {
    case 0 => bettingType
    case 1 => bspMarket
    case 2 => marketName
    case 3 => marketTime
    case 4 => marketType
    case 5 => persistenceEnabled
    case 6 => suspendTime
    case 7 => turnInPlayEnabled
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix: String = "MarketDescriptor"
}