
object Test {
  //class Test{
  /* 这是我的第一个 Scala 程序
  * 以下程序将输出'Hello World!'
  */
  def main(args: Array[String]): Unit = {
    val sites = "baidu" :: ("ali" :: ("tencent" :: Nil))
    println("第一个网站是：" + sites.head)
    println("最后一个网站是 ：" + sites.tail)
    println("列表是否为空：" + sites.isEmpty)

    val ir = sites.tails
    for (i <- ir) {
      println(i)
    }
  }

  class Inner {
    def f() {
      println("vvf")
    }

    class InnerMost {
      f() // 正确
    }

  }

  (new Inner).f() // 正
}