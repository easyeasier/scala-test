package base

/**
  * 类和集合相关的基本内容测试
  */
object BaseTest2 {

  def clzTest(): Unit = {
    val clz = new ClassTest(1, 2)
    clz.callAdd(3, 4)
    clz.callAdd2(3, 4)
  }

  def clzExtendsTest(): Unit = {
    val clz = new Location(1, 2, 3)
    clz.move(2, 3, 4)
  }

  /**
    * List测试 ：
    * :: 元素连接操作符
    * :::集合连接操作符
    */
  def listTest(): Unit = {
    val l1 = List(1, 2, 3)
    println(l1)
    val l2 = 0 :: l1 // l1必须在后面
    println(l2)

    val l3 = "a" :: "b" :: "c" :: Nil //必须有Nil（null）。其实过程就是从后向前连接。 c::Nil先
    println(l3)

    val l4 = l1 ::: l2 //l3是List[Any]类型
    println(l4)
  }

  /**
    * 遍历列表
    *
    * @param l
    * @return
    */
  def listTest2(l: List[String]): String = {
    if (l.nonEmpty) {
      return l.head.toString() + " " + listTest2(l.tail) //l.head第一个元素 。l.tail除第一个元素剩余的列表
    }
    return ""
  }

  /**
    * list的一些高阶函数使用
    */
  def listTest3(): Unit = {
    val l = "abc123".toList
    println("l1 = " + l)

    val l2 = l.filter(x => !x.equals('a'))
    println("l2 = " + l2)

    val l3 = l.takeWhile(x => x != 'b')
    println("l3 = " + l3)

    val l4 = l.map(x => x.toUpper) //map用于改变映射
    println("l4 = " + l4)

    val l5 = l.map(_.toUpper)
    println("l5 = " + l5) //跟l4相同功效

    println("l1 = " + l)
  }

  def listTest4(): Unit = {
    val l = List(List(1, 2), List(3, 4))

    val l2 = l.map(_.filter(_ % 2 == 0)) //List(List(2), List(4))
    println(l2)

    val l3 = l.flatMap(_.filter(_ % 2 == 0)) //List(2, 4) 拉平
    println(l3)
  }

  /**
    * List 高阶函数的使用
    */
  def listTest5(): Unit = {
    val l = List(1, 2)

    val add1 = l.reduceLeft((x, y) => x + y)
    val add2 = l.reduceLeft(_ + _)
    val add3 = l.reduceRight((x, y) => x + y)
    val add4 = l.reduceRight(_ + _)

    println(add1);
    println(add2);
    println(add3);
    println(add4)

    val add5 = l.foldLeft(0)(_ + _)
    val multiply = l.foldLeft(1)(_ * _) //柯里化方式()(). 第一个参数是初始值，第二个参数是执行的方法
    println(multiply)
  }

  def listTest6(): Unit = {
    val l1 = 1 to 10 //Range 1 to 10
    val l2 = 1 to 10 by 2 //步长为2. Range(1,3,5,7,9)
    val l3 = (1 to 10).toList //List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val l4 = 1 until 10 //Range 1 until 10 ，不包含10

    println(l1);
    println(l2);
    println(l3);
    println(l4);
  }

  /**
    * stream惰性求值
    */
  def streamTest(): Unit = {
    val sm = (1 to 10000).toStream
    println(sm) //Stream(1, ?)
    println(sm.head) //1
    println(sm.tail) //Stream(2, ?)
  }

  /**
    * 元祖：就和数据库中表结构一样，一行就是一个元祖
    */
  def toupeTest(): Unit = {
    val t = (1, "wz", "math", "123") //定义一个元祖
    println(t._1, t._2, t._3, t._4)
  }

  def mapTest(): Unit = {
    val map = Map(1 -> "wz", 2 -> "zq")
    println(map(1), map(2))
    println(map.contains(1))

    val keyset = map.keys
    val valueset = map.values
    println(keyset);
    println(valueset)

    val mapF = map + (3 -> "baby") //不是在map中直接加入，是生成一个新的map
    println(mapF)

    println(mapF ++ List(4 -> "o1", 5 -> "o2")) //添加多个值
    println(mapF -- List(4, 5)) //减少多个值


  }

  def main(args: Array[String]): Unit = {
    //    listTest()
    //    listTest6()
    //    println(listTest2(List("a","b","c")))
    mapTest
  }
}

/**
  * 1.一个文件中可以有多个类，且不声明为public
  * 2.类参数 caa,和cab可以在类的任何位置调用
  */
class ClassTest(caa: Int, cab: Int) {
  var a: Int = caa;
  var b: Int = cab;

  def callAdd(x: Int, y: Int): Unit = {
    println("a + x = " + (a + x))
    println("b + y = " + (b + y))
  }

  def callAdd2(x: Int, y: Int): Unit = {
    println("caa + x = " + (caa + x))
    println("cab + y = " + (cab + y))
  }
}

class Point(xc: Int, yc: Int) {
  var x: Int = xc
  var y: Int = yc

  def move(dx: Int, dy: Int) {
    x = x + dx
    y = y + dy
    println("x 的坐标点: " + x);
    println("y 的坐标点: " + y);
  }
}

class Location(val xc: Int, val yc: Int,
               val zc: Int) extends Point(xc, yc) {
  var z: Int = zc

  def move(dx: Int, dy: Int, dz: Int) {
    x = x + dx
    y = y + dy
    z = z + dz
    println("x 的坐标点 : " + x);
    println("y 的坐标点 : " + y);
    println("z 的坐标点 : " + z);
  }
}
