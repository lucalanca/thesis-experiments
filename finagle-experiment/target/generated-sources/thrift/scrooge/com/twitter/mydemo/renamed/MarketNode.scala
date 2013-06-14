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


object MarketNode extends ThriftStructCodec3[MarketNode] {
  val Struct = new TStruct("MarketNode")
  val IdField = new TField("id", TType.STRING, 1)
  val DescriptionField = new TField("description", TType.STRUCT, 2)
  val IsMarketDataDelayedField = new TField("isMarketDataDelayed", TType.BOOL, 3)
  val StateField = new TField("state", TType.STRUCT, 4)

  /**
   * Checks that all required fields are non-null.
   */
  def validate(_item: MarketNode) {
  }

  override def encode(_item: MarketNode, _oproto: TProtocol) { _item.write(_oproto) }
  override def decode(_iprot: TProtocol) = Immutable.decode(_iprot)

  def apply(_iprot: TProtocol): MarketNode = decode(_iprot)

  def apply(
    id: String,
    description: MarketDescriptor,
    isMarketDataDelayed: Boolean,
    state: MarketState
  ): MarketNode = new Immutable(
    id,
    description,
    isMarketDataDelayed,
    state
  )

  def unapply(_item: MarketNode): Option[Product4[String, MarketDescriptor, Boolean, MarketState]] = Some(_item)

  object Immutable extends ThriftStructCodec3[MarketNode] {
    override def encode(_item: MarketNode, _oproto: TProtocol) { _item.write(_oproto) }
    override def decode(_iprot: TProtocol) = {
      var id: String = null
      var _got_id = false
      var description: MarketDescriptor = null
      var _got_description = false
      var isMarketDataDelayed: Boolean = false
      var _got_isMarketDataDelayed = false
      var state: MarketState = null
      var _got_state = false
      var _done = false
      _iprot.readStructBegin()
      while (!_done) {
        val _field = _iprot.readFieldBegin()
        if (_field.`type` == TType.STOP) {
          _done = true
        } else {
          _field.id match {
            case 1 => { /* id */
              _field.`type` match {
                case TType.STRING => {
                  id = {
                    _iprot.readString()
                  }
                  _got_id = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 2 => { /* description */
              _field.`type` match {
                case TType.STRUCT => {
                  description = {
                    com.twitter.mydemo.renamed.MarketDescriptor.decode(_iprot)
                  }
                  _got_description = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 3 => { /* isMarketDataDelayed */
              _field.`type` match {
                case TType.BOOL => {
                  isMarketDataDelayed = {
                    _iprot.readBool()
                  }
                  _got_isMarketDataDelayed = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 4 => { /* state */
              _field.`type` match {
                case TType.STRUCT => {
                  state = {
                    com.twitter.mydemo.renamed.MarketState.decode(_iprot)
                  }
                  _got_state = true
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
        id,
        description,
        isMarketDataDelayed,
        state
      )
    }
  }

  /**
   * The default read-only implementation of MarketNode.  You typically should not need to
   * directly reference this class; instead, use the MarketNode.apply method to construct
   * new instances.
   */
  class Immutable(
    val id: String,
    val description: MarketDescriptor,
    val isMarketDataDelayed: Boolean,
    val state: MarketState
  ) extends MarketNode

  /**
   * This Proxy trait allows you to extend the MarketNode trait with additional state or
   * behavior and implement the read-only methods from MarketNode using an underlying
   * instance.
   */
  trait Proxy extends MarketNode {
    protected def _underlying_MarketNode: MarketNode
    def id: String = _underlying_MarketNode.id
    def description: MarketDescriptor = _underlying_MarketNode.description
    def isMarketDataDelayed: Boolean = _underlying_MarketNode.isMarketDataDelayed
    def state: MarketState = _underlying_MarketNode.state
  }
}

trait MarketNode extends ThriftStruct
  with Product4[String, MarketDescriptor, Boolean, MarketState]
  with java.io.Serializable
{
  import MarketNode._

  def id: String
  def description: MarketDescriptor
  def isMarketDataDelayed: Boolean
  def state: MarketState

  def _1 = id
  def _2 = description
  def _3 = isMarketDataDelayed
  def _4 = state

  override def write(_oprot: TProtocol) {
    MarketNode.validate(this)
    _oprot.writeStructBegin(Struct)
    if (true) {
      val id_item = id
      _oprot.writeFieldBegin(IdField)
      _oprot.writeString(id_item)
      _oprot.writeFieldEnd()
    }
    if (true) {
      val description_item = description
      _oprot.writeFieldBegin(DescriptionField)
      description_item.write(_oprot)
      _oprot.writeFieldEnd()
    }
    if (true) {
      val isMarketDataDelayed_item = isMarketDataDelayed
      _oprot.writeFieldBegin(IsMarketDataDelayedField)
      _oprot.writeBool(isMarketDataDelayed_item)
      _oprot.writeFieldEnd()
    }
    if (true) {
      val state_item = state
      _oprot.writeFieldBegin(StateField)
      state_item.write(_oprot)
      _oprot.writeFieldEnd()
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    id: String = this.id, 
    description: MarketDescriptor = this.description, 
    isMarketDataDelayed: Boolean = this.isMarketDataDelayed, 
    state: MarketState = this.state
  ): MarketNode = new Immutable(
    id, 
    description, 
    isMarketDataDelayed, 
    state
  )

  override def canEqual(other: Any): Boolean = other.isInstanceOf[MarketNode]

  override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)

  override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)

  override def toString: String = runtime.ScalaRunTime._toString(this)


  override def productArity: Int = 4

  override def productElement(n: Int): Any = n match {
    case 0 => id
    case 1 => description
    case 2 => isMarketDataDelayed
    case 3 => state
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix: String = "MarketNode"
}