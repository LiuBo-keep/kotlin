# 学习Kotlin

## Kotlin基础

### 函数定义
函数定义使用关键字 fun，参数格式为：参数 : 类型
```kotlin
fun sum(a: Int, b: Int): Int {   // Int 参数，返回值 Int
    return a + b
}
```
表达式作为函数体，返回类型自动推断：
```kotlin
fun sum(a: Int, b: Int) = a + b

public fun sum(a: Int, b: Int): Int = a + b   // public 方法则必须明确写出返回类型
```

无返回值的函数(类似Java中的void)：
```kotlin
fun printSum(a: Int, b: Int): Unit { 
    print(a + b)
}


// 如果是返回 Unit类型，则可以省略(对于public方法也是这样)：
public fun printSum(a: Int, b: Int) { 
    print(a + b)
}
```

#### 可变长参数函数
函数的变长参数可以用 vararg 关键字进行标识：
```kotlin
fun vars(vararg v:Int){
    for(vt in v){
        print(vt)
    }
}

// 测试
fun main(args: Array<String>) {
    vars(1,2,3,4,5)  // 输出12345
}
```

#### lambda(匿名函数)
lambda表达式使用实例：
```kotlin
// 测试
fun main(args: Array<String>) {
    val sumLambda: (Int, Int) -> Int = {x,y -> x+y}
    println(sumLambda(1,2))  // 输出 3
}
```

### 定义常量与变量
可变变量定义：var 关键字
```kotlin
var <标识符> : <类型> = <初始化值>
```
不可变变量定义：val 关键字，只能赋值一次的变量(类似Java中final修饰的变量)
```kotlin
val <标识符> : <类型> = <初始化值>
```
常量与变量都可以没有初始化值,但是在引用前必须初始化
编译器支持自动类型判断,即声明时可以不指定类型,由编译器判断。
```kotlin
val a: Int = 1
val b = 1       // 系统自动推断变量类型为Int
val c: Int      // 如果不在声明时初始化则必须提供变量类型
c = 1           // 明确赋值


var x = 5        // 系统自动推断变量类型为Int
x += 1           // 变量可修改
```

### 注释
Kotlin 支持单行和多行注释，实例如下：
```kotlin
// 这是一个单行注释

/* 这是一个多行的
   块注释。 */
```
与 Java 不同, Kotlin 中的块注释允许嵌套。

### 字符串模板
$ 表示一个变量名或者变量值
$varName 表示变量值
${varName.fun()} 表示变量的方法返回值:
```kotlin
var a = 1
// 模板中的简单名称：
val s1 = "a is $a" 

a = 2
// 模板中的任意表达式：
val s2 = "${s1.replace("is", "was")}, but now is $a"
```

### NULL检查机制
Kotlin的空安全设计对于声明可为空的参数，在使用时要进行空判断处理，有两种处理方式，字段后加!!像Java一样抛出空异常，
另一种字段后加?可不做处理返回值为 null 或配合 ?: 做空判断处理
```kotlin
//类型后面加?表示可为空
var age: String? = "23" 
//抛出空指针异常
val ages = age!!.toInt()
//不做处理返回 null
val ages1 = age?.toInt()
//age为空返回-1
val ages2 = age?.toInt() ?: -1
```
当一个引用可能为 null 值时, 对应的类型声明必须明确地标记为可为 null。
当 str 中的字符串内容不是一个整数时, 返回 null:
```kotlin
fun parseInt(str: String): Int? {
  // ...
}
```
以下实例演示如何使用一个返回值可为 null 的函数:
```kotlin
fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    // 直接使用 `x * y` 会导致错误, 因为它们可能为 null
    if (x != null && y != null) {
        // 在进行过 null 值检查之后, x 和 y 的类型会被自动转换为非 null 变量
        println(x * y)
    }
    else {
        println("'$arg1' or '$arg2' is not a number")
    }    
}

fun main() {
    printProduct("6", "7")
    printProduct("a", "7")
    printProduct("a", "b")
}
```
或者：
```kotlin
fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)
    
    // ...
    if (x == null) {
        println("Wrong number format in arg1: '$arg1'")
        return
    }
    if (y == null) {
        println("Wrong number format in arg2: '$arg2'")
        return
    }

    // 在进行过 null 值检查之后, x 和 y 的类型会被自动转换为非 null 变量
    println(x * y)
}

fun main() {
    printProduct("6", "7")
    printProduct("a", "7")
    printProduct("99", "b")
}
```

