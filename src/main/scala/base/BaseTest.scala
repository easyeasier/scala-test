package base

/**
  * 基本的语法和类型测试
  */
object BaseTest {

  def mapTest() {
    var colors = Map("red" -> "#FF0000",
      "peru" -> "#CD853F")

    colors += ("black" -> "ssdfad")

    println("color 中的键为：" + colors.keys)
    println("color 中的值为 ：" + colors.values)

    println("colors 是否为空：" + colors.isEmpty)
  }

  def iteratorTest(): Unit = {
    val list = List(1, 2, 3)
    val it = list.iterator
    while (it.hasNext) {
      println(it.next())
    }

    val it2 = Iterator("a", "b", "c")
    while (it2.hasNext) {
      println(it2.next())
    }
  }

  def ioConsoleTest(): Unit = {
    val str = Console.readLine()
    println("您的输入是 ： " + str)

  }

  def setDiffLevelValue(): Unit = {
    val x: Float = 10.0f
    val y: Double = x
    //    val z :Float = y  不能像低阶直接赋值，会报错

    println(x + " " + y)
  }

  /**
    * 字符串差值特性。 s不能丢
    */
  def strExpTest(): Unit = {
    val name = "wangzhuang"
    println(s"my name is ${name}")
  }

  /**
    * 可直接忽略返回值类型
    *
    * @param name
    * @return
    */
  def ignoreReturnType(name: String) = {
    s"my name is ${name}"
  }

  /**
    * 当代码块只有一行内容时，可省略{}（brace）
    *
    * @param x
    * @param y
    * @return
    */
  def ignoreBrace(x: Int, y: Int) = x + y

  def ignoreBrace2(x: Int, y: Int): Int = return x + y

  /**
    * for comprehension的几种用法
    */
  def forTest(): Unit = {
    val l = List("a", "ab", "abc")

    //遍历l
    for {
      x <- l //generator
    } println(x)

    //遍历加过滤
    for {x <- l
         if (x.length > 2) //filter
    }
      println(x)

    // if和y 两行可以交换.返回的是一个新的 数组！！
    var result_for = for {x <- l
                          if (x.length > 1)
                          y = x.toUpperCase
    } yield (y)

    println(result_for)
  }

  /**
    * try-catch-finally是个表达式，可以有返回值
    * _是通配符，能匹配任意对象
    */
  def tryCatchTest(): Unit = {
    val i = try {
      Integer.parseInt("a")
    } catch {
      case _ => 0
    } finally {
      println("final ending")
    }

    println(i)
  }

  /**
    * match 匹配，java中的switch
    * 不同的是，匹配到"1"之后，后面的不再继续执行
    */
  def matchTest(arg: String): Unit = {
    arg match {
      case "1" => println("one")
      case "3" =>  println("one")
      case "2" => println("two")
      case _ => println("any..")
    }
  }

  /**
    * 1.函数可以作为参数，变量赋值，跟变量一样
    * 2.函数类型 ：形如 （x: Int）=> x+1
    * 3.在此例中，innerFun 右边是匿名函数
    */
  def funTest(fun : (Int) => Int) :Unit= {
//    var innerFun = (name: String) => "hello " + name
    def innerFun() = (name: String) => "hello " + name //效果和上面相同，但调用的时候需要（）！！
//    println(innerFun("wz"))
    println(innerFun()("wz"))
    println(fun(2))
  }

  def main(args: Array[String]): Unit = {
    //    strExpTest
    //    println(ignoreReturnType("wangz"))

    //    println(ignoreBrace(1, 2))
    //    println(ignoreBrace2(3, 4))
    //    tryCatchTest
//    matchTest("3")
    funTest((a:Int) => a+1)
  }


}

