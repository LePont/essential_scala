package ch4

object JSONOps {

  sealed trait Json{
    def print: String = {

      def addQuotes(str: String) ={
        '"'.toString ++ str ++ '"'.toString
      }

      def seqToJson(s: SeqItem): String = {
        s match {
          case SeqItem(h, t @ SeqItem(_, _)) => s"${h.print}, ${seqToJson(t)}"
          case SeqItem(h, SeqEnd) => h.print
        }
      }

      def objToJson(o: ObjSeq): String = {
        o match {
          case ObjSeq(k, v, t @ ObjSeq(_, _, _)) => s"${addQuotes(k)}: ${v.print}, ${objToJson(t)}"
          case ObjSeq(k, v, ObjEnd) => s"${addQuotes(k)}: ${v.print}"
        }
      }

      this match {
        case JSDouble(n) => n.toString
        case JSString(s) => addQuotes(s)
        case JSBoolean(b) => b.toString
        case JSNull => "null"
        case s @ SeqItem(_, _) => "[" ++ seqToJson(s) ++ "]"
        case SeqEnd => "[]"
        case o @ ObjSeq(_, _, _) => "{" ++ objToJson(o) ++ "}"
        case ObjEnd => "{}"
      }
    }
  }

  final case class JSDouble(d: Double) extends Json
  final case class JSString(s: String) extends Json
  final case class JSBoolean(b: Boolean) extends Json
  final case object JSNull extends Json

  sealed trait JSSeq extends Json
  final case class SeqItem(h: Json, t: JSSeq) extends JSSeq
  final case object SeqEnd extends JSSeq

  sealed trait JSObj extends Json
  final case class ObjSeq(key: String, value: Json, tail: JSObj) extends JSObj
  final case object ObjEnd extends JSObj
}