### 类型检测及自动类型转换
我们可以使用 is 运算符检测一个对象是否是指定类型的实例(类似于 Java 中的 instanceof 关键字)。
```kotlin
if (obj is Type) {
    // 如果 obj 是 Type 类型，则可以直接使用 Type 类型的属性和方法
} else {
    // 处理其他类型情况
}
```
当 is 检测通过时，Kotlin 会自动将 obj 视为指定类型，因此在 if 语句的分支内不需要显式地进行类型转换。这被称为智能类型转换。
```kotlin
fun main() {
    val obj: Any = "Hello, Kotlin"

    if (obj is String) {
        println("字符串长度: ${obj.length}") // 在这里 `obj` 已被智能转换为 `String`
    } else {
        println("不是字符串类型")
    }
}
```
在这个例子中，如果 obj 是 String 类型，is 运算符返回 true，Kotlin 会将 obj 识别为 String，这样就可以直接访问 String 
类型的属性和方法。

### 区间
区间表达式由具有操作符形式 .. 的 rangeTo 函数辅以 in 和 !in 形成。
区间是为任何可比较类型定义的，但对于整型原生类型，它有一个优化的实现。以下是使用区间的一些示例:
```kotlin
for (i in 1..4) print(i) // 输出“1234”

for (i in 4..1) print(i) // 什么都不输出

if (i in 1..10) { // 等同于 1 <= i && i <= 10
    println(i)
}

// 使用 step 指定步长
for (i in 1..4 step 2) print(i) // 输出“13”

for (i in 4 downTo 1 step 2) print(i) // 输出“42”


// 使用 until 函数排除结束元素
for (i in 1 until 10) {   // i in [1, 10) 排除了 10
     println(i)
}
```
---
## Kotlin 基本数据类型
Kotlin 的基本数值类型包括 Byte、Short、Int、Long、Float、Double 等。
不同于 Java 的是，字符不属于数值类型，是一个独立的数据类型。
### 整数类型
- Byte: 8 位，范围从 -128 到 127。
- Short: 16 位，范围从 -32,768 到 32,767。
- Int: 32 位，范围从 -2^31 到 2^31 - 1。
- Long: 64 位，范围从 -2^63 到 2^63 - 1。

###  浮点数类型
- Float: 32 位，范围从 1.4E-45 到 3.4E+38。
- Double: 64 位，范围从 4.9E-324 到 1.8E+308。

### 字符类型
- Char: 16 位，表示一个字符。

### 布尔类型
- Boolean: 有两个值：true 和 false。

### 字符串类型
- String: 一系列字符的序列。

### 数组类型
Kotlin 提供了数组类型来存储同种类型的元素，例如：
- IntArray: 存储 Int 类型的数组。
- DoubleArray: 存储 Double 类型的数组。
- Array<T>: 泛型数组，可以存储任意类型。

```kotlin
fun main() {
    // 整数类型
    val byteValue: Byte = 127
    val shortValue: Short = 32767
    val intValue: Int = 2147483647
    val longValue: Long = 9223372036854775807L

    // 浮点数类型
    val floatValue: Float = 3.14F
    val doubleValue: Double = 3.141592653589793

    // 字符类型
    val charValue: Char = 'A'

    // 布尔类型
    val booleanValue: Boolean = true

    // 字符串类型
    val stringValue: String = "Hello, Kotlin!"

    // 数组类型
    val intArray: IntArray = intArrayOf(1, 2, 3, 4, 5)
    val doubleArray: DoubleArray = doubleArrayOf(1.1, 2.2, 3.3)
    val stringArray: Array<String> = arrayOf("Kotlin", "Java", "Python")

    // 打印所有值
    println("Byte Value: $byteValue")
    println("Short Value: $shortValue")
    println("Int Value: $intValue")
    println("Long Value: $longValue")
    println("Float Value: $floatValue")
    println("Double Value: $doubleValue")
    println("Char Value: $charValue")
    println("Boolean Value: $booleanValue")
    println("String Value: $stringValue")
    println("Int Array: ${intArray.joinToString()}")
    println("Double Array: ${doubleArray.joinToString()}")
    println("String Array: ${stringArray.joinToString()}")
}
```

### 字面常量
下面是所有类型的字面常量：
- 十进制：123
- 长整型以大写的 L 结尾：123L
- 16 进制以 0x 开头：0x0F
- 2 进制以 0b 开头：0b00001011
- 注意：8进制不支持

Kotlin 同时也支持传统符号表示的浮点数值：
- Doubles 默认写法: 123.5, 123.5e10
- Floats 使用 f 或者 F 后缀：123.5f

你可以使用下划线使数字常量更易读：
```kotlin
val oneMillion = 1_000_000
val creditCardNumber = 1234_5678_9012_3456L
val socialSecurityNumber = 999_99_9999L
val hexBytes = 0xFF_EC_DE_5E
val bytes = 0b11010010_01101001_10010100_10010010
```

### 比较两个数字
在 Kotlin 中，比较两个数字可以使用标准的比较运算符，包括 ==、!=、<、>、<= 和 >=。这些运算符可以比较基
本数据类型，如 Int、Double、Float 等。
```kotlin
fun main() {
    val a: Int = 5
    val b: Int = 10
    val c: Double = 5.0

    // 相等和不相等比较
    println("a == b: ${a == b}")   // 输出 false
    println("a != b: ${a != b}")   // 输出 true

    // 大小比较
    println("a < b: ${a < b}")     // 输出 true
    println("a > b: ${a > b}")     // 输出 false
    println("a <= b: ${a <= b}")   // 输出 true
    println("a >= b: ${a >= b}")   // 输出 false

    // 不同类型的比较
    println("a == c: ${a == c}")   // 输出 true，Kotlin 自动将 Int 转换为 Double 进行比较
    println("a < c: ${a < c}")     // 输出 false
    println("a > c: ${a > c}")     // 输出 false
}
```
1. **类型转换**：Kotlin 在比较不同数据类型时会自动进行类型转换。例如，上面的例子中，a 是 Int 类型，而 c 是 Double 类型，Kotlin 会自动将 a 转换为 Double 类型进行比较。
2. **相等性**：Kotlin 中 == 运算符用于结构相等性比较，即值的比较，而 === 运算符用于引用相等性比较，即对象是否是同一个实例。在比较基本数据类型时，通常使用 == 运算符。

```kotlin
fun main() {
    val x: Int = 1000
    val y: Int = 1000

    println("x == y: ${x == y}")   // 输出 true，值相等
    println("x === y: ${x === y}") // 输出 false，不同的实例

    val z: Int = x
    println("x === z: ${x === z}") // 输出 true，引用相同
}
```
在这个例子中，x 和 y 的值相等，但它们是不同的实例，因此 x === y 返回 false。但是 x 和 z 引用同一个实例，所以 x === z 返回 true。

### 类型转换
由于不同的表示方式，较小类型并不是较大类型的子类型，较小的类型不能隐式转换为较大的类型。 这意味着在不进行显式转换的情况下我们不能把 Byte 型值赋给一个 Int 变量。
```kotlin
val b: Byte = 1 // OK, 字面值是静态检测的
val i: Int = b // 错误
```
我们可以代用其toInt()方法。
```kotlin
val b: Byte = 1 // OK, 字面值是静态检测的
val i: Int = b.toInt() // OK
```
每种数据类型都有下面的这些方法，可以转化为其它的类型：
```kotlin
toByte(): Byte
toShort(): Short
toInt(): Int
toLong(): Long
toFloat(): Float
toDouble(): Double
toChar(): Char
```
有些情况下也是可以使用自动类型转化的，前提是可以根据上下文环境推断出正确的数据类型而且数学操作符会做相应的重载。例如下面是正确的：
```kotlin
val l = 1L + 3 // Long + Int => Long
```
### 位操作符
对于Int和Long类型，还有一系列的位操作符可以使用，分别是：
```kotlin
shl(bits) – 左移位 (Java’s <<)
shr(bits) – 右移位 (Java’s >>)
ushr(bits) – 无符号右移位 (Java’s >>>)
and(bits) – 与
or(bits) – 或
xor(bits) – 异或
inv() – 反向
```

### 字符
和 Java 不一样，Kotlin 中的 Char 不能直接和数字操作，Char 必需是单引号 ' 包含起来的。比如普通字符 '0'，'a'。
```kotlin
fun check(c: Char) {
    if (c == 1) { // 错误：类型不兼容
        // ……
    }
}
```
字符字面值用单引号括起来: '1'。 特殊字符可以用反斜杠转义。 支持这几个转义序列：\t、 \b、\n、\r、\'、\"、\\ 和 \$。 编码
其他字符要用 Unicode 转义序列语法：'\uFF00'。
我们可以显式把字符转换为 Int 数字：
```kotlin
fun decimalDigitValue(c: Char): Int {
    if (c !in '0'..'9')
        throw IllegalArgumentException("Out of range")
    return c.toInt() - '0'.toInt() // 显式转换为数字
}
```
当需要可空引用时，像数字、字符会被装箱。装箱操作不会保留同一性。

### 布尔
布尔用 Boolean 类型表示，它有两个值：true 和 false。
若需要可空引用布尔会被装箱。
内置的布尔运算有：
```kotlin
|| – 短路逻辑或
&& – 短路逻辑与
! - 逻辑非
```

### 数组
数组用类 Array 实现，并且还有一个 size 属性及 get 和 set 方法，由于使用 [] 重载了 get 和 set 方法，所以我们可以通过下标很方便的获取或者设置数组对应位置的值。
数组的创建两种方式：一种是使用函数arrayOf()；另外一种是使用工厂函数。如下所示，我们分别是两种方式创建了两个数组：
```kotlin
fun main(args: Array<String>) {
    //[1,2,3]
    val a = arrayOf(1, 2, 3)
    //[0,2,4]
    val b = Array(3, { i -> (i * 2) })

    //读取数组内容
    println(a[0])    // 输出结果：1
    println(b[1])    // 输出结果：2
}
```
如上所述，[] 运算符代表调用成员函数 get() 和 set()。
注意: 与 Java 不同的是，Kotlin 中数组是不协变的（invariant）。
除了类Array，还有ByteArray, ShortArray, IntArray，用来表示各个类型的数组，省去了装箱操作，因此效率更高，其用法同Array一样：
```kotlin
val x: IntArray = intArrayOf(1, 2, 3)
x[0] = x[1] + x[2]
```

### 字符串
和 Java 一样，String 是不可变的。方括号 [] 语法可以很方便的获取字符串中的某个字符，也可以通过 for 循环来遍历：
```kotlin
for (c in str) {
    println(c)
}
```
Kotlin 支持三个引号 """ 扩起来的字符串，支持多行字符串，比如：
```kotlin
fun main(args: Array<String>) {
    val text = """
    多行字符串
    多行字符串
    """
    println(text)   // 输出有一些前置空格
}
```
String 可以通过 trimMargin() 方法来删除多余的空白。
```kotlin
fun main(args: Array<String>) {
    val text = """
    |多行字符串
    |菜鸟教程
    |多行字符串
    |Runoob
    """.trimMargin()
    println(text)    // 前置空格删除了
}

```
默认 | 用作边界前缀，但你可以选择其他字符并作为参数传入，比如 trimMargin(">")。

---

## Kotlin 条件控制

### IF 表达式
一个 if 语句包含一个布尔表达式和一条或多条语句。
```kotlin
// 传统用法
var max = a 
if (a < b) max = b

// 使用 else 
var max: Int
if (a > b) {
    max = a
} else {
    max = b
}
 
// 作为表达式
val max = if (a > b) a else b
```
我们也可以把 IF 表达式的结果赋值给一个变量。
````kotlin
val max = if (a > b) {
    print("Choose a")
    a
} else {
    print("Choose b")
    b
}
````
这也说明我也不需要像Java那种有一个三元操作符，因为我们可以使用它来简单实现：
```kotlin
val c = if (condition) a else b
```

### 使用区间
使用 in 运算符来检测某个数字是否在指定区间内，区间格式为 x..y ：
```kotlin
fun main(args: Array<String>) {
    val x = 5
    val y = 9
    if (x in 1..8) {
        println("x 在区间内")
    }
}
```
输出结果为：
x 在区间内

### When 表达式
when 将它的参数和所有的分支条件顺序比较，直到某个分支满足条件。
when 既可以被当做表达式使用也可以被当做语句使用。如果它被当做表达式，符合条件的分支的值就是整个表达式的值，如果当做语句使用， 则忽略个别分支的值。
when 类似其他语言的 switch 操作符。其最简单的形式如下：
```kotlin
when (x) {
    1 -> print("x == 1")
    2 -> print("x == 2")
    else -> { // 注意这个块
        print("x 不是 1 ，也不是 2")
    }
}
```
在 when 中，else 同 switch 的 default。如果其他分支都不满足条件将会求值 else 分支。
如果很多分支需要用相同的方式处理，则可以把多个分支条件放在一起，用逗号分隔：
```kotlin
when (x) {
    0, 1 -> print("x == 0 or x == 1")
    else -> print("otherwise")
}
```
我们也可以检测一个值在（in）或者不在（!in）一个区间或者集合中：
```kotlin
when (x) {
    in 1..10 -> print("x is in the range")
    in validNumbers -> print("x is valid")
    !in 10..20 -> print("x is outside the range")
    else -> print("none of the above")
}
```
另一种可能性是检测一个值是（is）或者不是（!is）一个特定类型的值。注意： 由于智能转换，你可以访问该类型的方法和属性而无需 任何额外的检测。
```kotlin
fun hasPrefix(x: Any) = when(x) {
    is String -> x.startsWith("prefix")
    else -> false
}
```

---

## Kotlin 循环控制

### For 循环
for 循环可以对任何提供迭代器（iterator）的对象进行遍历，语法如下:
```kotlin
for (item in collection) print(item)
```

循环体可以是一个代码块:
```kotlin
for (item: Int in ints) {
    // ……
}
```
如上所述，for 可以循环遍历任何提供了迭代器的对象。
如果你想要通过索引遍历一个数组或者一个 list，你可以这么做：
```kotlin
for (i in array.indices) {
    print(array[i])
}
```
注意这种"在区间上遍历"会编译成优化的实现而不会创建额外对象。
或者你可以用库函数 withIndex：
```kotlin
for ((index, value) in array.withIndex()) {
    println("the element at $index is $value")
}
```

### while 与 do...while 循环
while是最基本的循环，它的结构为
```kotlin
while( 布尔表达式 ) {
  //循环内容
}

```
do…while 循环 对于 while 语句而言，如果不满足条件，则不能进入循环。但有时候我们需要即使不满足条件，也至少执行一次。
do…while 循环和 while 循环相似，不同的是，do…while 循环至少会执行一次。
```kotlin
do {
       //代码语句
}while(布尔表达式);
```

### 返回和跳转
Kotlin 有三种结构化跳转表达式：
- return。默认从最直接包围它的函数或者匿名函数返回。
- break。终止最直接包围它的循环。
- continue。继续下一次最直接包围它的循环。

在循环中 Kotlin 支持传统的 break 和 continue 操作符。
```kotlin
fun main(args: Array<String>) {
    for (i in 1..10) {
        if (i==3) continue  // i 为 3 时跳过当前循环，继续下一次循环
        println(i)
        if (i>5) break   // i 为 6 时 跳出循环
    }
}
```

---
## Kotlin 类和对象
### 类定义
Kotlin 类可以包含：构造函数和初始化代码块、函数、属性、内部类、对象声明。
Kotlin 中使用关键字 class 声明类，后面紧跟类名：
```kotlin
class Runoob {  // 类名为 Runoob
    // 大括号内是类体构成
}
```
我们也可以定义一个空类：
```kotlin
class Empty
```
可以在类中定义成员函数：
```kotlin
class Runoob() {
    fun foo() { print("Foo") } // 成员函数
}
```

### 类的属性
#### 属性定义
类的属性可以用关键字 var 声明为可变的，否则使用只读关键字 val 声明为不可变。
```kotlin
class Runoob {
    var name: String = ……
    var url: String = ……
    var city: String = ……
}
```
我们可以像使用普通函数那样使用构造函数创建类实例：
```kotlin
val site = Runoob() // Kotlin 中没有 new 关键字
```
要使用一个属性，只要用名称引用它即可
```kotlin
site.name           // 使用 . 号来引用
site.url
```
Kotlin 中的类可以有一个 主构造器，以及一个或多个次构造器，主构造器是类头部的一部分，位于类名称之后:
```kotlin
class Person constructor(firstName: String) {}
```
如果主构造器没有任何注解，也没有任何可见度修饰符，那么constructor关键字可以省略。
```kotlin
class Person(firstName: String) {
}
```
#### getter 和 setter
属性声明的完整语法：
```kotlin
var <propertyName>[: <PropertyType>] [= <property_initializer>]
    [<getter>]
    [<setter>]
```
getter 和 setter 都是可选
如果属性类型可以从初始化语句或者类的成员函数中推断出来，那就可以省去类型，val不允许设置setter函数，因为它是只读的。
```kotlin
var allByDefault: Int? // 错误: 需要一个初始化语句, 默认实现了 getter 和 setter 方法
var initialized = 1    // 类型为 Int, 默认实现了 getter 和 setter
val simple: Int?       // 类型为 Int ，默认实现 getter ，但必须在构造函数中初始化
val inferredType = 1   // 类型为 Int 类型,默认实现 getter
```
**实例**
以下实例定义了一个 Person 类，包含两个可变变量 lastName 和 no，lastName 修改了 getter 方法，no 修改了 setter 方法。
```kotlin
class Person {

    var lastName: String = "zhang"
        get() = field.toUpperCase()   // 将变量赋值后转换为大写
        set

    var no: Int = 100
        get() = field                // 后端变量
        set(value) {
            if (value < 10) {       // 如果传入的值小于 10 返回该值
                field = value
            } else {
                field = -1         // 如果传入的值大于等于 10 返回 -1
            }
        }

    var heiht: Float = 145.4f
        private set
}

// 测试
fun main(args: Array<String>) {
    var person: Person = Person()

    person.lastName = "wang"

    println("lastName:${person.lastName}")

    person.no = 9
    println("no:${person.no}")

    person.no = 20
    println("no:${person.no}")

}
```
输出结果为：
lastName:WANG
no:9
no:-1

Kotlin 中的类不能有 field。但是，有时在使用自定义访问器时必须有一个 backing field ，为此，Kotlin 提供了一个自动backing field，可以使用 field 标识符来访问。
Backing Field 是 Kotlin 中的一个概念。它是一个自动生成的字段，用于存储属性的值。它只能在访问器（getter 或 setter）内部使用，并且仅在至少使用一个访问器的默认实现，或者自定义访问器通过 field 标识符引用它时才存在。这意味着，当一个属性需要一个 backing field 时，Kotlin 会自动提供它。您可以使用 field 标识符在访问器中引用 backing field。
```kotlin
var no: Int = 100
        get() = field                // 后端变量
        set(value) {
            if (value < 10) {       // 如果传入的值小于 10 返回该值
                field = value
            } else {
                field = -1         // 如果传入的值大于等于 10 返回 -1
            }
        }
```
当然，这里有一个 backing field 的例子：
```kotlin
class Person {
    var name: String = "initial value"
        set(value) {
            if (value.isNotEmpty()) {
                field = value
            }
        }
}
```
在这个例子中，name 属性有一个自定义的 setter，它检查传入的值是否为空。如果不为空，则使用 field 标识符将值分配给 backing field。这样，当我们尝试将空字符串分配给 name 属性时，它的值不会更改。
```kotlin
val person = Person()
println(person.name) // 输出 "initial value"
person.name = ""
println(person.name) // 仍然输出 "initial value"
person.name = "John"
println(person.name) // 输出 "John"
```
在上面的代码中，我们创建了一个 Person 类的实例，并尝试更改其 name 属性的值。当我们尝试将空字符串分配给它时，由于自定义 setter 的检查，name 属性的值保持不变。当我们将非空字符串分配给它时，它的值被成功更改为新值。
非空属性必须在定义的时候初始化,kotlin提供了一种可以延迟初始化的方案,使用 lateinit 关键字描述属性：
```kotlin
public class MyTest {
    lateinit var subject: TestSubject

    @SetUp fun setup() {
        subject = TestSubject()
    }

    @Test fun test() {
        subject.method()  // dereference directly
    }
}
```

### 主构造器
主构造器中不能包含任何代码，初始化代码可以放在初始化代码段中，初始化代码段使用 init 关键字作为前缀。
```kotlin
class Person constructor(firstName: String) {
    init {
        println("FirstName is $firstName")
    }
}
```
注意：主构造器的参数可以在初始化代码段中使用，也可以在类主体n定义的属性初始化代码中使用。 一种简洁语法，可以通过主构造器来定义属性并初始化属性值（可以是var或val）：
```kotlin
class People(val firstName: String, val lastName: String) {
    //...
}
```
如果构造器有注解，或者有可见度修饰符，这时constructor关键字是必须的，注解和修饰符要放在它之前。
**实例**
创建一个 Runoob类，并通过构造函数传入网站名：
```kotlin
class Runoob  constructor(name: String) {  // 类名为 Runoob
    // 大括号内是类体构成
    var url: String = "http://www.runoob.com"
    var country: String = "CN"
    var siteName = name

    init {
        println("初始化网站名: ${name}")
    }

    fun printTest() {
        println("我是类的函数")
    }
}

fun main(args: Array<String>) {
    val runoob =  Runoob("菜鸟教程")
    println(runoob.siteName)
    println(runoob.url)
    println(runoob.country)
    runoob.printTest()
}
```
输出结果为：
初始化网站名: 菜鸟教程 

菜鸟教程

http://www.runoob.com

CN

我是类的函数

### 次构造函数
类也可以有二级构造函数，需要加前缀 constructor:
```kotlin
class Person { 
    constructor(parent: Person) {
        parent.children.add(this) 
    }
}
```
如果类有主构造函数，每个次构造函数都要，或直接或间接通过另一个次构造函数代理主构造函数。在同一个类中代理另一个构造函数使用 this 关键字：
```kotlin
class Person(val name: String) {
    constructor (name: String, age:Int) : this(name) {
        // 初始化...
    }
}
```
如果一个非抽象类没有声明构造函数(主构造函数或次构造函数)，它会产生一个没有参数的构造函数。构造函数是 public 。如果你不想你的类有公共的构造函数，你就得声明一个空的主构造函数：
```kotlin
class DontCreateMe private constructor () {
}
```

### 抽象类
抽象是面向对象编程的特征之一，类本身，或类中的部分成员，都可以声明为abstract的。抽象成员在类中不存在具体的实现。
注意：无需对抽象类或抽象成员标注open注解。
```kotlin
open class Base {
    open fun f() {}
}

abstract class Derived : Base() {
    override abstract fun f()
}
```

### 嵌套类
我们可以把类嵌套在其他类中，看以下实例：
```kotlin
class Outer {                  // 外部类
    private val bar: Int = 1
    class Nested {             // 嵌套类
        fun foo() = 2
    }
}

fun main(args: Array<String>) {
    val demo = Outer.Nested().foo() // 调用格式：外部类.嵌套类.嵌套类方法/属性
    println(demo)    // == 2
}
```

### 内部类
内部类使用 inner 关键字来表示。 
内部类会带有一个对外部类的对象的引用，所以内部类可以访问外部类成员属性和成员函数。
```kotlin
class Outer {
    private val bar: Int = 1
    var v = "成员属性"
    /**嵌套内部类**/
    inner class Inner {
        fun foo() = bar  // 访问外部类成员
        fun innerTest() {
            var o = this@Outer //获取外部类的成员变量
            println("内部类可以引用外部类的成员，例如：" + o.v)
        }
    }
}

fun main(args: Array<String>) {
    val demo = Outer().Inner().foo()
    println(demo) //   1
    val demo2 = Outer().Inner().innerTest()   
    println(demo2)   // 内部类可以引用外部类的成员，例如：成员属性
}
```
为了消除歧义，要访问来自外部作用域的 this，我们使用this@label，其中 @label 是一个 代指 this 来源的标签。

### 匿名内部类
使用对象表达式来创建匿名内部类：
```kotlin
class Test {
    var v = "成员属性"

    fun setInterFace(test: TestInterFace) {
        test.test()
    }
}

/**
 * 定义接口
 */
interface TestInterFace {
    fun test()
}

fun main(args: Array<String>) {
    var test = Test()

    /**
     * 采用对象表达式来创建接口对象，即匿名内部类的实例。
     */
    test.setInterFace(object : TestInterFace {
        override fun test() {
            println("对象表达式创建匿名内部类的实例")
        }
    })
}
```

### 类的修饰符
类的修饰符包括 classModifier 和_accessModifier_:
- classModifier: 类属性修饰符，标示类本身特性。
```kotlin
abstract    // 抽象类  
final       // 类不可继承，默认属性
enum        // 枚举类
open        // 类可继承，类默认是final的
annotation  // 注解类
```
- accessModifier: 访问权限修饰符
```kotlin
private    // 仅在同一个文件中可见
protected  // 同一个文件中或子类可见
public     // 所有调用的地方都可见
internal   // 同一个模块中可见
```

---
## Kotlin 接口
Kotlin 接口与 Java 8 类似，使用 interface 关键字定义接口，允许方法有默认实现：
```kotlin
interface MyInterface {
    fun bar()    // 未实现
    fun foo() {  //已实现
      // 可选的方法体
      println("foo")
    }
}
```
**实现接口**
一个类或者对象可以实现一个或多个接口。
```kotlin
class Child : MyInterface {
    override fun bar() {
        // 方法体
    }
}
```

- 实例
```kotlin
interface MyInterface {
    fun bar()
    fun foo() {
        // 可选的方法体
        println("foo")
    }
}
class Child : MyInterface {
    override fun bar() {
        // 方法体
        println("bar")
    }
}
fun main(args: Array<String>) {
    val c =  Child()
    c.foo();
    c.bar();
 
}
```

### 接口中的属性
接口中的属性只能是抽象的，不允许初始化值，接口不会保存属性值，实现接口时，必须重写属性：
```kotlin
interface MyInterface{
    var name:String //name 属性, 抽象的
}
 
class MyImpl:MyInterface{
    override var name: String = "runoob" //重写属性
}
```
- 实例
```kotlin
interface MyInterface {
    var name:String //name 属性, 抽象的
    fun bar()
    fun foo() {
        // 可选的方法体
        println("foo")
    }
}
class Child : MyInterface {
    override var name: String = "runoob" //重写属性
    override fun bar() {
        // 方法体
        println("bar")
    }
}
fun main(args: Array<String>) {
    val c =  Child()
    c.foo();
    c.bar();
    println(c.name)
 
}
```

### 函数重写
实现多个接口时，可能会遇到同一方法继承多个实现的问题。例如:
```kotlin
interface A {
    fun foo() { print("A") }   // 已实现
    fun bar()                  // 未实现，没有方法体，是抽象的
}
 
interface B {
    fun foo() { print("B") }   // 已实现
    fun bar() { print("bar") } // 已实现
}
 
class C : A {
    override fun bar() { print("bar") }   // 重写
}
 
class D : A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }
 
    override fun bar() {
        super<B>.bar()
    }
}
 
fun main(args: Array<String>) {
    val d =  D()
    d.foo();
    d.bar();
}
```
输出结果为： ABbar
实例中接口 A 和 B 都定义了方法 foo() 和 bar()， 两者都实现了 foo(), B 实现了 bar()。因为 C 是一个实现了 A 的具体类，所以必须要重写 bar() 并实现这个抽象方法。
然而，如果我们从 A 和 B 派生 D，我们需要实现多个接口继承的所有方法，并指明 D 应该如何实现它们。这一规则 既适用于继承单个实现（bar()）的方法也适用于继承多个实现（foo()）的方法。